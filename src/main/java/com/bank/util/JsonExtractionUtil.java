package com.bank.util;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.jsoniter.JsonIterator;

public class JsonExtractionUtil {

	public static void main(String[] args) throws IOException {
		String s = IOUtils.toString(new FileReader("test.json"));
		JsonIterator iter = JsonIterator.parse(s);
		System.out.println("$$$$$$$$$$$$$" + iter.readAny().get("users").get(0).get("isActive"));

	}

	public static int calc(JsonIterator iter) throws IOException {
		int totalTagsCount = 0;
		for (String field = iter.readObject(); field != null; field = iter.readObject()) {
			switch (field) {
			case "users":
				while (iter.readArray()) {
					for (String field2 = iter.readObject(); field2 != null; field2 = iter.readObject()) {
						switch (field2) {
						case "gender":
							while (iter.readArray()) {
								iter.skip();
								totalTagsCount++;
							}
							break;
						default:
							iter.skip();
						}
					}
				}
				break;
			default:
				iter.skip();
			}
		}
		return totalTagsCount;
	}

}
