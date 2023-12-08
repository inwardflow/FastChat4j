import database.DatabaseManager;
import exception.UnknownException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            try {
                Controller.INSTANCE.execute(input);
            } catch (UnknownException e) {
                e.printStackTrace();
            }

        }
    }
}
