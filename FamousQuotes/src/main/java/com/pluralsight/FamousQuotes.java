package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String[] quotes = {"Life is what happens when you're making other plans. \n-Bob Dylan",
                "The only way to do great work is to love what you do. \n-Steve Jobs",
                "Not all those who wander are lost. \n-J.R.R. Tolkien",
                "You only live once, but if you do it right, once is enough. \n-Mae West",
                "Be the change that you wish to see in the world. \n-Mahatma Gandhi",
                "The only thing we have to fear is fear itself. \n-Franklin D. Roosevelt",
                "Ask not what your country can do for you - ask what you can do for your country. \n-John F. Kennedy",
                "Many people would sooner die than think; In fact, they do so. \n-Bertrand Russell",
                "The best way to predict the future is to invent it. \n–Alan Kay",
                "Act as if what you do makes a difference. It does. \n–William James"
        };

        boolean loop = true;

        while (loop) {
            System.out.println("Select a number between 1 to 10 to see your quote; ");
            try {
                int input = myScanner.nextInt();
                myScanner.nextLine();

                if (input >= 1 && input <= quotes.length) {
                    System.out.println("Your quote is: \n" + quotes[input - 1]);
                    System.out.println("Do you want to choose another quote? (Yes/No)");
                    String loopInput = myScanner.nextLine().trim();
                    if (loopInput.equalsIgnoreCase("no")) {
                        loop = false;
                        System.out.println("See you next time!");
                    }
                } else {
                    System.out.println("Please enter a number between 1 to 10.");
                }

            } catch (Exception e) {
                System.out.println("Your number was out of range. Try again.");

            }

        }
    }
}
