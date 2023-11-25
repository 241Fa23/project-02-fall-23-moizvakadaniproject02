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
        char choice;

        // TODO code application logic here
        System.out.println("Welcome to JavaQuest!");
        System.out.println("Stay alive and increase your score!\n");
        System.out.println("Choose a character...\n{k}Knight || {h}Healer || {w}Wizard || {t}Thief");

        Player player;
        do {
            choice = scanner.next().charAt(0);
            switch (choice) {
                case 'k':
                    System.out.println("\nWelcome, Knight!\n");
                    //player = new Knight();
                    break;
                case 'h':
                    System.out.println("\nWelcome, Healer!\n");
                    //player = new Healer();
                    break;
                case 'w':
                    System.out.println("\nWelcome, Wizard!\n");
                    //player = new Wizard();
                    break;
                case 't':
                    System.out.println("\nWelcome, Thief!\n");
                    //player = new Thief();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    continue;
            }
        } while (choice == 'k' || choice == 'h' || choice == 'w' || choice == 't');

        System.out.println("What would you like to do?\n{?}Status Report || }{n}{s}{e}{w} Move 1 Space North, South, East, or West || {q}Quit");

    }
}
