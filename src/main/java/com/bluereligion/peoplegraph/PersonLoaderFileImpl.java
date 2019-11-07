package com.bluereligion.peoplegraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonLoaderFileImpl implements PersonLoader {

	private static final String DELIMITER = ",";
	
	@Override
	public Map<String, Person> loadPersons(String source) throws IOException, IllegalStateException {
		
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

	    Map<String, Person> persons = new HashMap<String, Person>(lines.size());
	    
        for ( String s : lines ) {
		    String[] parts = s.split(DELIMITER);
		    
		    if ( parts.length == 3 ) {
		       Person p = new Person(parts[1], parts[0], Integer.parseInt(parts[2]));
		       persons.put(p.getId(), p);
		    }
        }
		return persons;
	}

}
