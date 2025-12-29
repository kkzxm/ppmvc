package com.kkzxm.ppmvc.assign.chian;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文对象（传递数据）
 */
public class Context {
    private final Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }
}
