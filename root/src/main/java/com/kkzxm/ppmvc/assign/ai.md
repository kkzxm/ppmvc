在 Spring Boot 中实现这种调用链设计会更加优雅，我们可以利用依赖注入、Spring 的组件管理以及设计模式的组合。以下是完整的 Spring Boot 实现方案：

### 设计思路
1. **使用责任链模式**：每个处理器作为 Spring Bean
2. **策略模式**：通过配置选择新旧链
3. **依赖注入**：利用 `@Autowired` 自动装配处理器链
4. **工厂模式**：创建不同版本的调用链
5. **条件配置**：使用 `@Profile` 或 `@Conditional` 管理不同场景的链

### 完整实现代码

#### 1. 定义处理器接口
```java
public interface Processor<T> {
    T process(Context context);
}

// 上下文对象（传递数据）
public class Context {
    private Map<String, Object> data = new HashMap<>();
    
    public void put(String key, Object value) {
        data.put(key, value);
    }
    
    public Object get(String key) {
        return data.get(key);
    }
}
```

#### 2. 实现具体处理器（Spring Bean）
```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 原型作用域，每次获取新实例
public class A implements Processor<A> {
    
    private Processor<?> next;
    
    // 通过setter注入下一个处理器
    public void setNext(Processor<?> next) {
        this.next = next;
    }

    @Override
    public A process(Context context) {
        System.out.println("A processing...");
        if (next != null) {
            Object result = next.process(context);
            System.out.println("A received: " + result.getClass().getSimpleName());
        }
        return this;
    }
}

// 其他处理器类似实现（B, C, D, Z）
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class B implements Processor<B> {
    // 实现类似A...
}

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Z implements Processor<Z> {
    @Override
    public Z process(Context context) {
        System.out.println("Z processing...");
        context.put("result", "Final result from Z");
        return this;
    }
}
```

#### 3. 创建链装配工厂
```java
@Component
public class ChainFactory {
    
    @Autowired
    private ApplicationContext context;
    
    public enum ChainType {
        OLD, NEW, EXTENDED // 支持多种链类型
    }
    
    public Processor<?> createChain(ChainType type) {
        // 从Spring容器获取原型Bean
        Z z = context.getBean(Z.class);
        
        switch (type) {
            case OLD:
                C c = context.getBean(C.class);
                c.setNext(z);
                
                A aOld = context.getBean(A.class);
                aOld.setNext(c);
                return aOld;
                
            case NEW:
                D d = context.getBean(D.class);
                d.setNext(z);
                
                C cNew = context.getBean(C.class);
                cNew.setNext(d);
                
                B b = context.getBean(B.class);
                b.setNext(cNew);
                
                A aNew = context.getBean(A.class);
                aNew.setNext(b);
                return aNew;
                
            default:
                throw new IllegalArgumentException("Unsupported chain type");
        }
    }
}
```

#### 4. 创建配置类管理不同链
```java
@Configuration
public class ChainConfiguration {
    
    @Autowired
    private ChainFactory chainFactory;
    
    // 旧链配置 (使用Profile激活)
    @Bean
    @Profile("old-chain")
    public Processor<?> oldChain() {
        return chainFactory.createChain(ChainFactory.ChainType.OLD);
    }
    
    // 新链配置
    @Bean
    @Profile("new-chain")
    public Processor<?> newChain() {
        return chainFactory.createChain(ChainFactory.ChainType.NEW);
    }
    
    // 动态选择链的服务
    @Bean
    public ChainService chainService() {
        return new ChainService();
    }
}
```

#### 5. 链服务封装
```java
@Service
public class ChainService {
    
    @Autowired
    private ChainFactory chainFactory;
    
    public Object executeChain(ChainFactory.ChainType type) {
        Processor<?> chain = chainFactory.createChain(type);
        Context context = new Context();
        return chain.process(context);
    }
    
    // 获取上下文中的结果
    public Object getResult(Context context) {
        return context.get("result");
    }
}
```

#### 6. REST控制器（使用示例）
```java
@RestController
@RequestMapping("/api/chain")
public class ChainController {
    
    @Autowired
    private ChainService chainService;
    
    @GetMapping("/old")
    public ResponseEntity<String> executeOldChain() {
        ChainService.Context context = new ChainService.Context();
        chainService.executeChain(ChainFactory.ChainType.OLD, context);
        return ResponseEntity.ok("Old chain executed. Result: " + chainService.getResult(context));
    }
    
    @GetMapping("/new")
    public ResponseEntity<String> executeNewChain() {
        ChainService.Context context = new ChainService.Context();
        chainService.executeChain(ChainFactory.ChainType.NEW, context);
        return ResponseEntity.ok("New chain executed. Result: " + chainService.getResult(context));
    }
}
```

### 如何添加新处理器
1. **创建新处理器类**：
```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class E implements Processor<E> {
    private Processor<?> next;
    
    public void setNext(Processor<?> next) {
        this.next = next;
    }

    @Override
    public E process(Context context) {
        System.out.println("E processing...");
        if (next != null) {
            Object result = next.process(context);
            System.out.println("E received: " + result.getClass().getSimpleName());
        }
        return this;
    }
}
```

2. **更新ChainFactory**：
```java
public Processor<?> createChain(ChainType type) {
    // ... 其他链创建逻辑
    
    // 添加新链类型
    if (type == ChainType.EXTENDED) {
        Z z = context.getBean(Z.class);
        F f = context.getBean(F.class);
        f.setNext(z);
        
        E e = context.getBean(E.class);
        e.setNext(f);
        
        D d = context.getBean(D.class);
        d.setNext(e);
        
        C c = context.getBean(C.class);
        c.setNext(d);
        
        B b = context.getBean(B.class);
        b.setNext(c);
        
        A a = context.getBean(A.class);
        a.setNext(b);
        return a;
    }
}
```

3. **更新配置类**：
```java
@Configuration
public class ChainConfiguration {
    // ...
    
    @Bean
    @Profile("extended-chain")
    public Processor<?> extendedChain() {
        return chainFactory.createChain(ChainFactory.ChainType.EXTENDED);
    }
}
```

### Spring Boot特有优势
1. **依赖注入**：自动管理处理器依赖关系
2. **作用域控制**：使用 `@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)` 确保每次获取新实例
3. **配置管理**：
   - 使用 `@Profile` 激活不同链配置
   - 通过 `application.properties` 切换场景：
     ```properties
     spring.profiles.active=new-chain
     ```
4. **自动装配**：`@Autowired` 简化组件获取
5. **生命周期管理**：Spring容器管理Bean的创建和销毁
6. **AOP支持**：可方便添加日志、事务等切面

### 执行流程说明
1. 客户端调用 `/api/chain/new`
2. Controller 调用 ChainService
3. ChainService 使用 ChainFactory 创建新链
4. 工厂从Spring容器获取处理器原型实例
5. 装配处理链：A→B→C→D→Z
6. 执行链：从A开始，每个处理器执行后返回自身给上一级
7. Z处理结果存入Context
8. Controller返回结果给客户端

### 设计优势
1. **开闭原则**：新增链类型无需修改已有代码
2. **依赖倒置**：依赖接口而非具体实现
3. **单一职责**：每个类只负责自己的功能
4. **可测试性**：使用Mockito轻松单元测试
5. **灵活性**：运行时动态选择链类型
6. **可扩展性**：轻松添加新处理器

### 实际应用建议
1. **配置优化**：使用 `@ConfigurationProperties` 管理链配置
2. **异常处理**：添加全局异常处理器
3. **性能监控**：使用Spring Actuator监控链执行时间
4. **异步支持**：对耗时处理器添加 `@Async`
5. **缓存策略**：对可复用结果添加 `@Cacheable`

此实现完整展示了在Spring Boot中构建灵活可扩展调用链的最佳实践，完美支持新旧功能共存，并预留了扩展空间。