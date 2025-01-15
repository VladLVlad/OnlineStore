import menu.StartWindow;
import shop.Goods;
import user.UserAuthentication;

import java.util.Locale;

import static menu.StartWindow.*;
import static user.UserAuthentication.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("en", "US"));
        showStartWindow();
    }
}
