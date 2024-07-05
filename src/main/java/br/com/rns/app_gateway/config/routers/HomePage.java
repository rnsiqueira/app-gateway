package br.com.rns.app_gateway.config.routers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private RouteLocator route;


    @Bean
    public RouteLocator homePageRoutes(RouteLocatorBuilder builder) {
        logger.info("Starting home page routes configuration...");

        route = builder.routes()
                .route("router-home", p -> p
                        .path("/store/home")
                        .filters(f -> f.setStatus(401))
                        .uri("http://httpbin.org:80"))
//                .route("router-home-redirect", p -> p
//                        .host("https://localhost:3000")
//                        .filters(f -> f.circuitBreaker(c -> c.setName("homeCircuitBreaker").setFallbackUri("forward:/store/home"))
//                                .setStatus(401))
//                        .uri("http://httpbin.org:80"))
                .build();


        return route;
    }

    public RouteLocator getRoute() {
        return route;
    }
}
