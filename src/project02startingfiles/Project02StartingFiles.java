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

    // Creating a Scanner and Random object for user input and random events
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to JavaQuest!");
        System.out.println("Stay alive and increase your score!");
        System.out.println("\nChoose a character..");
        System.out.println("(k)Knight I| (h)Healer I| (w)wizard || (t)Thief");
        System.out.print(">>");

        // Reading the user's choice for character selection
        char choice = scanner.next().toLowerCase().charAt(0);
        Player player;

        // Creating a player object based on the user's choice
        switch (choice) {
            case 'k':
                player = new Knight();
                break;
            case 'h':
                player = new Healer();
                break;
            case 'w':
                player = new Wizard();
                break;
            case 't':
                player = new Thief();
                break;
            default:
                System.out.println("Invalid choice. Exiting the game.");
                return;
        }

        // Printing a welcome message for the chosen character and starting the game
        System.out.println("\nWelcome, " + player.getClass().getSimpleName() + "!");
        playGame(player);
    }

    // Method to handle the main game loop
    private static void playGame(Player player) {
        while (player.getHealth() > 0) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("(?) Status Report || (n) Move North || (s) Move South || (e) Move East || (w) Move West || (q) Quit");
            System.out.print(">>");

            // Reading the player's action choice
            char action = scanner.next().toLowerCase().charAt(0);
            //performing the chosen action
            switch (action) {
                case '?':
                    System.out.println(player);
                    break;
                case 'n':
                case 's':
                case 'e':
                case 'w':
                    move(player, action);
                    break;
                case 'q':
                    endGame(player);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to handle player movement
    private static void move(Player player, char direction) {
        int scenario = random.nextInt(5); // 20% chance of foe attack

        if (scenario == 0) {
            // Benign scene
            player.increaseScore();
            System.out.println(getSceneDescription(scenario));
        } else {
            // Foe attack
            System.out.println("Oh no! You are being attacked by a " + getFoe(scenario) + "!");
            handleFoeAttack(player);
        }
    }

    // Method to get a description of the current scene based on the scenario
    private static String getSceneDescription(int scenario) {
        String[] scenes = {"Nothing here...", "Nice trees around here...", "Interesting cottage there...", "Potty break..."};
        return scenes[scenario - 1];
    }

    // Method to get the type of foe based on the scenario
    private static String getFoe(int scenario) {
        String[] foes = {"zombie", "bandit", "lobbyist"};

        // Adjust scenario to be in the range of array indices
        int adjustedScenario = (scenario - 1) % foes.length;

        return foes[adjustedScenario];
    }

    // Method to handle the player's response to a foe attack
    private static void handleFoeAttack(Player player) {
        System.out.println("How would you like to handle this?");
        System.out.println("(s) Special Move || (r) Run");

        // Read the player's choice
        char choice = scanner.next().toLowerCase().charAt(0);

        if (choice == 's') {
            player.useSpecialMove();
            if (random.nextInt(100) < 60) { // Player wins 60% of the time
                System.out.println(player.getClass().getSimpleName() + " wins! Increase score by 2 points!");
                player.increaseScore();
            } else {
                System.out.println(player.getClass().getSimpleName() + " loses! Decrease health by 1 point.");
                player.decreaseHealth();
            }
        } else if (choice == 'r') {
            if (random.nextInt(100) < 50) { // Running successful 50% of the time
                System.out.println("Running successful! Increase score by 1 point.");
                player.increaseScore();
            } else {
                System.out.println("Running unsuccessful! Decrease health by 1 point.");
                player.decreaseHealth();
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
            handleFoeAttack(player);
        }
        // Displaying player status after the encounter
        System.out.println(player);

        // Checking if the player's health is zero or below to end the game
        if (player.getHealth() <= 0) {
            endGame(player);
        }
    }

    // Method to display the final stats and end the game
    private static void endGame(Player player) {
        System.out.println("****************************************************\n****************************************************");
        System.out.println("The game has come to an end! Your final stats:\n");
        System.out.println(player);
        System.out.println("Thanks for playing!");
    }
}
