package org.nozzle;

import org.hsqldb.util.DatabaseManagerSwing;
import org.nozzle.service.MqttClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@PropertySource("classpath:mqttbroker.properties")
public class Nozzle {

    private @Autowired MqttClientService service;
    private @Value("#{'${mqtt.broker.topics}'.split(',')}") String[] topics;

    private static final Logger LOGGER = LoggerFactory.getLogger(Nozzle.class);

    public static void main(String[] args) {
        SpringApplication.run(Nozzle.class, args);
        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb", "--user", "sa", "--password", "" });
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> service.subscribe(topics);
    }

}
