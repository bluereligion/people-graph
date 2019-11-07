package com.bluereligion.peoplegraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonServiceInMemoryImpl 
   implements PersonService {
	
	private Map<String, Person> persons = new HashMap<String, Person>(15);
	private PersonLoader personLoader = new PersonLoaderFileImpl();
	private RelationshipLoader relationshipLoader = new RelationshipLoaderFileImpl();
	
	public PersonServiceInMemoryImpl(String personSource, String relationshipSource) throws Exception {
		super();
		this.loadPersons(personSource);
		this.loadRelationships(relationshipSource);
	}

	protected void loadPersons(String source) throws Exception {
		this.persons = this.personLoader.loadPersons(source);
	}	
	
	protected void loadRelationships(String source) throws Exception {
		List<Relationship> relationships = this.relationshipLoader.loadRelationships(source);
		
		for ( Relationship r : relationships ) {
			
		 	Person p = persons.get(r.getParentKey());
			p.addRelationship(r.getRelationshipType(), r.getChildKey());
			
			p = persons.get(r.getChildKey());
			p.addRelationship(r.getRelationshipType(), r.getParentKey());	
			
		}
	}
	
	public int getPopulationSize() {
		return this.persons.size();
	}
	
	public int getRelationshipCount(String personId) {
		return this.persons.get(personId).getRelationshipsSize();
	}

	public int getExtendedFamilyCount(String personId) {
		Set<String> counted = new HashSet<String>();
		Person p = this.persons.get(personId);
		counted = calulateRecursiveFamily(p, counted);
		return counted.size();
	}	
	
	private Set<String> calulateRecursiveFamily(Person parent, Set<String> counted) {
		counted.add(parent.getId());
		
		for ( String s : parent.getFamily() ) {
			if ( !counted.contains(s) ) {
			   counted.add(s);	
			   calulateRecursiveFamily(persons.get(s), counted);
			}
		}
		return counted;
	}
	
}
