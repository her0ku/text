package com.company;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    List<SimpleSoldier> simpleSoldierList = initSoldiers();
    int currentKingCoins = 0;
    int kingCoins = 0;
    int countArmy = 0;
    List<SimpleSoldier> soldiers;

    public Shop() throws IOException {
    }

    public void shopMenu(King king) throws IOException {

        System.out.println("\n\n\nМагазин\n");
        System.out.println("1 ------ Показать рыцарей доступных за " + king.getCoins() + " монет\n"
        + "2 ------ Показать всех" + "3 ------ Выйти из магазина");
        Scanner scanner = new Scanner(System.in);
        try {
            int inNum = scanner.nextInt();
            if(inNum == 1)
            {
                for(int i = 0; i < simpleSoldierList.size(); i++){
                    if(simpleSoldierList.get(i).getPrice() <= king.getCoins())
                    {
                        System.out.println("№ " + i + "\n" + simpleSoldierList.get(i) + "\n");
                    }
                }
                System.out.println("Введите порядковый номер солдата, чтобы купить его, или напишите -1, чтобы перейти обратно к списку");
                inNum = scanner.nextInt();
                if(!simpleSoldierList.isEmpty()) {
                    if (simpleSoldierList.get(inNum) != null) {
                        SimpleSoldier soldier = simpleSoldierList.get(inNum);
                        if (soldier.getPrice() <= king.getCoins()) {
                            kingCoins = king.getCoins();
                            currentKingCoins = kingCoins - soldier.getPrice();
                            king.setCoins(currentKingCoins);
                            countArmy = king.getArmyCount() + 1;
                            king.setArmyCount(countArmy);
                            soldiers.add(soldier);
                            king.kingArmy(soldiers);
                            shopMenu(king);
                        }
                    }
                }
            }
            else if(inNum == 2)
            {
                for(int i = 0; i < simpleSoldierList.size(); i++){
                    System.out.println(i + " " + simpleSoldierList.get(i) + "\n");
                }
                shopMenu(king);
            }
            else if(inNum == 3)
            {
                Start.naviMenu(king);
            }
            else{
                System.out.println("1 ------ Показать рыцарей доступных за стартовые " + king.getCoins() + " монет\n" +
                        "2 ------ Показать всех рыцарей");
                shopMenu(king);
            }
        } catch (Exception e) {
            System.out.println("1 ------ Показать рыцарей доступных за стартовые " + king.getCoins() + " монет\n" +
                    "2 ------ Показать всех");
            shopMenu(king);
        }
    }

    public List<SimpleSoldier> initSoldiers() throws IOException {
        List<SimpleSoldier> simpleSoldierList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<SimpleSoldier> listName = mapper.readValue(new File("C:\\Users\\Enigm\\IdeaProjects\\IncrementGame\\src\\com\\company\\SoldierName.json"),new TypeReference<List<String>>() { });
        int attack = 1;
        float armor = 2F;
        float speedCoin = 0.25F;
        int price = 100;
        for(int i = 0; i < listName.size(); i++){
            if(String.valueOf(listName.get(i)) != "name" && String.valueOf(listName.get(i)) != "{" && String.valueOf(listName.get(i)) != "}") {
                SimpleSoldier soldier = new SimpleSoldier();
                soldier.setName(String.valueOf(listName.get(i)));
                soldier.setAttack(attack);
                attack += attack * 0.2F;
                soldier.setArmor(armor);
                armor += armor * 0.05F;
                soldier.setSpeedCoin(speedCoin);
                speedCoin += speedCoin * 0.45;
                soldier.setPrice(price);
                price += price * 2;
                simpleSoldierList.add(soldier);
            }
        }
        return simpleSoldierList;
    }
}
