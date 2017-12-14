package com.lavax.jsUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LAVAX on 2017/11/15.
 */
public class JsProxy implements InvocationHandler {
    private String script;

    public JsProxy(String script) {
        this.script = script;
    }

    private Map<String, Object> convertArgs(Method method, Object[] args) {
        Map<String, Object> argMap = new HashMap<>();
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            Annotation[] as = annotations[i];
            boolean hasJsParam = false;
            for (Annotation a : as) {
                if (a instanceof JsParam) {
                    hasJsParam = true;
                    JsParam param = (JsParam) a;
                    argMap.put(param.value(), args[i]);
                    break;
                }
            }
            if (!hasJsParam) {
                throw new RuntimeException("接口参数必须设定@JsParam注解");
            }
        }
        return argMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<String, Object> argMap = convertArgs(method, args);
        Object result = JsUtil.execScript(script, argMap);
        result = org.apache.commons.beanutils.ConvertUtils.convert(result, method.getReturnType());
        return result;
    }


}
