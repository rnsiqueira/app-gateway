package br.com.rns.app_gateway.utils;

import br.com.rns.app_gateway.domain.MonitoringData;
import br.com.rns.app_gateway.model.RequestDatail;

public class RequestFactory {


    public static RequestDatail createRequestDatail(MonitoringData monitoringData) {
        return new RequestDatail(monitoringData.hostAddress(), monitoringData.agent(), monitoringData.uri().toString(), monitoringData.method());
    }
}
