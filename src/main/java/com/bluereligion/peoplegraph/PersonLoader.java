package com.bluereligion.peoplegraph;

import java.io.IOException;
import java.util.Map;

public interface PersonLoader {

	Map<String, Person> loadPersons(String source) throws IOException, IllegalStateException;
	
}
