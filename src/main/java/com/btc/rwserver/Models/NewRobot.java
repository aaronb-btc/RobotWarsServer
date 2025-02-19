package com.btc.rwserver.Models;

import jakarta.persistence.Column;

public class NewRobot {
    @Column(name = "Name")
    private String name;

    @Column(name = "Health")
    private int health;

    @Column(name = "Attack Damage")
    private int attackDamage;

    @Column(name = "Attack Range")
    private int attackRange;

    @Column(name = "Movement Rate")
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
