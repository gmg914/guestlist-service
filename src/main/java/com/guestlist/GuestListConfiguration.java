package com.guestlist;

import org.hibernate.validator.constraints.NotEmpty;

import com.guestlist.core.GuestTemplate;
import com.guestlist.es.config.EsConfiguration;

import io.dropwizard.Configuration;

//TODO: Make this actually useful
public class GuestListConfiguration extends Configuration {
    @NotEmpty
    private String template;
    
    @NotEmpty
    private String defaultName;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public GuestTemplate buildTemplate() {
        return new GuestTemplate(template, defaultName);
    }
    
    public EsConfiguration getEsConfiguration() {
    	return new EsConfiguration();
    }
}
