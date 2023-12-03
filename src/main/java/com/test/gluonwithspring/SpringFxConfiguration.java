package com.test.gluonwithspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFxConfiguration {

    @Bean
    public String helloWorldMessage() {
        return "Welcome to JavaFX Application !";
    }

}
