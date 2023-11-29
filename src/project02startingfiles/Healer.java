/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project02startingfiles;

/**
 *
 * @author S554271
 */
public class Healer extends Player {

    @Override
    public String getSpecialMove() {
        return "Use Sleeping Powder";
    }

    @Override
    public void useSpecialMove() {
        System.out.println("The Healer uses sleeping powder!");
    }

    @Override
    public String toString() {
        return "Healer Status:\nHealth: " + health + "\nScore: " + score
                + "\nThe Healer's special move is '" + getSpecialMove() + "'";
    }
}
