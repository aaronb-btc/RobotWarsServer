package com.btc.rwserver;

import com.btc.rwserver.Controllers.Robots;
import com.btc.rwserver.Models.Robot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotsTest {
    private static List<String> objListToStrList(List<?> objectList) {
        List<String> stringList = new ArrayList<>();

        for (Object object : objectList) {
            stringList.add(object.toString());
        }

        return stringList;
    }

    @Test
    void testGetRobots() {
        Robots robotController = new Robots();

        String robot = robotController.createRobot(new Robot(
                "Batman",
                2,
                3,
                4,
                5
        )).toString();

        List<String> robots = objListToStrList(robotController.getRobots());
        assertTrue(robots.contains(robot), "Created robot does not appear in output list");

        String robot2 = robotController.createRobot(new Robot(
                "Superman",
                4,
                3,
                2,
                1
        )).toString();

        robots = objListToStrList(robotController.getRobots());
        assertTrue(robots.contains(robot2), "Second created robot does not appear in output list");
        assertTrue(robots.contains(robot) && robots.contains(robot2), "At least one of the two robots does not appear in output list");
    }

    @Test
    void testCreateRobot() {
        Robots robotController = new Robots();

        String name = "Batman";
        int health = 2;
        int attackDamage = 3;
        int attackRange = 4;
        int movementRate = 5;

        Robot robot = robotController.createRobot(new Robot(
                name,
                health,
                attackDamage,
                attackRange,
                movementRate
        ));

        assertNotNull(robot.getId(), "Robot didn't get an UUID assigned");
        assertEquals(robot.getName(), name, "Robot's name is not set correctly");
        assertEquals(robot.getHealth(), health, "Robot's health is not set correctly");
        assertEquals(robot.getAttackDamage(), attackDamage ,"Robot's attack damage is not set correctly");
        assertEquals(robot.getAttackRange(), attackRange, "Robot's attack range is not set correctly");
        assertEquals(robot.getMovementRate(), movementRate, "Robot's movement rate is not set correctly");

        List<String> robots = objListToStrList(robotController.getRobots());
        assertTrue(robots.contains(robot.toString()), "Robot does not appear in getRobot()'s output list");
    }

    @Test
    void testGetRobotById() {
        Robots robotController = new Robots();

        Robot robot = robotController.createRobot(new Robot(
                "Batman",
                2,
                3,
                4,
                5
        ));

        Robot robot_output = (Robot) robotController.getRobotById(robot.getId().toString());

        assertNotNull(robot_output, "Output is null");

        if (!robot_output.toString().equals(robot.toString())) {
            assertEquals(robot_output.getId().toString(), robot.getId().toString(), "Robot id is not the same as after creation");
            assertEquals(robot_output.getName(), robot.getName(), "Robot name is not the same as after creation");
            assertEquals(robot_output.getHealth(), robot.getHealth(), "Robot health is not the same as after creation");
            assertEquals(robot_output.getAttackDamage(), robot.getAttackDamage(), "Robot attack damage is not the same as after creation");
            assertEquals(robot_output.getAttackRange(), robot.getAttackRange(), "Robot attack range is not the same as after creation");
            assertEquals(robot_output.getMovementRate(), robot.getMovementRate(), "Robot movement rate is not the same as after creation");
        }
    }
}