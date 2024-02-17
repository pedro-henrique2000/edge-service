package com.project.edgeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class WebEndpoints {


    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

        return RouterFunctions.route()
            .GET("/catalog-fallback", request -> {
                System.out.println("Calling fallback method for GET");
                return ServerResponse.ok().body(Mono.just(""), String.class);
            })
            .POST("/catalog-fallback", request -> {
                System.out.println("Calling fallback method for POST");
                return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build();
            })
            .build();

    }

}
