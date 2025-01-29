package com.btc.rwserver.Models;

public class PlayerRobot {
    private String playerId;
    private String robotId;

    public PlayerRobot() {}

    public PlayerRobot(String playerId, String robotId) {
        this.playerId = playerId;
        this.robotId = robotId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getRobotId() {
        return robotId;
    }
}
