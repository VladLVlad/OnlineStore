package shop;

public class Goods {

    private String nameKey;
    private String name;
    private double price;
    private double rating;

    public Goods(String nameKey, String name, double price, double rating) {
        this.nameKey = nameKey;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating;
    }
}
