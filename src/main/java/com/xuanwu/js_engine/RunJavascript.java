package com.xuanwu.js_engine;

import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 运行javascript
 * 
 * @author jianggujin
 *
 */
public class RunJavascript {

	public static String invokeFunctionWithParam(String js, String function, String... params)
			throws ScriptException, NoSuchMethodException, IOException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.eval(js);
		Invocable invocable = (Invocable) engine;
		String result = String.valueOf(invocable.invokeFunction(function, params));
		return result;
	}

	public static void main(String[] args) throws IOException, NoSuchMethodException, ScriptException {
		String js = FileUtil.loadFile("src/main/resources/sm4.js");
		String originText = "a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊";
		System.out.println("原文 ：" + originText);
		String ciphertext = invokeFunctionWithParam(js, "encond_sms4", originText);
		System.out.println("密文：" + ciphertext);
		String plaintext = invokeFunctionWithParam(js, "decond_sms4", ciphertext);
		System.out.println("明文：" + plaintext);
		System.out.println(plaintext.equals(originText));
	}

}