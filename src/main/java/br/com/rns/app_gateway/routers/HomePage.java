package br.com.rns.app_gateway.routers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);


    @Bean
    public RouteLocator homePageRoutes(RouteLocatorBuilder builder) {
        logger.info("Starting home page routes configuration...");

        return builder.routes()
                .route("get", p -> p.path("/get").uri("http://httpbin.org:80"))
                .route("path_route", p -> p
                        .path("/store/home")
                        .filters(f -> f.redirect(302, "https://www.youtube.com/watch?v=ODkctLpqrFA&list=RDODkctLpqrFA&start_radio=1"))
                        .uri("http://httpbin.org:80"))
                .build();

    }
}
