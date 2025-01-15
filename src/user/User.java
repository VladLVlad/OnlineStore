package user;

import shop.Basket;
import shop.Goods;

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

public class User {
    private String login;
    private String password;
    private Basket userBasket;

    private List<Goods> purchasedGoods;

    public User(String login, String password) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty.");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }
        this.login = login;
        this.password = password;
        this.userBasket = new Basket();
        this.purchasedGoods = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty.");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }
        this.password = password;
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

        if (dateTime == null) {
            System.err.println("Invalid date: dateTime is null");
        } else {
            String formattedDate;
            try {
                formattedDate = dateTime.format(formatter);
                System.out.printf("%s: %s%n", bundle.getString("data"), formattedDate);
                System.out.println();
            } catch (DateTimeException e) {
                System.err.println("Invalid date format: " + e.getMessage());
            }
        }
        double total = 0;

        System.out.printf("%-15s %10s%n", bundle.getString("goods"), bundle.getString("price"));
        System.out.println("--------------------------");

        for (Goods goods : getPurchasedGoods()) {

            String localizedName = bundle.getString(goods.getNameKey());
            if (Double.isNaN(goods.getPrice()) || Double.isInfinite(goods.getPrice())) {
                System.err.println("Invalid price: " + goods.getPrice());
            } else {
                System.out.printf("%-15s %10s%n", localizedName, currencyFormatter.format(goods.getPrice()));
            }
            total += goods.getPrice();
        }

        System.out.println("--------------------------");
        if (Double.isNaN(total) || Double.isInfinite(total)) {
            System.err.println("Invalid total: " + total);
        } else {
            System.out.printf("%-15s %10s%n", bundle.getString("total"), currencyFormatter.format(total));
        }
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' + "\n" +
                "password='" + showPassword('*') + '\'';
    }
}
