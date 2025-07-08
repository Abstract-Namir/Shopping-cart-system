package SCart;

public class CreditCardPayment implements Payment {
    private String CardNum;

    public CreditCardPayment(String CardNum){
        this.CardNum= CardNum;

    }
    @Override
    public void pay(double amount){
        System.out.println("Paid $: "+amount+ " using Credit Card ending in"+ CardNum.substring(CardNum.length()-4));
    }
}
