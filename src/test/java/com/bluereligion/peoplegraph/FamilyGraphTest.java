package com.neoworks.interviewtests.graph;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.bluereligion.peoplegraph.PersonService;
import com.bluereligion.peoplegraph.PersonServiceInMemoryImpl;

public class FamilyGraphTest {

    private PersonService service;

    @Before
    public void before() throws Exception {
    	service = new PersonServiceInMemoryImpl("people.csv", "relationships.csv");
    }
    
    @Test
    public void hasExpectedPopulationSize() {
    	assertEquals(service.getPopulationSize(), 12);
    }

    @Test
    public void hasExpectedRelationshipSize() {
    	assertEquals(service.getRelationshipCount("bob@bob.com"),4);
    	assertEquals(service.getRelationshipCount("jenny@toys.com"),3);
    	assertEquals(service.getRelationshipCount("nigel@marketing.com"),2);
    	assertEquals(service.getRelationshipCount("alan@lonely.org"),0);    	
    }
    
    @Test
    public void hasExpectedExtendedFamilySize() {
    	assertEquals(service.getExtendedFamilyCount("jenny@toys.com"),4);    	
    	assertEquals(service.getExtendedFamilyCount("bob@bob.com"),4);
    }    
    
}
