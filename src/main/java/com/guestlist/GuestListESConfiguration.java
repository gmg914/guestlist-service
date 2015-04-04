package com.guestlist;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class GuestListESConfiguration extends Configuration {
	/*
    @NotEmpty
    private String elasticsearchHost = "localhost:9200";
 
    @NotEmpty
    private String clusterName = "elasticsearch";
 
    @JsonProperty
    public String getElasticsearchHost() {
        return elasticsearchHost;
    }
 
    @JsonProperty
    public void setElasticsearchHost(String elasticsearchHost) {
        this.elasticsearchHost = elasticsearchHost;
    }
 
    @JsonProperty
    public String getClusterName() {
        return clusterName;
    }
 
    @JsonProperty
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }
    */
}