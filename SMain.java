package SCart;

import model.*;
import cart.Cart;
import discount.*;
import payment.*;
import order.Order;

import java.time.LocalDateTime;
import java.util.Scanner;


public class SMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//      CREATE USER
        System.out.print("ENTER YOUR NAME: ");
        String name = scanner.nextLine();
        System.out.print("ENTER YOUR EMAIL: ");
        String email = scanner.nextLine();

        User user = new User(name, email);
        Cart cart = new Cart();

//        PRODUCT ADDING LOOP
        System.out.println("ADD PRODUCT IN YOUR CART");
        String choice;
        int type;

        do {
            System.out.println("CHOOSE PRODUCT TYPE: ");
            System.out.println("1) ELECTRONICS");
            System.out.println("2) CLOTHING'S");
            System.out.print("ENTER YOUR CHOICE");
            type = scanner.nextInt();
            scanner.nextLine();
            switch (type) {
                case 1:
                    System.out.println("---------------ELECTRONICS--------------");
                    System.out.print("ENTER PRODUCT NAME: ");
                    String eName = scanner.nextLine();
                    System.out.print("ENTER PRODUCT'S PRICE: ");
                    double ePrice = scanner.nextDouble();
                    System.out.print("ENTER WARRANTY IN MONTHS: ");
                    int warranty = scanner.nextInt();
                    Electronic electronic = new Electronic(eName, ePrice, warranty);
                    cart.addProduct(electronic);
                    break;
                case 2:
                    System.out.println("---------------CLOTHING'S---------------");
                    System.out.print("ENTER PRODUCT NAME: ");
                    String cName = scanner.nextLine();
                    System.out.print("ENTER PRODUCT'S PRICE: ");
                    double cPrice = scanner.nextDouble();
                    System.out.print("ENTER SIZE (S/M/L/X/XL/XXL): ");
                    String size = scanner.nextLine();
                    System.out.print("ENTER BRAND NAME: ");
                    String brand = scanner.nextLine();
                    Clothing cloths = new Clothing(cName, cPrice, size, brand);
                    cart.addProduct(cloths);
                    break;
                default:
                    System.out.println("INVALID CHOICE, CHOOSE AGAIN ");
            }
        } while (type != 1 && type != 2);


//    CHOOSE DISCOUNT
        int ChooseDiscount;
        Discount discount=null;

        do {
            System.out.println("CHOOSE THE DISCOUNT YOU WANT: ");
            System.out.println("1) STUDENT DISCOUNT (10%)");
            System.out.println("2) FESTIVAL DISCOUNT (20%)");
            System.out.println("3) NO DISCOUNT");
            ChooseDiscount = scanner.nextInt();
            scanner.nextLine();

            switch(ChooseDiscount){
                case 1: System.out.println("STUDENT DISCOUNT");
                discount=new StudentDiscount();
                    System.out.println("STUDENT DISCOUNT HAS BEEN APPLIED OF 10%");
                    break;

                case 2: System.out.println("FESTIVAL DISCOUNT");
                discount=new FestivalDiscount();
                    System.out.println("FESTIVAL DISCOUNT HAS BEEN APPLIED OF 20%");
                    break;

                case 3: System.out.println("NO DISCOUNT");
                discount=new NoDiscount();
                    System.out.println("NO DISCOUNT HAS BEEN APPLIED");
                    break;

                default: System.out.println("INVALID CHOICE, CHOOSE AGAIN ");
            }
        } while (ChooseDiscount != 1 && ChooseDiscount != 2 && ChooseDiscount != 3);

//        CHOOSE PAYMENT METHOD
        int choosePaymentMethod;
        Payment payment=null;

        do {
            System.out.println("CHOOSE PAYMENT METHOD: ");
            System.out.println("1) CREDIT CARD");
            System.out.println("2) UPI");
            System.out.print("Enter your choice: ");

            choosePaymentMethod = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choosePaymentMethod) {
                case 1:
                    System.out.println("CREDIT CARD METHOD HAS BEEN SELECTED");
                    System.out.print("Enter card number: ");
                    String card = scanner.nextLine();
                    payment = new CreditCardPayment(card);
                    break;

                case 2:
                    System.out.println("UPI PAYMENT HAS BEEN SELECTED");
                    System.out.print("Enter UPI ID: ");
                    String upi = scanner.nextLine();
                    payment = new UpiPayment(upi);
                    break;

                default:
                    System.out.println("INVALID CHOICE, PLEASE SELECT AGAIN");
            }

        } while (choosePaymentMethod != 1 && choosePaymentMethod != 2);

//        PLACE ORDER
        Order order=new Order(cart,discount,payment);
        System.out.println("-------------ORDER DETAILS-------------");
        user.displayInfo();
        System.out.println("Order time: "+LocalDateTime.now());
        order.placeOrder();
        System.out.println("---------------------------------------");
    }
}
