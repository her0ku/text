package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void catchMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 ------- Начать новую игру\n" + "2 ------- Узнать вообще в чем смысл игры\n");
        try{
            int inNum = scanner.nextInt();
            if(inNum == 1){
                Start.gameStart();
            } else if(inNum == 2){
                System.out.println("\n\n\n> Вы новый король королевства ПупаЛенд!\n" +
                        "> И вам необходимо собирать дань со всей территории вашего необъятного королевства, для этого вам приходят на помощь ваши верные рыцари/\n"
                        + "> Их вы можете нанять в специальной казарме.\n"+
                        "> Ваш народ предан вам и в замен хочет защиты от ужасных тварей.\n" + "> Это значит, что вам необходимо ходить на рейды, на всяких супер боссов, победа гарантирует горы денег!\n"
                        + "> В противном случае, вам придется тратить деньги на восстановление своих войск.");
                catchMenu();
            }
            else
            {
                System.out.println("\n\n\nОшибочка, пожалуйста выбери цифру от 1 до 2!\n");
                catchMenu();
            }
        } catch (InputMismatchException a){
            System.out.println("\n\n\nРазбийник!" + "пожалуйста выбери цифру от 1 до 2!\n");
            catchMenu();
        }
    }
}
