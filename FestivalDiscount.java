package SCart;

public class FestivalDiscount extends Discount {
    @Override
    public double applyDiscount(double totalAmount){
        System.out.println("FESTIVAL DISCOUNT APPLIED (20%)");
        return totalAmount*0.8;
}
}
