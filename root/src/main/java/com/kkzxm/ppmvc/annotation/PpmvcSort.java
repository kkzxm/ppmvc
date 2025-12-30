package com.kkzxm.ppmvc.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.kkzxm.ppmvc.entity.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

// 注解作用于类上
@Target({java.lang.annotation.ElementType.TYPE})
// 注解在运行时可见
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
// 允许子类继承该注解
@Inherited
public @interface PpmvcSort {
    @Min(0)
    @Max(10)
    int value();
    String name() default "";
    Class<? extends BaseEntity> clazz() default BaseEntity.class;
}
