package user;

import shop.Basket;
import shop.Goods;

public class User {
    private String login;
    private String password;
    private Basket userBasket;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.userBasket = new Basket();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return "*".repeat(password.length());
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

    public void showUserBasket() {
        System.out.println(userBasket);
    }
}
