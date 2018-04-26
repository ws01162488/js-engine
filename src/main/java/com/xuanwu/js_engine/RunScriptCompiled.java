package com.xuanwu.js_engine;

import java.io.IOException;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RunScriptCompiled {
	public static void main(String[] args) throws IOException {
		ScriptEngineManager manager = new ScriptEngineManager();

		// 注意，一定要写javascript写错了就报错
		ScriptEngine engine = manager.getEngineByName("javascript");
		Compilable compilable = (Compilable) engine;

		Bindings bindings = engine.createBindings();

		String functionScript = FileUtil.loadFile("src/main/resources/sm4.js");

		String s = "encrypt_sms4(a)";

		CompiledScript fScript = null;
		CompiledScript script = null;
		try {
			fScript = compilable.compile(functionScript);
			script = compilable.compile(s);
		} catch (ScriptException e1) {
			// 如果script语法有问题会抛出异常
		}

		bindings.put("a", "a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊");
		try {
			for (int i = 0; i < 1000; i++) {
				long now = System.currentTimeMillis();
				fScript.eval(bindings);
				Object result = script.eval(bindings);
				System.out.println(System.currentTimeMillis() - now); 
			}
		} catch (ScriptException e) {
			// 运行时异常
		}
	}
}
