package com.matheus.ecommercemessagingschemaregistry;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class EcommerceMessagingMessageBuilder<T> {

    private T payload;

    public EcommerceMessagingMessageBuilder withPayload(T payload) {
        this.payload = payload;
        return this;
    }

    public Message<T> build() {
        return MessageBuilder
                .withPayload(payload)
                .build();
    }
}
