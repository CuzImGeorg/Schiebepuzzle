/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Button;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author georg
 */
public class Game {

    private static int[][] field;
    private static int fields;
    private static boolean won = false;
    public static int zuege = 0;
    private static Window w;

    public static void main(String[] args) throws InterruptedException {
//        beforStart("easy");
        GameStart gs = new GameStart();

        Thread.sleep(5000);
        if(fields == 0) {
            main(args);
}
        start();
        

    }

    public static void start() {

        field = new int[(int) Math.sqrt(fields)][(int) Math.sqrt(fields)];

        fillField();
        printField();
        createWindow();
    
}


    public static void beforStart(String str) {
//        Scanner s = new Scanner(System.in);
//        System.out.println("Pls choose a difficulty from Easy, Medium, Hard, Custom");
        
        
        switch (str) {
            case "easy": {
                fields = 16;
                break;
            }
            case "medium": {
                fields = 25;
                break;
            }
            case "hard": {
                fields = 36;
            }
            case "custom": {
                
                break;
            }
           

        }

    }

    public static void temp() {

        if (!won) {
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();

            move(i);
            chekField();
            printField();
            temp();
        }

    }

    /* public static void fillFieldtest() {
         int conunter = 1;
         for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                
                if (i == Math.sqrt(fields)-1 && j == Math.sqrt(fields)-1) {
                   field[i][j] = 0; 
                } else {
                    
                    field[i][j] = conunter;
                    conunter++;
                }
                
            }
        }
    } */
    public static void fillField() {
        ArrayList<Integer> number = new ArrayList<>();
        Random rdm = new Random();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                int r = rdm.nextInt(fields - 1) + 1;
                if (i == Math.sqrt(fields) - 1 && j == Math.sqrt(fields) - 1) {
                    field[i][j] = 0;
                } else {
                    while (number.contains(r)) {
                        r = rdm.nextInt(fields - 1) + 1;

                    }
                    number.add(r);
                    field[i][j] = r;
                }

            }
        }
    }

    public static void printField() {
        for (int i = 0; i < field.length; i++) {
            System.out.println("");
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] < 10) {
                    System.out.print(field[i][j] + "  | ");
                } else {
                    System.out.print(field[i][j] + " | ");
                }
            }
        }
        System.out.println("");

    }

    public static void gameWon() {
        System.out.println("du Hast das Spiel gewonnen mit " + zuege + " Züge");
        w.dispose();
        w.dispose();

        w.dispose();

        GameWon gw = new GameWon(zuege);
        gw.setVisible(true);
    }

    public static void chekField() {
        int counter = 1;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i == Math.sqrt(fields) - 1 && j == Math.sqrt(fields) - 1) {
                    won = true;
                    gameWon();
                } else if (field[i][j] == counter) {
                    counter++;
                } else {
                    return;
                }
            }
        }
    }

    public static void createWindow() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                w = new Window((int) (Math.sqrt(fields) * 200) + 200);
            }
        });

    }

    public static void move(int i) {
        int posX = 0;
        int posY = 0;
        for (int j = 0; j < field.length; j++) {
            for (int k = 0; k < field.length; k++) {
                if (field[j][k] == i) {
                    posX = j;
                    posY = k;
                }
            }

        }

        int newPosX = Integer.MAX_VALUE;
        int newPosY = Integer.MAX_VALUE;

        if (posY + 1 < Math.sqrt(fields)) {
            if (field[posX][posY + 1] == 0) {
                newPosX = posX;
                newPosY = posY + 1;
            }
        }
        if (posY - 1 >= 0) {
            if (field[posX][posY - 1] == 0) {
                newPosX = posX;
                newPosY = posY - 1;
            }
        }
        if (posX + 1 < Math.sqrt(fields)) {
            if (field[posX + 1][posY] == 0) {
                newPosX = posX + 1;
                newPosY = posY;
            }
        }
        if (posX - 1 >= 0) {
            if (field[posX - 1][posY] == 0) {
                newPosX = posX - 1;
                newPosY = posY;
            }
        }

        if (newPosX != Integer.MAX_VALUE && newPosY != Integer.MAX_VALUE) {
            field[newPosX][newPosY] = field[posX][posY];
            field[posX][posY] = 0;
            zuege++;
        }
        printField();

        w.update();
        w.dispose();
        createWindow();
        chekField();
    }

    public static int getFields() {
        return fields;
    }

    public static int[][] getField() {
        return field;
    }

    public static boolean isWon() {
        return won;
    }

    

}
