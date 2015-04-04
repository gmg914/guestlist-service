package com.guestlist;

import com.guestlist.resources.TimeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TimeApplication extends Application<TimezoneConfiguration> {
    public static void main(String[] args) throws Exception {
        new TimeApplication().run(args);
    }

    @Override
    public void run(TimezoneConfiguration config, Environment environment) {
        String defaultTimezone = config.getDefaultTimezone();
        final TimeResource resource = new TimeResource(defaultTimezone);
        environment.jersey().register(resource);
        //environment.addResource(timeResource);
    }

    @Override
    public String getName() {
        return "timezone";
    }    
    
    @Override
    public void initialize(Bootstrap<TimezoneConfiguration> bootstrap) {
    	
    }

}