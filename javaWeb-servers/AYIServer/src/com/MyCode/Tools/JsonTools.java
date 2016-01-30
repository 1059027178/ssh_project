package com.MyCode.Tools;

import net.sf.json.JSONObject;

/**
 * 创建json
 * @author Fanff
 *
 */
public class JsonTools {
	public JsonTools(){
	}
	/**
	 * @param key 表示json字符串的头信息
	 * @param object 解析的集合的类型
	 * @return json 字符串
	 */
	public static String createJsonString(String key, Object value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		// JSONObject类中的toString()方法：把JSONObject对象转换为json格式的字符串
		// JSONArray类中的toString()方法：把JSONArray对象转换为json格式的字符串
		return jsonObject.toString();
	}
}
