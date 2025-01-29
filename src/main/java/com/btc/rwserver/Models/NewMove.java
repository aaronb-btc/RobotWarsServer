package com.btc.rwserver.Models;

public class NewMove {
    private String playerId;
    private MovementType movementType;
    private int mapIndex;
    private Align align;

    public NewMove() {}

    public NewMove(String playerId, MovementType movementType, int mapIndex, Align align) {
        this.playerId = playerId;
        this.movementType = movementType;
        this.mapIndex = mapIndex;
        this.align = align;
    }

    public String getPlayerId() {
        return playerId;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public int getMapIndex() {
        return mapIndex;
    }

    public Align getAlign() {
        return align;
    }
}
