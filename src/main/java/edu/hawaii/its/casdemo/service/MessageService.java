package edu.hawaii.its.casdemo.service;

import edu.hawaii.its.casdemo.type.Message;

public interface MessageService {

    public Message findMessage(int id);

    public Message add(Message message);

    public Message update(Message message);

}
