package com.thoughtmechanix.licenses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@RefreshScope
public class ServerConfig {
    @Value("${example.property}")
    private String exampleProperty;

    public String getExampleProperty() {
        return exampleProperty;
    }
}
