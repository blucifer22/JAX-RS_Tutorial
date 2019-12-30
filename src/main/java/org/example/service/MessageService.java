package org.example.service;

import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages()
    {
        Message m1 = new Message(1, "Hello world!", "Marc");
        Message m2 = new Message(2, "Hello Jersey!", "Marc");
        List<Message> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        return list;
    }
}
