package br.com.rns.app_gateway.filter;

import br.com.rns.app_gateway.Repository.RequestRepository;
import br.com.rns.app_gateway.domain.MonitoringData;
import br.com.rns.app_gateway.utils.RequestFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RequestRepository requestRepository;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Starting global filter, saving request data...");
        var request = exchange.getRequest();
        var ipAddress = request.getHeaders().getFirst("X-Forwarded-Host");
        if (Objects.isNull(ipAddress)) {
            ipAddress = request.getRemoteAddress().getAddress().getHostAddress();
        }
        var monitoringData = new MonitoringData(ipAddress,
                request.getHeaders().getFirst("user-agent"), request.getURI(), request.getMethod());

        logger.info(String.format("persisting request data in database: %s", monitoringData));
        try {
            requestRepository.save(RequestFactory.createRequestDatail(monitoringData));
        } catch (Exception e) {
            logger.error("Error persisting request data in database", e);
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
