package com.onarandombox.multiverseinventories.profile;

import org.bukkit.Bukkit;

import java.util.UUID;

/**
 * The global profile for a player which contains meta-data for the player.
 */
public final class GlobalProfile {

    /**
     * Creates a global profile object for the given player with default values.
     *
     * @param playerUUID the UUID of the player to create the profile for.
     * @return a new GlobalProfile for the given player.
     */
    public static GlobalProfile createGlobalProfile(UUID playerUUID) {
        return new GlobalProfile(playerUUID);
    }

    private final UUID uuid;
    private String lastWorld = null;
    private boolean loadOnLogin = false;

    private GlobalProfile(UUID uuid) {
        this.uuid = uuid;
    }


    /**
     * Returns the UUID of the player.
     *
     * @return the UUID of the player.
     */
    public UUID getPlayerUUID() {
        return uuid;
    }


    /**
     * Returns the name of last world the player was in.
     *
     * @return The last world the player was in or null if not set.
     */
    public String getLastWorld() {
        return this.lastWorld;
    }

    /**
     * Says whether the player data for the player's logout world should be loaded when the player logs in.
     * The default value is false.
     *
     * @return true if player data should be loaded when they log in.
     */
    public boolean shouldLoadOnLogin() {
        return loadOnLogin;
    }

    /**
     * Sets whether the player data for the player's logout world should be loaded when the player logs in.
     *
     * @param loadOnLogin true if player data should be loaded when they log in.
     */
    public void setLoadOnLogin(boolean loadOnLogin) {
        this.loadOnLogin = loadOnLogin;
    }

    /**
     * Sets the last world the player was known to be in. This is done automatically on world change.
     *
     * @param world The world the player is in.
     */
    public void setLastWorld(String world) {
        this.lastWorld = world;
    }

    @Override
    public String toString() {
        return "GlobalProfile{" +
                "uuid=" + uuid +
                ", lastWorld='" + lastWorld + '\'' +
                ", loadOnLogin=" + loadOnLogin +
                '}';
    }
}
