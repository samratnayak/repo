package com.basic.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class Entity {
	private String name;
	private int id;
	private String lastname;
	Entity(String name, int id, String lastname){
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString(){
		return "[ id = "+ this.id +" name = " + this.name+" lastname = "+this.lastname+"]";
	}
}

public class JsonParsing {

	public static void main(String[] args) throws IOException {
		List<Entity> entList = new ArrayList<Entity>();
		for(int i = 1; i <= 10; i++) {
			Entity e = new Entity("name "+ i, i, "lastname "+ i);
			entList.add(e);
		}
		
		String json = new ObjectMapper().writeValueAsString(entList);
		System.out.println("Json Obj" +" "+json);
		removeFromJSON(json);
	}

	private static void removeFromJSON(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedNodes =  mapper.readValue(json, JsonNode.class);
		List<Entity> parsedList = (List<Entity>) mapper.readValues(mapper.treeAsTokens(parsedNodes), new TypeReference<ArrayList<Entity>>() {
		});
		Iterator<Entity> it = parsedList.iterator();
		while(it.hasNext()) {
			Entity entity = (Entity) it.next();
			if(entity.getId() % 2 == 0) {
				continue;
			}
			else {
				it.remove();
			}
		}
		/*List<Entity> newList = parsedList
		.stream()
		.filter(entity -> entity.getId() % 2 ==0)
		.collect(Collectors.toList());
		//print new list
		newList
		.stream()
		.forEach(System.out :: println);*/
	}

}
