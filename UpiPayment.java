package SCart;

public class UpiPayment implements Payment {
    private String upi;
    UpiPayment(){
        this.upi=upi;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paid $:" +amount+ " using UPI");
    }
}
