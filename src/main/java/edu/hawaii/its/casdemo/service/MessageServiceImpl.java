package edu.hawaii.its.casdemo.service;

import edu.hawaii.its.casdemo.type.Message;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * A JPA-based implementation of the System Message Service. 
 * Delegates to a JPA entity manager to issue data access calls 
 * against the backing repository. The EntityManager reference 
 * is provided by the managing container (Spring) automatically.
 */
@Service("messageService")
@Repository
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable("messages")    
    public Message findMessage(int id) {
        Message message = null;
        try {
            message = em.find(Message.class, id);
        } catch (Exception e) {
            logger.error("Error:", e);
        }
        return message;
    }

    @Override
    @Transactional
    public void update(Message message) {
        em.merge(message);
    }

    @Override
    @Transactional
    public void add(Message message) {
        em.persist(message);
    }

}