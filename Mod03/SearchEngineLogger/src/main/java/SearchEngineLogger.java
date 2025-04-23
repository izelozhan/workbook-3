import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
//        2023-09-06 12:42:45
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = today.format(fmt);

        try {
            Scanner scanner = new Scanner(System.in);
            FileWriter writer = new FileWriter("logs.txt");
            boolean exit = false;

            while (exit == false) {
                System.out.println("Enter a search term (X to exit) \n");
                System.out.println("a. Launching the application");
                System.out.println("b. Searching for a term");
                System.out.println("c. Exiting the application");
                String input = scanner.nextLine();

                switch (input.trim()) {
                    case "a":
                        writer.write(formattedDate + " launch" + "\n");
                        System.out.println(formattedDate + " launch");
                        break;
                    case "b":
                        System.out.println("What do you want to search?");
                        String searchInput = scanner.nextLine();

                        writer.write(formattedDate + " search : " + searchInput + "\n");
                        System.out.println(formattedDate + " search : " + searchInput);
                        break;
                    case "c", "x":
                        writer.write(formattedDate + " exit" + "\n");
                        System.out.println(" exit");
                        exit = true;
                        break;

                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
