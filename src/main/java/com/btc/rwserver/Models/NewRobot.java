package com.btc.rwserver.Models;

public class NewRobot {
    private String name;
    private int health;
    private int attackDamage;
    private int attackRange;
    private int movementRate;

    public NewRobot() {}

    public NewRobot(String name, int health, int attackDamage, int attackRange, int movementRate) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.movementRate = movementRate;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getMovementRate() {
        return movementRate;
    }
}
