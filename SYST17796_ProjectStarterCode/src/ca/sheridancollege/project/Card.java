/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author ronis
 */
public class Card {
    private final String suit;
    private final String rank;
    private final int value;
    
    public Card(String suit, String rank, int value){
        this.suit=suit;
        this.rank=rank;
        this.value=value;
    }
    public int getValue(){
        return value;
    }
    
    @Override
    public String toString(){
        return rank+"of"+suit;
    }
    
}
