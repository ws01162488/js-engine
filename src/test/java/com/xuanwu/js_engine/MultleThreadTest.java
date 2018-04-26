package com.xuanwu.js_engine;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.script.ScriptException;

public class MultleThreadTest {

	private CountDownLatch countDDown = new CountDownLatch(10);
	
	private static final ThreadLocal<SMS4JSEngine> threadlocal = new ThreadLocal<SMS4JSEngine>() {
		
		@Override
		public SMS4JSEngine initialValue() {
			String js;
			SMS4JSEngine engine = null;
			try {
				js = FileUtil.loadFile("src/main/resources/sm4.js");
				 engine = new SMS4JSEngine(js);
			} catch (IOException | ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("initial!");
			return engine;
		}
	};

	public void init() throws IOException, ScriptException, InterruptedException {
		
		Executor executor = Executors.newFixedThreadPool(10);
		for(int i=0;i<1;i++) {
			executor.execute(worker);
		}
		countDDown.await();
	}

	private Runnable worker = new Runnable() {

		@Override
		public void run() {
			String originText = "a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊a啊";
			for (int i = 0; i < 100000; i++) {
				long now = System.currentTimeMillis();
				SMS4JSEngine engine = threadlocal.get();
				String ciphertext = engine.encrypt(originText);
				long t1 = System.currentTimeMillis();
				System.out.println("加密：" + (t1 - now));
				String plaintext = engine.decrypt(ciphertext);
				System.out.println("解密" + (System.currentTimeMillis() - t1));
				System.out.println(plaintext.equals(originText));
			}
			countDDown.countDown();

		}

	};

	public static void main(String[] args) throws IOException, ScriptException, InterruptedException {
		new MultleThreadTest().init();
	}

}
