package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserAuthentication {
    static Scanner scanner = new Scanner(System.in);


    static List<User> users = new ArrayList<>(List.of(new User("Vlad1234", "qwer1234")));

    public static void signIn() {
        while (true) {
            System.out.println("Are you registered?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            try {
                int answer = scanner.nextInt();
                scanner.nextLine();
                switch (answer) {
                    case 1 -> {
                        enterLoginAndPassword();
                        return;
                    }
                    case 2 -> {
                        register();
                        return;
                    }
                    default -> System.out.println("Enter 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("Error: Input must be a number!");
                scanner.nextLine();
            }
        }
    }

    private static void enterLoginAndPassword() {
        while (true) {
            System.out.println("Enter login:");
            String login = scanner.nextLine();


            User foundUser = null;
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    foundUser = user;
                    break;
                }
            }

            if (foundUser == null) {
                System.out.println("User with this login doesn't exist.");
                continue;
            }

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            if (foundUser.getPassword().equals(password)) {
                System.out.println("You are logged in");
                return;
            } else {
                System.out.println("Password is not correct. Please try again.");
            }
        }
    }

    private static void register() {

        while (true) {
            try {
                System.out.println("Enter login:");
                String login = scanner.nextLine();

                if (users.stream().anyMatch(user -> user.getLogin().equals(login))) {
                    System.out.println("User with this login already exists. Please try another login.");
                    continue;
                }
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                users.add(new User(login, password));
                System.out.println("You are registered!");
                signIn();
                return;
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());

            }
        }
    }
}

