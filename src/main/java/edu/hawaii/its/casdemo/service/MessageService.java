package edu.hawaii.its.casdemo.service;

import edu.hawaii.its.casdemo.type.Message;

public interface MessageService {
    public Message findMessage(int id);

    public void add(Message message);

    public void update(Message message);
}
