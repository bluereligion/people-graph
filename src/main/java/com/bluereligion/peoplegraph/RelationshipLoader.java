package com.bluereligion.peoplegraph;

import java.io.IOException;
import java.util.List;

public interface RelationshipLoader {
	
	List<Relationship> loadRelationships(String source) throws IOException, IllegalStateException;

}
