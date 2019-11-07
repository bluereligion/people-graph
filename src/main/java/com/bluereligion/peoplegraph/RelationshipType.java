package com.bluereligion.peoplegraph;

public enum RelationshipType {
	FAMILY ("FAMILY"),
	FRIEND ("FRIEND");
	
	private String type;
	
	RelationshipType(String type) { this.type = type; }
		
	public static RelationshipType getInstance(String value) {
		for ( RelationshipType r : RelationshipType.values() ) {
			if ( r.type.equals(value) ) return r;
		}
		return null;
	}
}
