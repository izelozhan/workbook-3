package com.pluralsight;
import java.io.InputStream;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoose;
        InputStream is;

        // continue to print till user enter a valid number.
        do {
            System.out.println("Choose the story you want to read: \n");
            System.out.println("1- Goldilocks \n");
            System.out.println("2- Hansel and Gretel \n");
            System.out.println("3- Mary Had a Little Lamb");

            userChoose = scanner.nextInt();
            scanner.nextLine();
            if (userChoose < 1 || userChoose > 3) {
                System.out.println("Enter a valid number to read the story.\n");
            }
        } while (userChoose < 1 || userChoose > 3);

        // using switch to get stories by entered number
        switch (userChoose) {
            case 1:
                is = BedtimeStories.class.getResourceAsStream("/goldilocks.txt");
                break;
            case 2:
                is = BedtimeStories.class.getResourceAsStream("/hansel_and_gretel.txt");
                break;
            case 3:
                is = BedtimeStories.class.getResourceAsStream("/mary_had_a_little_lamb.txt");
                break;
            default:
                System.out.println("Please select a number to read story");
                return;
        }
        if (is == null) {
            System.out.println("Story is not found!");
            return;
        }

        //try and catch
        try {
            Scanner fileScanner = new Scanner(is);
            while (fileScanner.hasNextLine()) {
                String input = fileScanner.nextLine();
                System.out.println(input);
            }
        } catch (Exception e) {
            System.out.println("Error occurred");
        }
        scanner.close();
    }
}
