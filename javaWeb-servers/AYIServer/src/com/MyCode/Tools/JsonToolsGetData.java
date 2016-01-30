package com.MyCode.Tools;

import net.sf.json.JSONObject;
import com.qianyang.model.Users;

public class JsonToolsGetData {
	
	public static Users getUsers(String key, String jsonString){
		Users users = new Users();
		try {
			JSONObject json = JSONObject.fromObject(jsonString); 
			JSONObject personObject = json.getJSONObject("regedit");

			users.setUserName(personObject.getString("userName").trim());
			users.setUserPaswd(personObject.getString("userPaswd").trim());
			users.setUserPhone(personObject.getString("userPhone").trim());
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return users;
	}

}
