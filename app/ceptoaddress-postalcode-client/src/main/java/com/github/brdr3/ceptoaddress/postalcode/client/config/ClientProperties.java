package com.github.brdr3.ceptoaddress.postalcode.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties("client")
public class ClientProperties {

    ClientProperty cep = new ClientProperty();

    @Getter
    @Setter
    public static class ClientProperty {
        String url;
    }

}
