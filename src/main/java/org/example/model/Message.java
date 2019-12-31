package org.example.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement//This annotation uses JAXB to convert the output of this class to parsable XML
public class Message {

    private long id; //Message UUID
    private String message; //Message contents
    private Date created; //Message timestamp
    private String author; //Message author

    public Message()
    {
        //Obligatory no-op constructor
    }

    public Message(long id, String message, String author)
    {
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
