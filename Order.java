package SCart;

public class Order {
    private Cart cart;
    private Discount discount;
    private Payment payment;

    // 🔧 Constructor
    public Order(Cart cart, Discount discount, Payment payment) {
        this.cart = cart;
        this.discount = discount;
        this.payment = payment;
    }

    // 📦 Place the order
    public void placeOrder() {
        System.out.println("------------- ORDER DETAILS -------------");

        // 🛒 Show cart items
        cart.viewCart();

        // 💰 Calculate total
        double totalAmount = cart.calculatePrice();
        System.out.println("Subtotal: ₹" + totalAmount);

        // 🎁 Apply discount
        double discountedAmount = discount.applyDiscount(totalAmount);
        System.out.println("Amount after Cart.Discount: ₹" + discountedAmount);

        // 💳 Make payment using selected method
        payment.pay(discountedAmount); // ✅ Correct way to call

        System.out.println("✅ ORDER PLACED SUCCESSFULLY");
        System.out.println("-----------------------------------------");
    }
}
