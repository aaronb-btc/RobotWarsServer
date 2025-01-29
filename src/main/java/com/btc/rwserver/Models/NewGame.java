package com.btc.rwserver.Models;

public class NewGame {
    private int mapId;

    public NewGame() {}

    public NewGame(int mapId) {
        this.mapId = mapId;
    }

    public int getMapId() {
        return mapId;
    }
}
