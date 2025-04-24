package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        String filePath = "src/main/resources/inventory.csv";
        HashMap<String, Product> inventory = new HashMap<>();

        loadInventory(filePath, inventory);

        Scanner scanner = new Scanner(System.in);
        boolean lookMore = true;

        while (lookMore) {

            System.out.print("What product name are you interested in? \n");
            String productName = scanner.nextLine().trim(); //get product name for search

            Product matchedProduct = inventory.get(productName);//get product name from inventory

            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                continue;
            } else {
                System.out.printf("We carry %s and the price is $%.2f ",
                        matchedProduct.getName(), matchedProduct.getPrice());
            }

            System.out.println("\nDo you want to search for another item? (Yes/No)");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("no")) {
                lookMore = false;
                System.out.println("See you later alligator!");
            }
        }


    }

    public static void loadInventory(String filePath, HashMap<String, Product> inventory) {
        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader buffReader = new BufferedReader(fileReader);

            String input;
            while ((input = buffReader.readLine()) != null) {
                String[] parts = input.split("\\|");

                if (parts[0].equals("id")) {
                    continue;
                }

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);

                Product newProduct = new Product(id, name, price);
                inventory.put(name, newProduct);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


