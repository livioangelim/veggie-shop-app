package com.veggieshop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Socket;

@Configuration
public class PortCheckConfig {

    private static final Logger logger = LoggerFactory.getLogger(PortCheckConfig.class);

    @Value("${server.port:8080}")
    private int serverPort;

    @Bean
    public CommandLineRunner checkPortAvailability() {
        return args -> {
            try {
                // Check if port is available by trying to create a socket
                Socket socket = new Socket("localhost", serverPort);
                socket.close();
                logger.warn("Port {} is already in use! The application might not start correctly.", serverPort);
                logger.info("Consider changing the port in application.properties using 'server.port=XXXX'");
            } catch (Exception e) {
                // Exception means port is available
                logger.info("Port {} is available and will be used by the application", serverPort);
            }
        };
    }
}
