package com.guestlist.core;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Guest {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String firstName;
    private String middleName;
    private String lastName;
    private Map<String,Boolean> attendanceMap;

	public Guest() {
        // Jackson deserialization
    }

    public Guest(Long id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public boolean hasName() {
    	return StringUtils.isEmpty(firstName) || StringUtils.isEmpty(middleName) || StringUtils.isEmpty(lastName);
    }
    
    public String toString() {
    	return new Gson().toJson(this);
    	/*
    	  ObjectMapper mapper = new ObjectMapper( );
    	  //try {
    	  try {
    		  return mapper.writeValueAsString(this);
    	  }
    	  catch (JsonProcessingException e) {
    		  e.printStackTrace();
    	  }
    
    	  return null;
    	  */
    }
}
