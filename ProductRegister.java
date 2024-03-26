import java.util.ArrayList;
import java.util.List;

public class ProductRegister {
    private static ProductRegister instance;
    private List<IProduct> products;

    private ProductRegister() {
        products = new ArrayList<>();
    }

    public static ProductRegister getInstance() {
        if (instance == null)
            instance = new ProductRegister();
        return instance;
    }

    public void addProduct(IProduct product) {
        products.add(product);
    }

    public List<IProduct> getAllProducts() {
        return products;
    }

    public IProduct getProductById(int id) {
        return products.stream()
                       .filter(product -> product.getId() == id)
                       .findFirst()
                       .orElse(null);
    }
}