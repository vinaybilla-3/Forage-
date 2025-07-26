package com.hoen;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import com.hoen.resources.SearchResource;

public class HoenApplication extends Application<HoenConfiguration> {
    public static void main(String[] args) throws Exception {
        new HoenApplication().run(args);
    }

    @Override
    public void run(HoenConfiguration config, Environment env) throws Exception {
        env.jersey().register(new SearchResource());
    }
}
