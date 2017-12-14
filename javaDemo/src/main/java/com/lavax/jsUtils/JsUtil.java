package com.lavax.jsUtils;

import com.google.gson.Gson;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Map;

/**
 * Created by LAVAX on 2017/11/15.
 */
public class JsUtil {
    private static final Gson G = new Gson();

    /**
     * 执行脚本
     *
     * @param script
     * @param params
     * @return
     */
    public static Object execScript(String script, Map<String, Object> params) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            for (String key : params.keySet()) {
                String json = G.toJson(params.get(key));
                engine.eval("var " + key + " = " + json + ";");
            }
            return engine.eval(script);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
