package com.bluereligion.peoplegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

	private String id;	
	public String getId() {	return id; }
	public void setId(String id) { this.id = id; }

	private String firstName;	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	private int age;	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	private Map<RelationshipType, List<String>> relationships;
	
    public List<String> getFamily() { 
    	return relationships.get(RelationshipType.FAMILY);
    }
	
    public int getRelationshipsSize() {
        int count = 0;
        count += this.relationships.get(RelationshipType.FAMILY).size();
        count += this.relationships.get(RelationshipType.FRIEND).size();        
    	return count;
    }
    
    public Map getRelationships() {
    	return relationships;
    }
    
	public Person(String id, String firstName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.age = age;
		this.relationships = new HashMap<RelationshipType, List<String>>();
		this.relationships.put(RelationshipType.FAMILY, new ArrayList<String>());
		this.relationships.put(RelationshipType.FRIEND, new ArrayList<String>());
	}

	
	public void addRelationship(RelationshipType relationshipType, String child) {
		relationships.get(relationshipType).add(child);
	}
	
}
