package SCart;

public class Product {
    // Private fields
    private String name;
    private int productId;
    private double price;
    private static int productCounter = 0;

    //  Parameterized Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        productCounter++;
        this.productId = productCounter;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    // Display method
    public void displayInfo() {
        System.out.println("------ PRODUCT DETAILS ------");
        System.out.println("Cart.Product : " + name);
        System.out.println("Price   : ₹" + price);    // changed $ to ₹ for India
        System.out.println("Cart.Product ID: " + productId);
    }
}
