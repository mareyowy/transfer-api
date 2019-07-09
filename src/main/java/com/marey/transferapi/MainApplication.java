package com.marey.transferapi;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class MainApplication extends ResourceConfig {

    public MainApplication() {
        packages("com.marey.transferapi");
    }
}
