package com.btc.rwserver.Models;

import jakarta.persistence.Column;

public class NewMove {
    @Column(name = "Player Id")
    private String playerId;

    @Column(name = "Movement Type")
    private MovementType movementType;

    @Column(name = "Map Index")
    private int mapIndex;

    @Column(name = "Alignment")
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
