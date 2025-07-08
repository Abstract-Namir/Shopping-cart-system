📦 Online Shopping Cart System (Java OOP)
-------------------------------------------

A simple, object-oriented Java console application that simulates an online shopping experience.
Built using core OOP concepts such as inheritance, abstraction, polymorphism, composition, and interfaces.

📁 Features
-------------------------------------------

✅ Add products to cart

✅ View cart contents

✅ Apply discounts (e.g. Student, Festival)

✅ Make payments (UPI or Credit Card)

✅ View full order summary with calculated totals

🧱 Technologies Used
-------------------------------------------

Java (JDK 17+ recommended)

IntelliJ IDEA (IDE)

Java OOP (Classes, Objects, Inheritance, Interfaces)

Collections (ArrayList)

📦 Classes & OOP Design
-------------------------------------------
| Class                                 | Responsibility                                     |
| ------------------------------------- | -------------------------------------------------- |
| `Product`                             | Base class for all products                        |
| `Electronic` / `Clothing`             | Subclasses with extra fields (e.g. warranty, size) |
| `Cart`                                | Holds a list of products                           |
| `Discount`                            | Abstract class for discounts                       |
| `StudentDiscount`, `FestivalDiscount` | Implement discount strategy                        |
| `Payment`                             | Interface for payment methods                      |
| `UPIPayment`, `CreditCardPayment`     | Implement `pay()` method                           |
| `Order`                               | Combines Cart, Payment, and Discount               |
| `Main`                                | Executes the flow (add, pay, print receipt)        |

🚀 How to Run
-------------------------------------------

Clone or download the repository

Open in IntelliJ IDEA

Run Main.java inside the main package

Follow console prompts or test predefined scenarios

