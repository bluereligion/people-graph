package com.bluereligion.peoplegraph;

public interface PersonService {
	
	public int getPopulationSize();	
	
	public int getRelationshipCount(String personId);	
	
	public int getExtendedFamilyCount(String personId);	

}
