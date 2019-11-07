package com.bluereligion.peoplegraph;

public class Relationship {
	
	private String parentKey;	
	public String getParentKey() { return parentKey; }
	public void setParentKey(String parentKey) { this.parentKey = parentKey; }
	
	private String childKey;	
	public String getChildKey() { return childKey; }
	public void setChildKey(String childKey) { this.childKey = childKey; }
	
	private RelationshipType relationshipType;	
	public RelationshipType getRelationshipType() { return relationshipType; }
	public void setRelationshipType(RelationshipType relationshipType) { this.relationshipType = relationshipType; }

    public Relationship(String parentKey, String childKey, RelationshipType relationshipType) {
    	super();
    	this.parentKey = parentKey;
    	this.childKey = childKey;
    	this.relationshipType = relationshipType;
    }

}
