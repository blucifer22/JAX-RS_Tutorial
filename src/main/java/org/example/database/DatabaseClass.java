package org.example.database;

import org.example.model.Message;
import org.example.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * The purpose of this static class is to simulate a SQL database. Since this project is
 * mainly an exercise in learning JAX-RS and not one in database programming, this
 * is a very ghetto but functional dummy setup.
 * A static class is being utilized, as it stores the information independent of
 * instantiation until the server itself is restarted. This allows us to send POST
 * and PUT requests to the server and actually accumulate information.
 *
 * NOTE: THIS IS NOT THREADSAFE so do NOT use this implementation if there is any
 * chance of your program experiencing concurrency issues!!!
 */
public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<Long, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages()
    {
        return messages;
    }

    public static Map<Long, Profile> getProfiles()
    {
        return profiles;
    }
}
