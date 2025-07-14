package order;

import cart.Cart;
import discount.Discount;
import payment.Payment;

import java.time.LocalDateTime;

public final class Order {
    private static int orderCounter = 0;  // shared by all orders
    private final int orderId;
    private final Cart cart;
    private final Discount discount;
    private final Payment payment;
    private final LocalDateTime orderTime;

    public Order(Cart cart, Discount discount, Payment payment) {
        this.cart = cart;
        this.discount = discount;
        this.payment = payment;
        orderCounter++;
        this.orderId = orderCounter;
        this.orderTime = LocalDateTime.now();
    }

    public void placeOrder() {
        System.out.println("-------------ORDER DETAILS-------------");
        System.out.println("ORDER ID   : " + orderId);
        System.out.println("ORDER TIME : " + orderTime);
        System.out.println("---------------------------------------");

        cart.viewCart();

        double totalAmount = cart.calculatePrice();
        System.out.println("Subtotal: $" + totalAmount);

        double discountedAmount = discount.applyDiscount(totalAmount);
        System.out.println("Amount after Discount: $" + discountedAmount);

        payment.pay(discountedAmount);

        System.out.println("ORDER PLACED SUCCESSFULLY");
        System.out.println("---------------------------------------");
    }

    public int getOrderId() {
        return orderId;
    }

    public static int getTotalOrders() {
        return orderCounter;
    }
}
