package com.xuanwu.js_engine;

import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SingletonTest {

	private static final String origin = "a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊";

	public static void main(String[] args) throws NoSuchMethodException, ScriptException, IOException {
		String js = FileUtil.loadFile("src/main/resources/sm4.js");
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.eval(js);
		Invocable invocable = (Invocable) engine;
		String result = String.valueOf(invocable.invokeFunction("encond_sms4", origin));
		System.out.println(result);

		
		for (int i = 0; i < 10000; i++) {
			long now = System.currentTimeMillis();
			String ciphertext = String.valueOf(invocable.invokeFunction("encond_sms4", origin));
			System.out.println("加密："+(System.currentTimeMillis() - now));
			now = System.currentTimeMillis();
			String plaintext = String.valueOf(invocable.invokeFunction("decond_sms4", ciphertext));
			System.out.println("解密："+(System.currentTimeMillis() - now));
			System.out.println(origin.equals(plaintext));
		}
		
	}

}
