import java.io.Serializable;

public class Product implements Serializable {
    int id, quantity;
    String name;
    double price;

    // Constructor - sets up a product
    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Print product nicely
    public String toString() {
        return "ID:" + id + " | " + name + " | Qty:" + quantity + " | $" + price;
    }
}
