import java.util.HashMap;

public class Cart {
    private static Cart instance;
    private HashMap<IProduct, Integer> products;
    
    private Cart() {
        products = new HashMap<>();
    }

    public static Cart getInstance() {
        if (instance == null)
            instance = new Cart();
        return instance;
    }

    public void addProduct(IProduct product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    public HashMap<IProduct, Integer> getProducts() {
        return products;
    }

    public double getTotal() {
        return products.entrySet()
                       .stream()
                       .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                       .sum();
    }

    public void clear() {
        products.clear();
    }
}