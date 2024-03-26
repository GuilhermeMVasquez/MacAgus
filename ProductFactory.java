import java.util.List;

public class ProductFactory {
    public ProductFactory() {
    }

    public IProduct createProduct(int id, String name, double price) {
        return new Product(id, name, price);
    }

    public IProduct createProduct(int id, String name, List<IProduct> products) {
        return new Combo(id, name, products, price -> price * 0.9);
    }
}