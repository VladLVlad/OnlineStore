package menu;

import i18n.LocaleConfig;
import shop.Category;
import shop.shop_menu.ShopMenu;
import user.UserAuthentication;

import java.time.LocalDateTime;
import java.util.Scanner;

import static shop.shop_menu.ShopMenu.*;
import static user.UserAuthentication.*;

public class StartWindow {

    public static Scanner scanner = new Scanner(System.in);

    public static void showStartWindow() {
        while (true) {
            System.out.println("1. User authentication");
            System.out.println("2. User information");
            System.out.println("3. Product catalog");
            System.out.println("4. My Basket");
            System.out.println("5. Buy goods from my basket");
            System.out.println("6. Purchased goods");
            System.out.println("7. Log out of my account");
            try {
                int answer = scanner.nextInt();
                scanner.nextLine();
                switch (answer) {
                    case 1 -> {
                        signIn();
                        return;
                    }
                    case 2 ->{
                        if (checkFlag()) continue;
                        System.out.println(loggedUser);
                    }
                    case 3 -> {
                        if (checkFlag()) continue;
                        chooseCategory();
                        return;
                    }
                    case 4 -> {
                        if (checkFlag()) continue;
                        loggedUser.showUserBasket();
                    }
                    case 5 -> {
                        if (checkFlag()) continue;
                        if (loggedUser.getUserBasket().getBasketGoods().isEmpty()){
                            System.out.println("Your basket is empty");
                            continue;
                        }
                        loggedUser.getUserBasket().getBasketGoods().forEach(goods -> {
                            loggedUser.getPurchasedGoods().add(goods);
                        });
                        loggedUser.getUserBasket().getBasketGoods().removeAll(loggedUser.getPurchasedGoods());
                        LocaleConfig.dateTime = LocalDateTime.now();
                        System.out.println("The purchase was successful");
                    }
                    case 6 -> {
                        if (checkFlag()) continue;
                        loggedUser.showPurchasedGoods();
                    }
                    case 7 -> {
                        if (checkFlag()) continue;
                        flag = false;
                        loggedUser = null;
                        System.out.println("You are logged out");

                    }
                    default -> System.out.println("Enter numbers from 1 to 7");
                }
            } catch (Exception e) {
                System.out.println("Error: Input must be a number!");
                scanner.nextLine();
            }
        }
    }

    private static void chooseCategory() {
        while (true) {
            System.out.println("Categories:");
            int count = 1;
            for (Category category :
                    categories) {
                System.out.println(count + ". " + category.getName());
                count++;
            }
            System.out.println("3. Back");
            try {
                int answer = scanner.nextInt();
                scanner.nextLine();
                switch (answer) {
                    case 1 -> {
                        categories.get(0).getGoods().forEach(System.out::println);
                        addGoodsToBasket(0);
                        return;
                    }
                    case 2 -> {
                        categories.get(1).getGoods().forEach(System.out::println);
                        addGoodsToBasket(1);
                        return;
                    }
                    case 3 -> {
                        showStartWindow();
                        return;
                    }

                    default -> System.out.println("Enter 1, 2 or 3");
                }
            } catch (Exception e) {
                System.out.println("Error: Input must be a number!");
                scanner.nextLine();
            }
        }
    }

    private static void addGoodsToBasket(int index) {
        while (true) {
            System.out.println("1. Add " + categories.get(index).getGoods().get(0).getName());
            System.out.println("2. Add " + categories.get(index).getGoods().get(1).getName());
            System.out.println("3. Add " + categories.get(index).getGoods().get(2).getName());
            System.out.println("4. My Basket");
            System.out.println("5. Back");
            try {
                int answer = scanner.nextInt();
                scanner.nextLine();
                switch (answer) {
                    case 1 -> {
                        loggedUser.getUserBasket().addGoods(categories.get(index).getGoods().get(0));
                        System.out.println(categories.get(index).getGoods().get(0).getName() + " added to basket");
                    }
                    case 2 -> {
                        loggedUser.getUserBasket().addGoods(categories.get(index).getGoods().get(1));
                        System.out.println(categories.get(index).getGoods().get(1).getName() + " added to basket");
                    }
                    case 3 -> {
                        loggedUser.getUserBasket().addGoods(categories.get(index).getGoods().get(2));
                        System.out.println(categories.get(index).getGoods().get(2).getName() + " added to basket");
                    }
                    case 4 -> loggedUser.showUserBasket();
                    case 5 -> {
                        chooseCategory();
                        return;
                    }

                    default -> System.out.println("Enter 1, 2, 3, 4 or 5");
                }
            } catch (Exception e) {
                System.out.println("Error: Input must be a number!");
                scanner.nextLine();
            }
        }


    }

    private static boolean checkFlag() {
        if (!flag) {
            System.out.println("You need to login to your account!");
            return true;
        }
        return false;
    }
}


