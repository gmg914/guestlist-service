package com.guestlist;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.guestlist.es.managed.ManagedEsClient;
import com.guestlist.resources.GuestResource;

public class GuestListApplication extends Application<GuestListConfiguration> {
    public static void main(String[] args) throws Exception {
        new GuestListApplication().run(args);
    }

    @Override
    public String getName() {
        return "guestlist";
    } 
    
    @Override
    public void initialize(Bootstrap<GuestListConfiguration> bootstrap) {
        //bootstrap.setName("guestlist");
    }

    @Override
    public void run(GuestListConfiguration configuration,
                    Environment environment) {
    	//environment.addResource(new GuestResource());
    	final ManagedEsClient managedClient = new ManagedEsClient(configuration.getEsConfiguration());
    	environment.lifecycle().manage(managedClient);
    	
    	final GuestResource resource = new GuestResource(managedClient.getClient());
        environment.jersey().register(resource);
    }    
    /*
    @Override
    public void run(GuestListConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {

    	//Client client = ESClientFactorybean.obtainClient(config.getElasticsearchHost(), config.getClusterName());
        environment.addResource(new GuestResource());
        //environment.addResource(new IndexResource());
    }
    */
}
