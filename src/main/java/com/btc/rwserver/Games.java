package com.btc.rwserver;

import com.btc.rwserver.Models.*;
import jakarta.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class Games {
    private List<Game> games;
    private java.util.Map<String, Game> gameUUIDs;

    public Games() {
        games = new ArrayList<Game>();
        gameUUIDs = new HashMap<String, Game>();
    }

    @GetMapping
    public List<Game> getGames() {
        return games;
    }

    @GetMapping("/game/{id}")
    public Game getGame(@PathParam(value = "id") String id) {
        if (gameUUIDs.containsKey(id)) {
            return gameUUIDs.get(id);
        }
        return new Game();
    }

    @GetMapping("/game/{id}/move/{moveId}/after")
    public List<Move> getMovesAfterMove(
            @PathParam(value = "id") String id,
            @PathParam(value = "moveId") String moveId
    ) {
        List<Move> moves = getGame(id).getMoves();

        int startIndex = -1;
        for (Move move : moves.reversed()) {
            if (move.getId().equals(moveId)) {
                startIndex = moves.indexOf(move);
            }
        }

        if (startIndex == -1) {
            return new ArrayList<Move>();
        }

        return moves.subList(startIndex, moves.size() - 1);
    }

    @PostMapping("/game")
    public Game createGame(@RequestBody NewGame newGame) {
        String uuid;
        do {
            uuid = UUID.randomUUID().toString();
        } while (gameUUIDs.containsKey(uuid));

        games.add(new Game(
                uuid,
                newGame.getMapId(),
                new ArrayList<PlayerRobot>(),
                new ArrayList<Move>(),
                GameStatus.INITIAL
        ));

        gameUUIDs.put(uuid, games.getLast());

        return games.getLast();
    }

    @PostMapping(value = "/game/{id}/join", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String joinGame(@PathParam(value = "id") String id, @RequestBody String robotId) {
        return null;
    }
}
