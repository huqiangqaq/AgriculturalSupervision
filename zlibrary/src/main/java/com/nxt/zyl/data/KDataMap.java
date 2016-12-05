package com.nxt.zyl.data;

import java.util.HashMap;

/**
 * 请求参数
 *
 * @author koneloong koneloong@gmail.com
 *         Created on 2015/9/3 10:22.
 * @version 1.0
 * @since 1.0
 */
public class KDataMap<T> extends HashMap<String, T> {
    public KDataMap<T> with(String key, T value) {
        put(key, value);
        return this;
    }
}
