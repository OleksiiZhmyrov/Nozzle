package org.nozzle.domain;

public class Message extends DomainObject {

    private Long messageId;
    private String topic;
    private String payload;

    public Message() {
    }

    public Message(final Long messageId, final String topic, final String payload) {
        this.messageId = messageId;
        this.topic = topic;
        this.payload = payload;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(final Long messageId) {
        this.messageId = messageId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(final String topic) {
        this.topic = topic;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(final String payload) {
        this.payload = payload;
    }
}
