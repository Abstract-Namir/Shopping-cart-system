package SCart;

public class SMain {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addProduct(new Electronic("Samsung TV", 20000, 12));
        cart.addProduct(new Clothing("Leather jacket", 3000, "L", "Levi's"));

// 💸 Choose Cart.Discount
        Discount discount = new StudentDiscount(); // Or Cart.FestivalDiscount, Cart.NoDiscount

// 💳 Choose Cart.Payment Method
        Payment payment = new CreditCardPayment("1234567812345678"); // or new UPIPayment("namir@upi")

// 📦 Create Cart.Order and Place it
        Order order = new Order(cart, discount, payment);
        order.placeOrder();
    }
}