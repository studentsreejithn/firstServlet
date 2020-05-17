package util;

import java.io.Console;

import com.google.gson.Gson;

public class JsonConverter {

	
	public static Object jsonToObject(String jsonString,Class refClass) {
	
		Object object = null;
		Gson gson = null;
		
		try {
			
			
			gson = new Gson();
			object = gson.fromJson(jsonString, refClass);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			gson = null;
		}
		
		return object;
	}
	
	public static String objectToJson(Object object) {
		
		String json = null;
		Gson gson = null;
		
		try {
			gson = new Gson();
			json = gson.toJson(object).toString();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			gson = null;
		}
		
		return json;
	}
}
