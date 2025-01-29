package com.btc.rwserver.Models;

public class Robot extends NewRobot {
    private String id;

    public Robot() {}

    public Robot(String id, String name, int health, int attackDamage, int attackRange, int movementRate) {
        super(name, health, attackDamage, attackRange, movementRate);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
