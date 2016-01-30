package com.MyCode.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.MyCode.Domain.Person;

/**
 * 用来提供json数据的值
 * @author Fanff
 *
 */
public class JsonService {
	public JsonService() {
	}

	public Person getPerson() {
		Person person = new Person(1001, "jack", "beijing");
		return person;
	}
	
	/**
	 * json的值的形式
	 *{"address":"beijing","id":1001,"name":"jack"}
	 */
	public List<Person> getlistPerson() {
		List<Person> list = new ArrayList<Person>();
		Person person1 = new Person(1001, "jack", "guangxi");
		Person person2 = new Person(1002, "rose", "guangdong");
		list.add(person1);
		list.add(person2);
		return list;
	}

	/**
	 * Json的值的形式
	 * ["beijing","shanghai","hunan"]
	 */
	public List<String> getListString() {
		List<String> list = new ArrayList<String>();
		list.add("beijing");
		list.add("shanghai");
		list.add("hunan");
		return list;
	}

	/**
	 * Json的值的形式
	 * {"id":1001,"address":"beijing","name":"jack"},{"id":1002,"address":"shanghai","name":"rose"}
	 */
	public List<Map<String, Object>> getListMaps() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 1001);
		map1.put("name", "jack");
		map1.put("address", "beijing");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", 1002);
		map2.put("name", "rose");
		map2.put("address", "shanghai");
		list.add(map1);
		list.add(map2);
		return list;
	}
}
