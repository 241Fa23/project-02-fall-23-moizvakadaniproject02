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

    public Healer(int health, int score) {
        super(health, score);
    }

    @Override
    public String toString() {
        return "Healer - Health: " + getHealth() + ", Score: " + getScore();
    }

    @Override
    public String getSpecialMove() {
        return "Use Sleeping Powder";
    }

    @Override
    public void useSpecialMove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
