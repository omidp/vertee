package com.jedlab.vertee;

import io.vertx.core.AbstractVerticle;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.ServiceDiscoveryOptions;
import io.vertx.servicediscovery.types.EventBusService;

public class ConsumerVerticle extends AbstractVerticle
{

    public static void main(String[] args)
    {
        Runner.runExample(ConsumerVerticle.class);
    }

    @Override
    public void start() throws Exception
    {
        ServiceDiscovery discovery = ServiceDiscovery.create(vertx, new ServiceDiscoveryOptions(config()));
        EventBusService.getProxy(discovery, DatabaseService.class, ar ->
        {
            DatabaseService result = ar.result();
            System.out.println(result);
        });

    }

}
