package com.company;

import java.util.List;

public class King {
    private String name;
    private int coins = 1000;
    private int armyCount;
    private List<SimpleSoldier> soldiers;
    public King(){}

    public King(String name, int coins, int armyCount) {
        this.name = name;
        this.coins = coins;
        this.armyCount = armyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getArmyCount() {
        return armyCount;
    }

    public void setArmyCount(int armyCount) {
        this.armyCount = armyCount;
    }

    public void kingArmy(List<SimpleSoldier> soldiersArray)
    {
        for(SimpleSoldier s : soldiers)
        {
            soldiers.add(s);
        }
    }

    public List<SimpleSoldier> getKingArmy()
    {
        return soldiers;
    }

    @Override
    public String toString() {
        return "Король:" +
                "\nИмя= " + name +
                "\nКазна= " + coins +
                "\nЧисленность армии= " + armyCount;
    }
}
