/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author ronis
 */



import java.util.Scanner;

public class Game {
    private final Deck deck;
    private Player player;
    private final Player dealer;
    private final Scanner scanner;

    public Game() {
        this.deck = new Deck();
        this.dealer = new Player("Dealer");
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Blackjack!");
        registerPlayer();
        boolean playAgain;

        do {
            deck.shuffle();
            playRound();
            System.out.println("\nCurrent Score: " + player.getName() + " - " + player.getScore() +
                               " | Dealer - " + dealer.getScore());
            System.out.println("Do you want to play another round? (y/n)");
            playAgain = scanner.nextLine().equalsIgnoreCase("y");
            resetHands();
        } while (playAgain);

        System.out.println("\nThank you for playing Blackjack! Final Score: " +
                           player.getName() + " - " + player.getScore() + 
                           " | Dealer - " + dealer.getScore());
    }

    private void registerPlayer() {
        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        System.out.println("Welcome, " + player.getName() + "!");
    }

    private void playRound() {
        dealInitialCards();
        playerTurn();
        if (!player.isBust()) {
            dealerTurn();
        }
        determineWinner();
    }

    private void dealInitialCards() {
        player.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
    }

    private void playerTurn() {
        boolean stand = false;
        while (!stand) {
            System.out.println("\n" + player);
            System.out.println("Dealer's visible card: " + dealer.getHand().toString().split(",")[0]);
            System.out.println("Would you like to hit or stand? (h/s)");

            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCardToHand(deck.drawCard());
                if (player.isBust()) {
                    System.out.println(player);
                    System.out.println("You bust!");
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                stand = true;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }
    }

    private void dealerTurn() {
        System.out.println("\nDealer's turn.");
        while (dealer.getHand().getValue() < 17) {
            dealer.addCardToHand(deck.drawCard());
        }
        System.out.println(dealer);
    }

    private void determineWinner() {
        int playerValue = player.getHand().getValue();
        int dealerValue = dealer.getHand().getValue();

        if (player.isBust()) {
            System.out.println("Dealer wins this round!");
            dealer.incrementScore();
        } else if (dealer.isBust() || playerValue > dealerValue) {
            System.out.println("You win this round!");
            player.incrementScore();
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins this round!");
            dealer.incrementScore();
        } else {
            System.out.println("It's a tie!");
        }
    }

    private void resetHands() {
        player.resetHand();
        dealer.resetHand();
    }
}
