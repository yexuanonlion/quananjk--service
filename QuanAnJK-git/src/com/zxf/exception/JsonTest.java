package com.zxf.exception;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) throws JSONException {
		String json = "{'name':'reiz'}";
		JSONObject jsonObj = new JSONObject(json);
		String name = jsonObj.getString("name");
		 
		System.out.println(jsonObj);
		 
		jsonObj.put("initial", name.substring(0, 1).toUpperCase());
		 
		String[] likes = new String[] { "JavaScript", "Skiing", "Apple Pie" };
		jsonObj.put("likes", likes);
		 
		System.out.println(jsonObj);
		 
		Map<String, String> ingredients = new HashMap <String, String>();
		ingredients.put("apples", "3kg");
		ingredients.put("sugar", "1kg");
		ingredients.put("pastry", "2.4kg");
		ingredients.put("bestEaten", "outdoors");
		jsonObj.put("ingredients", ingredients);
		System.out.println(jsonObj);
		
		JSONObject jsonObject1 = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<=3;i++){
			Map<String, String> map = new HashMap <String, String>();
			map.put("A"+i, "B"+i);
			jsonArray.put(map);
		}
		jsonObject1.put("test", jsonArray);
		System.out.println(jsonObject1);
		
		

	}

}
