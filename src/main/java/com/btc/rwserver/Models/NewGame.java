package com.btc.rwserver.Models;

public class NewGame {
    private String mapId;

    public NewGame() {}

    public NewGame(String mapId) {
        this.mapId = mapId;
    }

    public String getMapId() {
        return mapId;
    }
}
