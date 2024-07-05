package br.com.rns.app_gateway.config;

import br.com.rns.app_gateway.domain.FactoryObeverserRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class GatewayGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LogManager.getLogger(GatewayGlobalFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var request = exchange.getRequest();
        var ipAddress = request.getHeaders().getFirst("X-Forwarded-Host");
        if(Objects.isNull(ipAddress)) {
            ipAddress = request.getRemoteAddress().getAddress().getHostAddress();
        }
        var factoryObeverserRequest = new FactoryObeverserRequest(ipAddress,
                request.getHeaders().getFirst("user-agent"), request.getURI());

        logger.info("Request: " + factoryObeverserRequest);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
