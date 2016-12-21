package org.nozzle;

import org.nozzle.service.MqttClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:mqttbroker.properties")
public class Nozzle {

    private @Autowired MqttClientService service;
    private @Value("#{'${mqtt.broker.topics}'.split(',')}") String[] topics;

    private static final Logger LOGGER = LoggerFactory.getLogger(Nozzle.class);

    public static void main(String[] args) {
        SpringApplication.run(Nozzle.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> service.subscribe(topics);
    }

}
