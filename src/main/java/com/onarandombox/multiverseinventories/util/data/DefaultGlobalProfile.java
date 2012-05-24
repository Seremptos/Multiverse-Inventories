package com.onarandombox.multiverseinventories.util.data;

import com.onarandombox.multiverseinventories.ProfileTypes;
import com.onarandombox.multiverseinventories.api.DataStrings;
import com.onarandombox.multiverseinventories.api.profile.GlobalProfile;
import com.onarandombox.multiverseinventories.api.profile.ProfileType;

import java.util.HashMap;
import java.util.Map;

class DefaultGlobalProfile implements GlobalProfile {

    private final String name;
    private String lastWorld = null;
    private ProfileType profileType = ProfileTypes.DEFAULT;

    DefaultGlobalProfile(String playerName, Map<String, Object> playerData) {
        this.name = playerName;
        for (String key : playerData.keySet()) {
            if (key.equalsIgnoreCase(DataStrings.PLAYER_LAST_WORLD)) {
                this.lastWorld = playerData.get(key).toString();
            } else if (key.equalsIgnoreCase(DataStrings.PLAYER_PROFILE_TYPE)) {
                this.profileType = ProfileTypes.lookupType(playerData.get(key).toString(), true);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getWorld() {
        return this.lastWorld;
    }

    public void setWorld(String world) {
        this.lastWorld = world;
    }

    @Override
    public ProfileType getProfileType() {
        return this.profileType;
    }

    public void setProfileType(ProfileType type) {
        this.profileType = type;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<String, Object>(2);
        if (this.lastWorld != null) {
            result.put(DataStrings.PLAYER_LAST_WORLD, this.lastWorld);
        }
        result.put(DataStrings.PLAYER_PROFILE_TYPE, this.profileType.getName());
        return result;
    }
}