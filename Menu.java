import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class Menu {
    public static void load() {
        ProductFacade productFacade = new ProductFacade();

        productFacade.addProduct(1, "Agua Mineral", 9.90);
        productFacade.addProduct(2, "Coca-Cola", 10.90);
        productFacade.addProduct(3, "Fanta", 10.90);

        productFacade.addProduct(4, "Torta de Banana", 8.50);
        productFacade.addProduct(5, "Torta de Morango", 8.50);

        productFacade.addProduct(6, "Sanduiche Sertao", 26.00);
        productFacade.addProduct(7, "Sanduiche Amazonia", 35.90);
        productFacade.addProduct(8, "Sanduiche Carioca", 27.90);

        productFacade.addProduct(9, "Combo Natureza", List.of(
            productFacade.getProductById(1),
            productFacade.getProductById(5),
            productFacade.getProductById(7)
        ));
        productFacade.addProduct(10, "Combo Rio de Banana", List.of(
            productFacade.getProductById(3),
            productFacade.getProductById(4),
            productFacade.getProductById(8)
        ));
        productFacade.addProduct(11, "Combo Cinema", List.of(
            productFacade.getProductById(2),
            productFacade.getProductById(6)
        ));

        productFacade.addProduct(12, "Combo Familia", List.of(
            productFacade.getProductById(9),
            productFacade.getProductById(10),
            productFacade.getProductById(10)
        ));
    }

    public static void list() {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.UP);

        System.out.println("----------------------------------");
        System.out.println("List of products:");
        ProductFacade productFacade = new ProductFacade();
        productFacade.getAllProducts().forEach(product -> {
            System.out.println(product.getId() + " - " + product.getName() + " - R$" + df.format(product.getPrice()));
        });
        System.out.println("----------------------------------");
    }
}