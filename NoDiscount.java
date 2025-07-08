package SCart;

public class NoDiscount extends Discount {
    @Override
    public double applyDiscount(double totalAmount){
        System.out.println("NO DISCOUNT APPLIED");
        return totalAmount;
}
}
