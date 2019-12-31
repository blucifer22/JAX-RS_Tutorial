package org.example.service;

import org.example.database.DatabaseClass;
import org.example.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService()
    {
        profiles.put("blucifer22", new Profile(1L, "blucifer22", "Marc", "Chmielewski"));
    }

    public List<Profile> getAllProfiles()
    {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName)
    {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile)
    {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile)
    {
        if(profile.getProfileName().isEmpty())
        {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName)
    {
        return profiles.remove(profileName);
    }
}
