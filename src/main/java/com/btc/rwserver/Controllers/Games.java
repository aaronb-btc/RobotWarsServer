package com.btc.rwserver.Controllers;

import com.btc.rwserver.Models.*;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Map;

@RestController
@RequestMapping("/api/games")
public class Games {
    @GetMapping
    public List<Game> getGames() {
        return HibernateController.getAllEntries(Game.class);
    }

    @GetMapping("/game/{id}")
    public Object getGameById(@PathParam(value = "id") String id) {
        Object game = HibernateController.getObject(Game.class, UUID.fromString(id));
        return game instanceof Game ? game : Map.of("ERROR", "ROBOT NOT FOUND");
    }

    @PostMapping("/game")
    public Game createGame(@RequestBody NewGame newGame) {
        Game game = new Game(
                newGame.getMapId(),
                new HashMap<UUID, UUID>(),
                new ArrayList<Move>(),
                GameStatus.INITIAL
        );

        HibernateController.addObject(game);
        return game;
    }

    @GetMapping("/game/{id}/move/{moveId}/after")
    public List<Object> getMovesAfterMove(
            @PathParam(value = "id") String id,
            @PathParam(value = "moveId") String moveId
    ) {
        List<Move> moves = ((Game) getGameById(id)).getMoves();

        int startIndex = -1;
        for (Move move : moves.reversed()) {
            if (move.getId().equals(moveId)) {
                startIndex = moves.indexOf(move);
            }
        }

        if (startIndex == -1) {
            return List.of(Map.of("", ""));
        }

        return Collections.singletonList(moves.subList(startIndex, moves.size() - 1));
    }

    @PostMapping(value = "/game/{id}/join")
    public UUID joinGame(
            @PathParam(value = "id") String id,
            @RequestBody JoinGame joinGameRequest
    ) {
        Game game = (Game) HibernateController.getObject(Game.class, id);

        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (game.getPlayer().containsKey(uuid));

        game.addPlayer(uuid, UUID.fromString(joinGameRequest.getRobotId()));
        HibernateController.modifyObject(game);
        return uuid;
    }

    @PostMapping(value = "/game/{id}/move/player/{playerId}")
    public Move moveRobot(
            @PathParam(value = "id") String id,
            @PathParam(value = "robotId") String robotId,
            @RequestBody Move newMove
    ) {
        Game game = (Game) HibernateController.getObject(Game.class, id);

        List<UUID> uuids = new ArrayList<UUID>();
        for (Move move : (List<Move>) game.getMoves()) {
            uuids.add(move.getId());
        }

        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (uuids.contains(uuid));

        Move move = new Move(
                uuid,
                newMove.getPlayerId(),
                newMove.getMovementType(),
                newMove.getMapIndex(),
                newMove.getAlign()
        );

        game.addMove(move);
        HibernateController.modifyObject(game);
        return move;
    }

    @GetMapping(value = "game/{id}/move")
    public Object getMoves(@PathParam(value = "id") String id) {
        Object game = getGameById(id);
        return game instanceof Game ? ((Game) game).getMoves() : game;
    }
}
