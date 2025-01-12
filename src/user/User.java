package user;

import shop.Basket;
import shop.Goods;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Purchased goods:");
        for (Goods goods:
             getPurchasedGoods()) {
            System.out.println(goods);
        }

    }

    @Override
    public String toString() {
        return "login='" + login + '\'' + "\n" +
                "password='" + showPassword('*') + '\'';
    }
}
