package com.btc.rwserver.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private String id;

    @Column(name = "Map Id")
    private String map;

    @Column(name = "Players")
    private List<PlayerRobot> player;

    @Column(name = "Moves")
    private List<Move> moves;

    @Column(name = "Status")
    private GameStatus status;

    public Game() {}

    public Game(String id, String map, List<PlayerRobot> player, List<Move> moves, GameStatus status) {
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

    public List<PlayerRobot> getPlayer() {
        return player;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameStatus getStatus() {
        return status;
    }
}
