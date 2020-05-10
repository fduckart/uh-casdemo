package edu.hawaii.its.casdemo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.casdemo.type.Message;

@Service
public class MessageService {

    private static final Log logger = LogFactory.getLog(MessageService.class);
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @CacheEvict(value = "messages", allEntries = true)
    public void evictCache() {
        // Empty.
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "messages", key = "#id")
    public Message findMessage(int id) {
        Message message = null;
        try {
            message = em.find(Message.class, id);
            if (message == null) {
                message = new Message();
            }
        } catch (Exception e) {
            logger.error("Error:", e);
        }
        return message;
    }

    @Transactional
    @CachePut(value = "messages", key = "#result.id")
    public Message update(Message message) {
        em.merge(message);
        return message;
    }

    @Transactional
    @CachePut(value = "messages", key = "#result.id")
    public Message add(Message message) {
        em.persist(message);
        return message;
    }

}