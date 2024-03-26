import java.util.List;

public class ProductFacade {
    private ProductFactory productFactory;
    private ProductRegister productRegister;

    public ProductFacade() {
        productFactory = new ProductFactory();
        productRegister = ProductRegister.getInstance();
    }

    public void addProduct(int id, String name, double price) {
        IProduct product = productFactory.createProduct(id, name, price);
        productRegister.addProduct(product);
    }

    public void addProduct(int id, String name, List<IProduct> products) {
        IProduct product = productFactory.createProduct(id, name, products);
        productRegister.addProduct(product);
    }

    public List<IProduct> getAllProducts() {
        return productRegister.getAllProducts();
    }

    public IProduct getProductById(int id) {
        return productRegister.getProductById(id);
    }

}