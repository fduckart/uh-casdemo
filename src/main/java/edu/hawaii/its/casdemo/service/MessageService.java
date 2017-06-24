package edu.hawaii.its.casdemo.service;

import javax.persistence.EntityManager;

import edu.hawaii.its.casdemo.type.Message;

public interface MessageService {
    public EntityManager getEntityManager();

    public void setEntityManager(EntityManager em);

    public void evictCache();

    public Message findMessage(int id);

    public Message add(Message message);

    public Message update(Message message);

}
