package SCart;

public class Clothing extends Product {
    private String size;
    private String brand;

    // Constructor
    public Clothing(String name, double price, String size, String brand) {
        super(name, price);  // 🪜 call to parent constructor
        this.size = size;
        this.brand = brand;
    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    // 🖨Display method
    @Override
    public void displayInfo() {
        super.displayInfo();  // calls Cart.Product's displayInfo()
        System.out.println("Size   : " + size);
        System.out.println("Brand  : " + brand);
        System.out.println("------------------------------");
    }
}
