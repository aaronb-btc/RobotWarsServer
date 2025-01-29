package com.btc.rwserver.Models;

public class Move extends NewMove {
    private String id;

    public Move() {}

    public Move(String playerId, MovementType movementType, int mapIndex, Align align, String id) {
        super(playerId, movementType, mapIndex, align);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
