package com.guestlist.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.guestlist.core.Index;

@Path("/indexes")
@Produces(MediaType.APPLICATION_JSON)
public class IndexResource {
 
    @GET
    public Index showIndexes() {
        Index index = new Index();
        index.setName("A Dummy Index");
 
        return index;
    }
}