package org.nozzle.service;

import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.UnsupportedEncodingException;

@Component
public class MqttClientServiceImpl implements MqttClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqttClientServiceImpl.class);

    private @Autowired MqttClient client;

    private @Autowired MqttConnectOptions options;

    public MqttClientServiceImpl() {
    }

    @Override
    public void sendMessage(final String topic, final String messageBody) throws MqttException {
        LOGGER.debug("Publishing message to topic {}", topic);
        client.publish(topic, new MqttMessage(messageBody.getBytes()));
    }

    @Override
    public void connectionLost(final Throwable cause) {
        LOGGER.warn("Connection to {} has been lost", client.getServerURI());
        // TODO: implement logic to reconnect
    }

    @Override
    public void messageArrived(final String topic, final MqttMessage message) throws UnsupportedEncodingException {
        LOGGER.debug("Message {} has arrived to topic {}", message.getId(), topic);
        LOGGER.debug("Payload: {}", new String(message.getPayload(), "UTF-8"));
    }

    @Override
    public void deliveryComplete(final IMqttDeliveryToken token) {
        LOGGER.debug("Delivery complete");
    }

    @Override
    public void subscribe(final String[] topics) throws MqttException {
        LOGGER.info("Subscribing to topics {}", String.join(" ", topics));
        client.subscribe(topics);
    }

    @PostConstruct
    private void connect() throws MqttException {
        LOGGER.info("Connecting to {}", client.getServerURI());
        client.setCallback(this);
        client.connect(options);
    }

    @PreDestroy
    private void closeClient() throws MqttException {
        LOGGER.info("Disconnecting {}", client.getServerURI());
        client.disconnect();

        LOGGER.info("Closing client");
        client.close();
    }

}
