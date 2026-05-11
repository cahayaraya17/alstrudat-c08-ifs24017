package del.alstrudat;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Program program = new Program();

        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ", 3);
            String command = parts[0];

            if (command.equals("INSERT")) {
                String key = parts[1];
                String value = parts[2];
                program.insert(key, value);
            } else if (command.equals("SEARCH")) {
                String key = parts[1];
                String result = program.search(key);
                System.out.println(result);
            } else if (command.equals("DELETE")) {
                String key = parts[1];
                program.delete(key);
            } else if (command.equals("DISPLAY")) {
                program.display();
            } else if (command.equals("COUNT")) {
                System.out.println(program.count());
            }
        }

        scanner.close();
    }
}