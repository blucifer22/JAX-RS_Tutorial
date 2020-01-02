package org.example.service;

import org.example.database.DatabaseClass;
import org.example.exception.DataNotFoundException;
import org.example.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {

    //Since this is static future requests point to the same instance (until server is reset)
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    /**
     * This constructor creates some dummy values to populate our messages database.
     * Since we're not using an actual SQL database, we're storing them in the static
     * HashMap defined by the DatabaseClass.
     */
    public MessageService()
    {
        messages.put(1L, new Message(1, "Hello World!", "Marc"));
        messages.put(2L, new Message(2, "Hello Embarc!", "Kevin"));
        messages.put(3L, new Message(3, "Hello Luksusowa!", "Sid"));
        messages.put(4L, new Message(4,
                "I think Sid might have a bit too much blood in his alcohol-stream...", "Craig"));
    }

    /**
     * This method returns an ArrayList of all the messages in the messages HashMap
     * @return ArrayList containing all of the messages.
     */
    public List<Message> getAllMessages()
    {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year)
    {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message message : messages.values())
        {
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year)
            {
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size)
    {
        ArrayList<Message> list = new ArrayList<>(messages.values());
        if(start + size > list.size())
            return new ArrayList<Message>();
        return list.subList(start, start + size);
    }

    /**
     * This method returns the message with the given id, if that message exists.
     * Else, it returns null.
     * @param id the id of the message to be returned
     * @return the Message with the given id. Else, null.
     */
    public Message getMessage(long id)
    {
        Message message = messages.get(id);
        if(message == null)
            throw new DataNotFoundException("Message with ID " + id + " not found!");
        return message;
    }

    /**
     * This method adds a Message to the messages HashMap.
     * It also generates a UUID for the message upon insertion.
     * @param message the Message to be added.
     * @return the Message that has been added.
     */
    public Message addMessage(Message message)
    {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    /**
     * This method updates the contents of a Message in messages if it
     * already exists and creates a new one if it does not.
     * @param message the message to be created/updated.
     * @return the message that has been created/updated.
     */
    public Message updateMessage(Message message)
    {
        if(message.getId() <= 0)
            return null;
        messages.put(message.getId(), message);
        return message;
    }

    /**
     * Removes message by id
     * @param id the id of the Message to be removed.
     * @return the message that has been removed, or null if
     * it does not exist.
     */
    public Message removeMessage(long id)
    {
        return messages.remove(id);
    }
}
