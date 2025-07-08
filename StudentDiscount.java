package SCart;

public class StudentDiscount extends Discount {
    @Override
    public double applyDiscount(double totalAmount){
        System.out.println("STUDENT DISCOUNT APPLIED (10%)");
        return totalAmount*0.9;
    }
}

