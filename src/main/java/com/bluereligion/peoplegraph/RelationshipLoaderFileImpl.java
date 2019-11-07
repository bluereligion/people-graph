package com.bluereligion.peoplegraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelationshipLoaderFileImpl implements RelationshipLoader {

	private static final String DELIMITER = ",";
	
	@Override
	public List<Relationship> loadRelationships(String source) throws IOException, IllegalStateException {
		
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(source)));
		String line;
		
		while ( (line = reader.readLine()) != null ) {
			lines.add(line);
		}
        
        if ( lines.size() < 1 ) {
           throw new IllegalStateException("No relationships detected in file="+source);
        }

	    List<Relationship> relationships = new ArrayList<Relationship>(lines.size());
	    
        for ( String s : lines ) {
		    String[] parts = s.split(DELIMITER);
		    
		    if ( parts.length == 3 ) {
		       Relationship r = new Relationship(parts[0], parts[2], RelationshipType.getInstance(parts[1]));
		       relationships.add(r);
		    }
        }
		return relationships;        
	}

}
