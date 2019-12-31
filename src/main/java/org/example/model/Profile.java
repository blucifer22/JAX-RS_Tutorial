package org.example.model;

import java.util.Date;

/**
 * This class defines a user profile for the Messenger app. Profile attributes include
 * a UUID (id), profile name (profileName), first and last name, and the Date of
 * creation (created).
 */
public class Profile {

    private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date created;

    public Profile()
    {
        //empty-op constructor (For XML/JSON scut)
    }

    public Profile(long id, String profileName, String firstName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
