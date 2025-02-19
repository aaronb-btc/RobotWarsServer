package com.btc.rwserver.Models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Move extends NewMove {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
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
