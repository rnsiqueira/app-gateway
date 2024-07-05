package br.com.rns.app_gateway.domain;

public record FactoryObeverserRequest(String hostAddress, String agent, java.net.URI uri) {


    @Override
    public String toString() {
        return "FactoryObeverserRequest{" +
                "hostAddress='" + hostAddress + '\'' +
                ", agent='" + agent + '\'' +
                ", uri=" + uri +
                '}';
    }
}
