package org.example.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@XmlRootElement//This annotation uses JAXB to convert the output of this class to parsable XML
public class Message {

    private long id; //Message UUID
    private String message; //Message contents
    private Date created; //Message timestamp
    private String author; //Message author
    private static Map<Long, Comment> comments = new HashMap<>(); //Map of Message comments
    private List<Link> links = new ArrayList<>();

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

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * Convenience method to add links and relations.
     */
    public void addLink(String url, String rel)
    {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

    @XmlTransient //Keeps the comment data from being pulled up when the Message is being converted to XML/JSON
    public Map<Long, Comment> getComments()
    {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments)
    {
        this.comments = comments;
    }
}
