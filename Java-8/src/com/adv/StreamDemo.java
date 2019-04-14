package com.adv;

import java.util.HashMap;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Map;

class Entity {
	String val;
	int id;
	Entity(int id, String val){
		this.val = val;
		this.id = id;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
public class StreamDemo {

	public static void main(String[] args) {
		Map<String, Entity> map = new HashMap<>();
		map.put("Val1", new Entity(1, "ABCD"));
		map.put("Val2", new Entity(2,"ABCD"));
		map.put("Val3", new Entity(3,"ABC"));
		map.put("Val4", new Entity(4, "ABCD"));
		map.put("Val5", new Entity(5, "ABC"));
		List<String> values = map.values()
				.stream()
				.distinct()
				.map(entity -> entity.getVal())
				.collect(toList());
		List<String> value2 = map.values()
				.stream()
				.map(entity -> entity.getVal())
				.distinct()
				.collect(toList());
		System.out.println("values .. ");
		printList(values);
		System.out.println("Values2 ...");
		printList(value2);
	}

	private static void printList(List<String> values) {
		values
		.forEach(System.out :: println);
	}
}
