package com.xuanwu.js_engine;

import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSEngine {
	
	private Invocable invocable;
	
	public JSEngine(String js) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.eval(js);
		invocable = (Invocable) engine;
	}
	
	public String execute(String function, String... params)
			throws ScriptException, NoSuchMethodException, IOException {
		return String.valueOf(invocable.invokeFunction(function, params));
	}

}
