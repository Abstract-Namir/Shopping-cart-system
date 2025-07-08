package SCart;

public class Electronic extends Product {
    private int warrantyInMonths;

    // Constructor
    public Electronic(String name, double price, int warrantyInMonths) {
        super(name, price); // calls Cart.Product constructor
        this.warrantyInMonths = warrantyInMonths;
    }

    // Getter
    public int getWarrantyInMonths() {
        return warrantyInMonths;
    }

    // Display product info + warranty
    @Override
    public void displayInfo() {
        super.displayInfo(); // prints name, price, productId
        System.out.println("Warranty : " + warrantyInMonths + " months");
        System.out.println("------------------------------");
    }
}
