package SCart;

public class User {
    // Private member variables
    private String name;
    private String email;
    private int userId;
    private static int userCount = 0;

    // Parameterized Constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        userCount++;
        this.userId = userCount;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
    }

    // Display user info
    public void displayInfo() {
        System.out.println("------ USER DETAILS ------");
        System.out.println("Name   : " + name);
        System.out.println("Email  : " + email);
        System.out.println("UserID : " + userId);
    }

    // Return current user count
    public static int getUserCount() {
        return userCount;
    }
}
