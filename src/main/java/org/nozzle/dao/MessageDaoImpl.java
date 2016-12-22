package org.nozzle.dao;

import org.hibernate.SessionFactory;
import org.nozzle.domain.Message;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

    public MessageDaoImpl(final SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void save(@NotNull final Message message) {
        getHibernateTemplate().save(message);
    }

    @Override
    public void update(@NotNull final Message message) {
        getHibernateTemplate().update(message);
    }

    @Override
    public void delete(@NotNull final Message message) {
        getHibernateTemplate().delete(message);
    }

    @Override
    public Message findByMessageId(@NotNull final Long messageId) {
        final List result = getHibernateTemplate().find("from Message where messageId=?", messageId);
        return (Message) result.get(0);
    }

    @Override
    public Message getLatest() {
        // TODO: fix me
        final List result = getHibernateTemplate().find(
                "select message.messageId, max(message.messageId) from Message message group by message.messageId");
        return (Message) result.get(0);
    }
}
