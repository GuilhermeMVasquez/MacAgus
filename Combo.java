import java.util.List;

public class Combo implements IProduct {
    private int id;
    private String name;
    private List<IProduct> products;
    private IDiscount discount;

    public Combo(int id, String name, List<IProduct> products, IDiscount discount) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.discount = discount;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return discount.applyDiscount(
                products.stream()
                        .mapToDouble(product -> product.getPrice())
                        .sum());
    }
}