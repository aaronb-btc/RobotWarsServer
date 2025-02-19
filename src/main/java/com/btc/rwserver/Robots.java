package com.btc.rwserver;

import com.btc.rwserver.Controllers.HibernateController;
import com.btc.rwserver.Models.NewRobot;
import com.btc.rwserver.Models.Robot;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/robots")
public class Robots {
    @GetMapping
    public List<Robot> getRobots() {
        return HibernateController.getAllEntries(Robot.class);
    }

    @GetMapping("/robot/{id}")
    public Object getRobotById(@PathVariable(value = "id") String id) {
        Object robot = HibernateController.getObject(Robot.class, UUID.fromString(id));
        return robot instanceof Robot ? robot : Map.of("ERROR", "ROBOT NOT FOUND");
    }

    @PostMapping("/robot")
    public Robot registerRobot(@RequestBody NewRobot newRobot) {
        Robot robot = new Robot(
                newRobot.getName(),
                newRobot.getHealth(),
                newRobot.getAttackDamage(),
                newRobot.getAttackRange(),
                newRobot.getMovementRate()
        );

        HibernateController.addObject(robot);

        return robot;
    }
}