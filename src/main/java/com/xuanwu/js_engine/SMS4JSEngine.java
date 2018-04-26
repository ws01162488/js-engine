package com.xuanwu.js_engine;

import java.io.IOException;

import javax.script.ScriptException;

public class SMS4JSEngine extends JSEngine {

	private static final String ENCRYPT_METHOD = "encrypt_sms4";
	private static final String DECRYPT_METHOD = "decrypt_sms4";

	public SMS4JSEngine(String js) throws ScriptException {
		super(js);
	}

	public String encrypt(String plaintext) {
		String result = "";
		try {
			result = execute(ENCRYPT_METHOD, plaintext);
		} catch (NoSuchMethodException | ScriptException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String decrypt(String ciphertext) {
		String result = "";
		try {
			result = execute(DECRYPT_METHOD, ciphertext);
		} catch (NoSuchMethodException | ScriptException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
