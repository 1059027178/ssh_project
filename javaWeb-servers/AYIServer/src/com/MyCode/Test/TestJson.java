package com.MyCode.Test;

import com.MyCode.Service.JsonService;
import com.MyCode.Tools.JsonTools;

/**
 * 此处仅测试了JSONObject
 * @author Fanff
 *
 */
public class TestJson {
	public static void main(String[] args) {
		 String msg = "";
		 JsonService service = new JsonService();
		 msg = JsonTools.createJsonString("person", service.getPerson());
		// {"person":{"address":"beijing","id":1001,"name":"jack"}}
		 System.out.println(msg);
		 msg = JsonTools.createJsonString("persons", service.getListString());
		 // {"persons":["beijing","shanghai","hunan"]}
		 System.out.println(msg);
		 msg = JsonTools.createJsonString("persons", service.getListMaps());
		// {"persons":[{"id":1001,"address":"beijing","name":"jack"},{"id":1002,"address":"shanghai","name":"rose"}]}
		 System.out.println(msg);
	}
}
