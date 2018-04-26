package com.xuanwu.js_engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	public static String loadFile(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		StringBuffer sb = new StringBuffer();
		String temp;
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			temp = br.readLine();
			while (temp != null) {
				sb.append(temp);
				temp = br.readLine();
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(loadFile("src/main/resources/index.html"));
	}
	
}
