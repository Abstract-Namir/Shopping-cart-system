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

        User user = createUser(scanner);
        Cart cart = new Cart();
        addProduct(scanner, cart);
        Discount discount = chooseDiscount(scanner);
        Payment payment = choosePayment(scanner);

        Order order = new Order(cart, discount, payment);

        System.out.println("-------------ORDER DETAILS-------------");
        user.displayInfo();
        System.out.println("Order time: " + LocalDateTime.now());
        order.placeOrder();
        System.out.println("---------------------------------------");
    }

    // USER DETAILS
    private static User createUser(Scanner scanner) {
        String name;
        do {
            System.out.print("ENTER YOUR NAME: ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("YOUR NAME CANNOT BE EMPTY");
            }
        } while (name.trim().isEmpty());
        name = name.toLowerCase();

        String email;
        do {
            System.out.print("ENTER YOUR EMAIL: ");
            email = scanner.nextLine();
            if (email.trim().isEmpty()) {
                System.out.println("EMAIL CANNOT BE EMPTY");
            } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("INVALID EMAIL FORMAT");
            }
        } while (email.trim().isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
        email = email.toLowerCase();

        return new User(name, email);
    }

    // PRODUCT SELECTION
    private static void addProduct(Scanner scanner, Cart cart) {
        int type;
        do {
            System.out.println("CHOOSE PRODUCT TYPE: ");
            System.out.println("1) ELECTRONICS");
            System.out.println("2) CLOTHING'S");
            System.out.print("ENTER YOUR CHOICE: ");
            type = scanner.nextInt();
            scanner.nextLine();

            switch (type) {
                case 1 -> addElectronic(scanner, cart);
                case 2 -> addClothing(scanner, cart);
                default -> System.out.println("INVALID CHOICE, CHOOSE AGAIN");
            }
        } while (type != 1 && type != 2);
    }

    // ELECTRONIC PRODUCT
    private static void addElectronic(Scanner scanner, Cart cart) {
        System.out.println("---------------ELECTRONICS--------------");

        String name;
        double price = 0;
        boolean valid = false;
        boolean validWarranty = false;
        int warranty = 0;

        do {
            System.out.print("ENTER PRODUCT NAME: ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("PRODUCT NAME CANNOT BE EMPTY");
            }
        } while (name.trim().isEmpty());

        do {
            System.out.print("ENTER PRODUCT'S PRICE: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("AMOUNT CANNOT BE EMPTY");
            } else {
                try {
                    price = Double.parseDouble(input);
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("INVALID AMOUNT. TRY AGAIN!");
                }
            }
        } while (!valid);

        do {
            System.out.print("ENTER WARRANTY IN MONTHS: ");
            String num = scanner.nextLine();
            if (num.trim().isEmpty()) {
                System.out.println("WARRANTY CANNOT BE EMPTY");
            } else {
                try {
                    warranty = Integer.parseInt(num);
                    validWarranty = true;
                } catch (NumberFormatException e) {
                    System.out.println("INVALID WARRANTY PERIOD. TRY AGAIN!");
                }
            }
        } while (!validWarranty);

        Electronic electronic = new Electronic(name, price, warranty);
        cart.addProduct(electronic);
    }

    // CLOTHING PRODUCT
    private static void addClothing(Scanner scanner, Cart cart) {
        System.out.println("---------------CLOTHING'S---------------");

        String name;
        double price = 0;
        boolean validPrice = false;
        boolean validSize = false;
        String size;
        String brand;

        do {
            System.out.print("ENTER PRODUCT NAME: ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("PRODUCT NAME CANNOT BE EMPTY");
            }
        } while (name.trim().isEmpty());

        do {
            System.out.print("ENTER PRODUCT'S PRICE: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("AMOUNT CANNOT BE EMPTY");
            } else {
                try {
                    price = Double.parseDouble(input);
                    validPrice = true;
                } catch (NumberFormatException e) {
                    System.out.println("INVALID AMOUNT. TRY AGAIN!");
                }
            }
        } while (!validPrice);

        do {
            System.out.print("ENTER SIZE (S/M/L/X/XL/XXL): ");
            size = scanner.nextLine().toUpperCase();
            if (size.matches("S|M|L|X|XL|XXL")) {
                validSize = true;
            } else {
                System.out.println("INVALID SIZE. CHOOSE FROM S, M, L, X, XL, XXL");
            }
        } while (!validSize);

        do {
            System.out.print("ENTER BRAND NAME: ");
            brand = scanner.nextLine();
            if (brand.trim().isEmpty()) {
                System.out.println("BRAND NAME CANNOT BE EMPTY");
            }
        } while (brand.trim().isEmpty());

        Clothing clothing = new Clothing(name, price, size, brand);
        cart.addProduct(clothing);
    }

    // DISCOUNT
    private static Discount chooseDiscount(Scanner scanner) {
        int choice;
        Discount discount = null;

        do {
            System.out.println("CHOOSE THE DISCOUNT YOU WANT: ");
            System.out.println("1) STUDENT DISCOUNT (10%)");
            System.out.println("2) FESTIVAL DISCOUNT (20%)");
            System.out.println("3) NO DISCOUNT");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    discount = new StudentDiscount();
                    System.out.println("STUDENT DISCOUNT HAS BEEN APPLIED");
                }
                case 2 -> {
                    discount = new FestivalDiscount();
                    System.out.println("FESTIVAL DISCOUNT HAS BEEN APPLIED");
                }
                case 3 -> {
                    discount = new NoDiscount();
                    System.out.println("NO DISCOUNT HAS BEEN APPLIED");
                }
                default -> System.out.println("INVALID CHOICE, CHOOSE AGAIN");
            }
        } while (choice != 1 && choice != 2 && choice != 3);

        return discount;
    }

    // PAYMENT
    private static Payment choosePayment(Scanner scanner) {
        int choice;
        Payment payment = null;

        do {
            System.out.println("CHOOSE PAYMENT METHOD: ");
            System.out.println("1) CREDIT CARD");
            System.out.println("2) UPI");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    String card;
                    do {
                        System.out.print("Enter card number: ");
                        card = scanner.nextLine();
                        if (card.trim().isEmpty()) {
                            System.out.println("CARD NUMBER CANNOT BE EMPTY");
                        }
                    } while (card.trim().isEmpty());
                    payment = new CreditCardPayment(card);
                }
                case 2 -> {
                    String upi;
                    do {
                        System.out.print("Enter UPI ID: ");
                        upi = scanner.nextLine();
                        if (upi.trim().isEmpty()) {
                            System.out.println("UPI ID CANNOT BE EMPTY");
                        }
                    } while (upi.trim().isEmpty());
                    payment = new UpiPayment(upi);
                }
                default -> System.out.println("INVALID CHOICE, PLEASE SELECT AGAIN");
            }

        } while (choice != 1 && choice != 2);

        return payment;
    }
}
