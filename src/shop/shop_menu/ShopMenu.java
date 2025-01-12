package shop.shop_menu;

import shop.Category;
import shop.Goods;

import java.util.ArrayList;
import java.util.List;


public class ShopMenu {
    public static List<Goods> milkGoods = new ArrayList<>(
            List.of(new Goods("Cottage cheese", 2.2, 4.6),
                    new Goods("Sour cream", 3.5, 4.4),
                    new Goods("Cheese", 3.1, 4.8)
            ));
    public static List<Goods> groceryGoods = new ArrayList<>(
            List.of(new Goods("Pasta", 4, 4.9),
                    new Goods("Buckwheat", 2.5, 4.7),
                    new Goods("Rise", 3.2, 4.1)
            ));
    public static Category milk = new Category("Milk", milkGoods);
    public static Category grocery = new Category("Grocery", groceryGoods);

    public static List<Category> categories = new ArrayList<>(List.of(milk, grocery));

}
