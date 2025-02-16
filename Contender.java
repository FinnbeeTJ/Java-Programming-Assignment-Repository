// Project: Module 4 Threads & Concurrency
// Name: Teddy Jones
// Course: COP3330.26824
// Date: February 16, 2025
// Program Objective: This program introduces the user to the concepts of Threads & Concurrency via the UltimateBattleApp
// This class contains the runnable for the UltimateBattleApp

import java.util.Random;

class Contender implements Runnable {
    private String name;
    private int action;
    private int totalAction;
    private int maxRest;
    private static boolean winner = false;
    private Water water;

    public Contender(String name, int action, int maxRest, Water water) {
        this.name = name;
        this.action = action;
        this.totalAction = 0;
        this.maxRest = maxRest;
        this.water = water;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!winner) {
            try {
                Thread.sleep(random.nextInt(maxRest)); // Rest
                totalAction += action; // Perform action
                System.out.println(name + ": " + totalAction);

                if (totalAction >= 200) {
                    winner = true;
                    System.out.println(name + " WINS!");
                    break;
                }

                water.drink(name); // Drink water after performing action


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                System.err.println(name + " run interrupted: " + e.getMessage());
            }
        }
    }
}