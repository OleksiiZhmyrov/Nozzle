package org.nozzle.service;

import org.nozzle.dao.MessageDao;
import org.nozzle.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Component
public class MessageServiceImpl implements MessageService {

    private @Autowired MessageDao dao;

    @Override
    @Transactional
    public void save(@NotNull final Message message) {
        dao.save(message);
    }

    @Override
    @Transactional
    public void update(@NotNull final Message message) {
        dao.update(message);
    }

    @Override
    @Transactional
    public void delete(@NotNull final Message message) {
        dao.delete(message);
    }

    @Override
    public Message getLatest() {
        return dao.getLatest();
    }

    @Override
    public Message findByMessageId(@NotNull final Long messageId) {
        return dao.findByMessageId(messageId);
    }
}
