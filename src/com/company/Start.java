package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

    public static void  gameStart()
    {
        Scanner scanner = new Scanner(System.in);
        King king = new King();
        String personName = "";
        System.out.flush();
        System.out.println("Привет, теперь ты король нового королевства ПупаЛенд, как тебя называть?\n> ");
        personName = scanner.next();
        king.setName(personName);
        System.out.println("Да здравствйет король по имени " + king.getName() + "!");
        naviMenu(king);
    }

   public static void naviMenu(King king){
       Scanner scanner = new Scanner(System.in);
       System.out.println("1 ------- Купить рыцаря\n" + "2 ------- Информация о вашем королевстве \n" +
               "3 ------- Показать информацию об отряде\n");
       try{
           int inNum = scanner.nextInt();
           if(inNum == 1){
               Shop shop = new Shop();
               shop.shopMenu(king);
           } else if(inNum == 2){
               System.out.println(king);
               naviMenu(king);
           }
           else if(inNum == 3)
           {
               System.out.println(king.getKingArmy());
               naviMenu(king);
           }
           else
           {
               System.out.println("\n\n\nОшибочка, пожалуйста выбери цифру от 1 до 2!\n");
               naviMenu(king);
           }
       } catch (InputMismatchException | IOException a){
           System.out.println("\n\n\nРазбийник!" + "пожалуйста выбери цифру от 1 до 2!\n");
           naviMenu(king);
       }
    }
}
