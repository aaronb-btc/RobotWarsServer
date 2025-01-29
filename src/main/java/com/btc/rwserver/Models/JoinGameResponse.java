package com.btc.rwserver.Models;

public class JoinGameResponse {
    private String playerId;

    public JoinGameResponse() {}

    public JoinGameResponse(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
