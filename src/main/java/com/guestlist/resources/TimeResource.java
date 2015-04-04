package com.guestlist.resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import com.guestlist.core.Time;

@Path("/time")
@Produces(MediaType.APPLICATION_JSON)
public class TimeResource {
	
    private final String defaultTimezone;

    public TimeResource(String defaultTimezone) {
        this.defaultTimezone = defaultTimezone;
    }
	
	@GET
	public Time getTime(@QueryParam("timezone") String timezone) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        if(StringUtils.isEmpty(timezone)) {
        	timezone = defaultTimezone;
        }
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        formatter.setTimeZone(timeZone);
        String formatted = formatter.format(new Date());
        return new Time(formatted);
	}
}