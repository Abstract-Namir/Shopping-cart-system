package SCart;

import java.util.ArrayList;

public class Cart {
    //  Private member: composition
    private ArrayList<Product> productList;

    // Constructor
    public Cart() {
        productList = new ArrayList<>();
    }

    // Add product to cart
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    // Remove product by ID
    public void removeProductByID(int productID) {
        boolean removed = false;
        for (Product p : productList) {
            if (p.getProductId() == productID) {
                productList.remove(p);
                System.out.println(p.getName() + " removed from the cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("❌ Cart.Product with ID " + productID + " not found in the cart.");
        }
    }

    // View cart contents
    public void viewCart() {
        if (productList.isEmpty()) {
            System.out.println("🛒 Cart.Cart is empty.");
        } else {
            System.out.println("🛒 Cart.Cart contains:");
            for (Product p : productList) {
                p.displayInfo();
            }
        }
    }

    // Calculate total cart price
    public double calculatePrice() {
        double total = 0.0;
        for (Product p : productList) {
            total += p.getPrice();
        }
        return total;
    }

    // Getter for productList
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
