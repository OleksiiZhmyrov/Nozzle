package org.nozzle.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mqttbroker.properties")
public class MqttClientConfig {

    private @Value("${mqtt.broker.host}") String host;
    private @Value("${mqtt.broker.port}") String port;
    private @Value("${mqtt.broker.clientid}") String clientId;
    private @Value("${mqtt.broker.username}") String username;
    private @Value("${mqtt.broker.password}") String password;

    @Bean
    public MqttClient mqttClient() throws MqttException {
        return new MqttClient("tcp://" + host + ":" + port, clientId, mqttClientPersistence());
    }

    @Bean
    public MqttClientPersistence mqttClientPersistence() {
        return new MemoryPersistence();
    }

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        final MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        // TODO: add more configuration options from properties
        return options;
    }

}
