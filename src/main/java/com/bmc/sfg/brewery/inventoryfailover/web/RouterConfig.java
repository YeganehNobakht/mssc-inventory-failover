package com.bmc.sfg.brewery.inventoryfailover.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import javax.ws.rs.core.MediaType;

/**
 * @author Masoumeh Yeganeh
 * @created 27/06/2023
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler){
        return route(GET("/inventory-failover").and(accept(org.springframework.http.MediaType.valueOf(MediaType.APPLICATION_JSON))),
                inventoryHandler::listInventory);
    }
}