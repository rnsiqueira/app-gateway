package br.com.rns.app_gateway.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpMethod;

import java.util.Objects;

@Document("RequestDatail")
public class RequestDatail {


    @Id
    private String id;
    private String hostAddress;
    private String agent;
    private String uri;
    private HttpMethod method;

    public RequestDatail(String hostAddress, String agent, String uri, HttpMethod method) {
        this.hostAddress = hostAddress;
        this.agent = agent;
        this.uri = uri;
        this.method = Objects.isNull(method) ? null : method;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "RequestDatail{" +
                "id='" + id + '\'' +
                ", hostAddress='" + hostAddress + '\'' +
                ", agent='" + agent + '\'' +
                ", uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
