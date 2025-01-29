package com.btc.rwserver.Models;

enum GameStatus {
    INITIAL,
    STARTED,
    END
}

public class Game {
    private String id;
    private String map;
    private PlayerRobot[] player;
    private Move[] moves;
    private GameStatus status;

    public Game() {}

    public Game(String id, String map, PlayerRobot[] player, Move[] moves, GameStatus status) {
        this.id = id;
        this.map = map;
        this.player = player;
        this.moves = moves;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getMap() {
        return map;
    }

    public PlayerRobot[] getPlayer() {
        return player;
    }

    public Move[] getMoves() {
        return moves;
    }

    public GameStatus getStatus() {
        return status;
    }
}
