CREATE TABLE message (
    MESSAGE_ID BIGINT PRIMARY KEY,
    MESSAGE_TOPIC VARCHAR(64),
    MESSAGE_PAYLOAD VARCHAR(128)
);