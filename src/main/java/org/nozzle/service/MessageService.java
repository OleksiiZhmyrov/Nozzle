package org.nozzle.service;

import org.nozzle.domain.Message;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public interface MessageService {

    void save(@NotNull Message message);

    void update(@NotNull Message message);

    void delete(@NotNull Message message);

    Message getLatest();

    Message findByMessageId(@NotNull Long messageId);

}
