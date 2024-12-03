import shop.Category;
import shop.Goods;
import user.User;

public class Main {
    public static void main(String[] args) {
        Category dairyProducts = new Category("Dairy Products",
                new Goods[]{
                        new Goods("Milk", 2.15, 4.6),
                        new Goods("Curd", 2.52, 4.8),
                        new Goods("Cheese", 3.56, 4.7)
                });
        Category meatProducts = new Category("Meat Products",
                new Goods[]{
                        new Goods("Sausages", 11.22, 4.4),
                        new Goods("Ham", 8, 4.7)
                });
        User user1 = new User("Vlad", "12345");
        user1.getUserBasket().addGoods(new Goods("Milk", 2.15, 4.6));
        user1.getUserBasket().addGoods(new Goods("Curd", 2.52, 4.8));
        user1.getUserBasket().addGoods(new Goods("Ham", 8, 4.7));

        System.out.println(user1.getUserBasket());
    }
}
