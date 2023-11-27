/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project02startingfiles;

/**
 *
 * @author S554271
 */
public abstract class Player {

    private int health;
    private int score;

    public Player() {
        health = 10;
        score = 0;
    }

    public abstract String getSpecialMove();

    public abstract void useSpecialMove();

    public void increaseScore() {
        score++;
    }

    public void decreaseHealth() {
        health--;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Status:\nHealth: " + health + "\nScore: " + score + "\nThe "
                + getClass().getSimpleName() + "'s special move is '" + getSpecialMove() + "'";
    }
}
