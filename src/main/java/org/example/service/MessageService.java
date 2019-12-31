package org.example.service;

import org.example.database.DatabaseClass;
import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {

    //Since this is static future requests point to the same instance (until server is reset)
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Message> getAllMessages()
    {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id)
    {
        return messages.get(id);
    }

    public Message addMessage(Message message)
    {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message)
    {
        if(message.getId() <= 0)
            return null;
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id)
    {
        return messages.remove(id);
    }
}
