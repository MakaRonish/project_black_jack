/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author ronis
 */

public class Player {
    private final String name;
    private final Hand hand;
    private int score; 

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public void resetHand() {
        hand.clear();
    }

    public boolean isBust() {
        return hand.isBust();
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + "'s hand: " + hand + " (Total: " + hand.getValue() + ")";
    }
}

