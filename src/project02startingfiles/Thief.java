/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project02startingfiles;

/**
 *
 * @author S554271
 */
public class Thief extends Player {

    @Override
    public String getSpecialMove() {
        return "Sneak By";
    }

    @Override
    public void useSpecialMove() {
        System.out.println("The Thief sneaks by!");
    }
}
