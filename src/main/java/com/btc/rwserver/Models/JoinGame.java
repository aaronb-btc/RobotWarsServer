package com.btc.rwserver.Models;

public class JoinGame {
    private String robotId;

    public JoinGame() {}

    public JoinGame(String robotId) {
        this.robotId = robotId;
    }

    public String getRobotId() {
        return robotId;
    }
}
