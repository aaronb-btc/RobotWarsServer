package com.btc.rwserver.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
import java.util.Map;

@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Map")
    private String map;

    @Column(name = "Players")
    private Map<UUID, UUID> players;

    @OneToMany
    @Column(name = "Moves")
    private List<Move> moves;

    @Column(name = "Status")
    private GameStatus status;

    public Game() {}

    public Game(String map, Map<UUID, UUID> players, List<Move> moves, GameStatus status) {
        this.map = map;
        this.players = players;
        this.moves = moves;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getMap() {
        return map;
    }

    public Map<UUID, UUID> getPlayer() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void addPlayer(UUID playerId, UUID robotId) {
        players.put(playerId, robotId);
    }

    public void addMove(Move move) {
        moves.add(move);
    }
}
