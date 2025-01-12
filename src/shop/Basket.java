package shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Goods> basketGoods;

    public Basket() {
        this.basketGoods = new ArrayList<>();
    }

    public List<Goods> getBasketGoods() {
        return basketGoods;
    }

    public void addGoods(Goods goods) {
        this.basketGoods.add(goods);
    }

    public void removeGoods(Goods goods) {
        this.basketGoods.remove(goods);
    }

    @Override
    public String toString() {
        if (basketGoods.isEmpty()) {
            return "Basket is empty.";
        }
        StringBuilder sb = new StringBuilder("Basket contains:\n");
        for (Goods g : basketGoods) {
            sb.append(g).append("\n");
        }
        return sb.toString();
    }
}

