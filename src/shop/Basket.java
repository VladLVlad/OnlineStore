package shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Goods> purchasedGoods;

    public Basket() {
        this.purchasedGoods = new ArrayList<>();
    }

    public List<Goods> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void setPurchasedGoods(List<Goods> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

    public void addGoods(Goods goods) {
        this.purchasedGoods.add(goods);
    }

    public void removeGoods(Goods goods) {
        this.purchasedGoods.remove(goods);
    }

    @Override
    public String toString() {
        if (purchasedGoods.isEmpty()) {
            return "Basket is empty.";
        }
        StringBuilder sb = new StringBuilder("Basket contains:\n");
        for (Goods g : purchasedGoods) {
            sb.append(g).append("\n");
        }
        return sb.toString();
    }
}

