package com.lavax.jsUtils;

import java.lang.reflect.Proxy;

/**
 * Created by LAVAX on 2017/11/16.
 */
public class JsProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> jsInterface, String script) {
        final JsProxy jsProxy = new JsProxy(script);
        return (T) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{jsInterface},
                jsProxy
        );
    }
}
