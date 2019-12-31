package org.example.service;

import org.example.database.DatabaseClass;
import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {

    //Since this is static future requests point to the same instance (until server is reset)
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService()
    {
        messages.put(1L, new Message(1, "Hello World!", "Marc"));
        messages.put(2L, new Message(2, "Hello Embarc!", "Kevin"));
        messages.put(3L, new Message(3, "Hello Luksusowa!", "Sid"));
        messages.put(4L, new Message(4,
                "I think Sid might have a bit too much blood in his alcohol-stream", "Craig"));
    }

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
