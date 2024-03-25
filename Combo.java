import java.util.List;

public class Combo implements IProduct {
    private int id;
    private String name;
    private List<IProduct> products;

    public Combo(int id, String name, List<IProduct> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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
        return products.stream()
                       .mapToDouble(product -> product.getPrice())
                       .sum() * 0.9;
    }
}