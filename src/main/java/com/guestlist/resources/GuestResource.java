package com.guestlist.resources;

import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.guestlist.core.Guest;

@Path("/guest")
@Produces(MediaType.APPLICATION_JSON)
public class GuestResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(GuestResource.class);

    private Client client;
    
    public GuestResource(Client client) {
    	this.client = client;
    }

    @GET
    public Guest sayHello(@QueryParam("id") Long id) {
    	GetRequestBuilder getRequestBuilder = client.prepareGet("guestlist", "guest", id.toString());
    	GetResponse response = getRequestBuilder.execute().actionGet();
    	LOGGER.info("EsResponse String: {}", response.toString());
    	LOGGER.info("EsResponse first_name: {}", response.getSourceAsString());
    	LOGGER.info("EsResponse Id: {}", response.getId());
    	
    	Map<String,Object> source = response.getSource();
    	LOGGER.info("EsResponse keySet: {}", source.keySet());
    	Guest guest = new Guest(id,(String)source.get("firstName"),null,(String)source.get("lastName"));

    	return guest;
    }

    @POST
    public void receiveHello(@Valid Guest guest) {
        LOGGER.info("receiveHello: {}", guest);
        
        if(guest == null || guest.getId() == null || !guest.hasName()) {
        	throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    	
    	IndexRequest indexRequest = new IndexRequest("guestlist","guest", guest.getId().toString());
    	indexRequest.source(new Gson().toJson(guest));
    	IndexResponse response = client.index(indexRequest).actionGet();
    	LOGGER.info("response: {}", response.toString());
    }
}
