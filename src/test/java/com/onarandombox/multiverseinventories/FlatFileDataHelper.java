package com.onarandombox.multiverseinventories;

import com.onarandombox.multiverseinventories.profile.ProfileDataSource;
import com.onarandombox.multiverseinventories.profile.container.ContainerType;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FlatFileDataHelper {

    private final FlatFileProfileDataSource data;

    public FlatFileDataHelper(ProfileDataSource data) {
        if (!(data instanceof FlatFileProfileDataSource)) {
            throw new ClassCastException("Must be instance of FlatFilePlayerData");
        }
        this.data = (FlatFileProfileDataSource) data;
    }

    public File getPlayerFile(ContainerType type, String dataName, UUID playerUUID) throws IOException {
        return data.getPlayerFile(type, dataName, playerUUID);
    }
}
