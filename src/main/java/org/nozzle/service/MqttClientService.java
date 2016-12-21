package org.nozzle.service;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;

public interface MqttClientService extends MqttCallback {

    void sendMessage(String topic, String messageBody) throws MqttException;

    void subscribe(String[] topics) throws MqttException;
}
