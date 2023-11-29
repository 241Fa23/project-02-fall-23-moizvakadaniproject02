/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project02startingfiles;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Project02StartingFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to JavaQuest!");
        System.out.println("Stay alive and increase your score!");
        System.out.println("\nChoose a character..");
        System.out.println("(k)Knight I| (h)Healer I| (w)wizard || (t)Thief");

        String choice = scanner.nextLine().toUpperCase();
        Player player;

        switch (choice) {
            case "K":
                player = new Knight();
                break;
            case "H":
                player = new Healer();
                break;
            case "W":
                player = new Wizard();
                break;
            case "T":
                player = new Thief();
                break;
            default:
                System.out.println("Invalid choice. Exiting the game.");
                return;
        }

        System.out.println("\nWelcome, " + player.getClass().getSimpleName() + "!");
        playGame(scanner, random, player);
    }

    private static void playGame(Scanner scanner, Random random, Player player) {
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("{?}Status Report || {n}{s}{e}{w} Move 1 Space North, South, East, or West ||{q}Quit");

            String action = scanner.nextLine().toUpperCase();

            switch (action) {
                case "?":
                    System.out.println(player.toString());
                    break;
                case "N":
                case "S":
                case "E":
                case "W":
                    move(player, random, action);
                    break;
                case "Q":
                    endGame(player);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void move(Player player, Random random, String direction) {
        int scenario = random.nextInt(5); // 20% chance of foe attack

        if (scenario != 0) {
            // Benign scene
            player.increaseScore();
            System.out.println(getSceneDescription(scenario));
        } else {
            // Foe attack
            System.out.println("Oh no! You are being attacked by a " + getFoe(scenario) + "!");
            handleFoeAttack(player, random);
        }
    }

    private static String getSceneDescription(int scenario) {
        String[] scenes = {"Nothing here...", "Nice trees around here...", "Interesting cottage there...", "Potty break..."};
        return scenes[scenario - 1];
    }

    private static String getFoe(int scenario) {
        String[] foes = {"zombie", "bandit", "lobbyist"};

        // Adjust scenario to be in the range of array indices
        int adjustedScenario = (scenario - 1) % foes.length;

        return foes[adjustedScenario];
    }

    private static void handleFoeAttack(Player player, Random random) {
        System.out.println("How would you like to handle this?");
        System.out.println("(s) Special Move | (r) Run?");
        String choice = "";

        while (!choice.equals("S") && !choice.equals("R")) {
            choice = choice.toUpperCase();
            choice = choice.toUpperCase();
        }

        if (choice.equals("S")) {
            player.useSpecialMove();
            if (random.nextBoolean()) {
                System.out.println("Player wins! Increase score by 2 points!");
                player.increaseScore();
            } else {
                System.out.println("Player loses! Decrease health by 1 point.");
                player.decreaseHealth();
            }
        } else {
            if (random.nextBoolean()) {
                System.out.println("Running successful! Increase score by 1 point.");
                player.increaseScore();
            } else {
                System.out.println("Running unsuccessful! Decrease health by 1 point.");
                player.decreaseHealth();
            }
        }
        System.out.println(player.toString());
    }

    private static void endGame(Player player) {
        System.out.println("The game has come to an end! Your final stats:");
        System.out.println(player.toString());
        System.out.println("Thanks for playing!");
    }
}
