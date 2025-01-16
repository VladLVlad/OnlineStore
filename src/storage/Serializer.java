package storage;

import shop.Goods;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {

    private static final String FILE_NAME = "src\\storage\\purchased_goods.ser";

    public static void serialize(List<Goods> basketGoods) {
        if (basketGoods == null) {
            throw new IllegalArgumentException("Basket goods cannot be null");
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME))) {
            oos.writeObject(basketGoods);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Goods> deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return  (List<Goods>) ois.readObject();
        } catch (IOException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found during deserialization: " + e.getMessage());
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
