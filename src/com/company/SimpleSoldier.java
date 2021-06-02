package com.company;

import java.util.List;

public class SimpleSoldier {
    private String name;
    private float attack;
    private float armor;
    private float speedCoin;
    private int price;

    public SimpleSoldier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public float getSpeedCoin() {
        return speedCoin;
    }

    public void setSpeedCoin(float speedCoin) {
        this.speedCoin = speedCoin;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Солдат: " +
                "\nИмя " + name +
                "\nАтака= " + attack +
                "\nБроня= " + armor +
                "\nСкорость сбора монет= " + speedCoin +
                "\nЦена солдата= " + price;
    }
}
