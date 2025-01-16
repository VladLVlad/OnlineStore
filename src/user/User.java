package user;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import shop.Basket;
import shop.Goods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static i18n.LocaleConfig.*;
import static user.UserAuthentication.isValid;

public class User {
    private String login;
    private String password;
    private Basket userBasket;

    private List<Goods> purchasedGoods;

    public User(String login, String password) throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20 || isValid(login)) {
            throw new WrongLoginException("Login inputted incorrectly", login);
        }
        if (password.length() > 20 || isValid(password) || password.length() < 4) {
            throw new WrongPasswordException("Password inputted incorrectly", password);
        }
        this.login = login;
        this.password = password;
        this.userBasket = new Basket();
        this.purchasedGoods = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

    public Basket getUserBasket() {
        return userBasket;
    }

    public String showPassword(char mask) {
        return String.valueOf(mask).repeat(password.length());
    }

    public void showUserBasket() {
        System.out.println(userBasket);
    }

    public List<Goods> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void showPurchasedGoods() {
        if (getPurchasedGoods().isEmpty()) {
            System.out.println("No purchases");
            return;
        }

        String fileName = "src\\report\\report.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            if (dateTime == null) {
                System.err.println("Invalid date: dateTime is null");
                writer.write("Invalid date: dateTime is null\n");
            } else {
                String formattedDate;
                try {
                    formattedDate = dateTime.format(formatter);
                    String dateLine = bundle.getString("data") + ": " + formattedDate + "\n";
                    System.out.printf("%s: %s%n", bundle.getString("data"), formattedDate);
                    writer.write(dateLine);
                    writer.write("\n");
                } catch (DateTimeException e) {
                    String error = "Invalid date format: " + e.getMessage() + "\n";
                    System.err.println(error);
                    writer.write(error);
                }
            }

            double total = 0;


            String header = String.format("%-15s %10s%n", bundle.getString("goods"), bundle.getString("price"));
            System.out.printf(header);
            writer.write(header);
            writer.write("--------------------------\n");
            System.out.println("--------------------------");

            for (Goods goods : getPurchasedGoods()) {
                String localizedName = bundle.getString(goods.getNameKey());
                if (Double.isNaN(goods.getPrice()) || Double.isInfinite(goods.getPrice())) {
                    String error = "Invalid price: " + goods.getPrice() + "\n";
                    System.err.println(error);
                    writer.write(error);
                } else {
                    String line = String.format("%-15s %10s%n", localizedName, currencyFormatter.format(goods.getPrice()));
                    System.out.printf(line);
                    writer.write(line);
                }
                total += goods.getPrice();
            }

            writer.write("--------------------------\n");
            System.out.println("--------------------------");


            if (Double.isNaN(total) || Double.isInfinite(total)) {
                String error = "Invalid total: " + total + "\n";
                System.err.println(error);
                writer.write(error);
            } else {
                String totalLine = String.format("%-15s %10s%n", bundle.getString("total"), currencyFormatter.format(total));
                System.out.printf(totalLine);
                writer.write(totalLine);
            }

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' + "\n" +
                "password='" + showPassword('*') + '\'';
    }
}
