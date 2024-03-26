import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Interface {
    private static Scanner scanner;

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static void show() {
        System.out.println("------------------");
        System.out.println("Options:");
        System.out.println("1 - List Products");
        System.out.println("2 - Buy Items");
        System.out.println("3 - Finalize Order");
        System.out.println("4 - Clear Cart");
        System.out.println("5 - Exit");
        System.out.println("------------------");

        System.out.println("Enter an option:");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                Menu.list();
                break;
            case 2:
                interact();
                break;
            case 3:
                receipt();
                break;
            case 4:
                Cart.getInstance().clear();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void interact() {
        System.out.println("Enter the product id:");
        int id = Integer.parseInt(scanner.nextLine());

        ProductFacade productFacade = new ProductFacade();
        IProduct product = productFacade.getProductById(id);
        if (product == null) {
            System.out.println("Product not found");
            show();
        }

        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.UP);
        
        System.out.println("Product: " + product.getName());
        System.out.println("Price: R$" + df.format(product.getPrice()));

        System.out.println("How many do you want to buy?");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Do you want to buy this product? (y/n)");
        String option = scanner.nextLine();

        if (option.equals("y")) {
            Cart.getInstance().addProduct(product, quantity);
            System.out.println("Product added to cart");
        } else {
            System.out.println("Product not added to cart");
        }
    }

    public static void receipt() {
        Cart cart = Cart.getInstance();

        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.UP);

        System.out.println("------------------");
        System.out.println("Receipt:");
        cart.getProducts().forEach((product, quantity) -> {
            System.out.println("Product: " + product.getName());
            System.out.println("Price: R$" + df.format(product.getPrice()));
            System.out.println("Quantity: " + quantity);
            System.out.println("Subtotal: R$" + df.format(product.getPrice() * quantity));
        });
        System.out.println("------------------");
        System.out.println("Total: R$" + df.format(cart.getTotal()));
        System.out.println("------------------");

        System.out.println("Do you want to finalize the order? (y/n)");
        String option = scanner.nextLine();

        if (option.equals("y")) {
            System.out.println("Order finalized");
            cart.clear();
        } else {
            System.out.println("Order not finalized");
        }
    }

    public void exit() {
        scanner.close();
        System.exit(0);
    }
}