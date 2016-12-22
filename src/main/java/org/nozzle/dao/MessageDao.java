package org.nozzle.dao;


import org.nozzle.domain.Message;

import javax.validation.constraints.NotNull;

public interface MessageDao extends AbstractDao<Message> {

    Message findByMessageId(@NotNull Long messageId);

    Message getLatest();
}
