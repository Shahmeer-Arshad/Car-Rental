import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        System.out.println("                           CAR RENTAL SYSTEM                      ");

        while(true) {
            while(!loggedIn) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (username.equals("Shahmeer") && password.equals("123")) {
                    loggedIn = true;
                    System.out.println("Login successful!");
                    System.out.println();
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                    System.out.println();
                }
            }

            RentalSystem rentalSystem = new RentalSystem();

            int choice;
            do {
                System.out.println("Car Rental System");
                System.out.println("1. Add Car");
                System.out.println("2. Remove Car");
                System.out.println("3. Add Customer");
                System.out.println("4. Rent Car");
                System.out.println("5. Return Car");
                System.out.println("6. Display Available Cars");
                System.out.println("7. Display Rented Cars");
                System.out.println("8. Provide Customer Feedback");
                System.out.println("9. Make a Payment");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        rentalSystem.addCar();
                        break;
                    case 2:
                        rentalSystem.removeCar();
                        break;
                    case 3:
                        rentalSystem.addCustomer();
                        break;
                    case 4:
                        rentalSystem.rentCar();
                        break;
                    case 5:
                        rentalSystem.returnCar();
                        break;
                    case 6:
                        rentalSystem.displayAvailableCars();
                        break;
                    case 7:
                        rentalSystem.displayRentedCars();
                        break;
                    case 8:
                        provideFeedback(scanner);
                        break;
                    case 9:
                        makePayment(scanner);
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println();
            } while(choice != 10);

            scanner.close();
            return;
        }
    }

    private static void provideFeedback(Scanner scanner) {
        System.out.print("Enter your feedback: ");
        String feedback = scanner.nextLine();
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.processFeedback(feedback);
    }

    private static void makePayment(Scanner scanner) {
        System.out.println("Select payment method:");
        System.out.println("1. Card Payment");
        System.out.println("2. Cash Payment");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Object paymentMethod;
        if (choice == 1) {
            paymentMethod = new CardPayment();
        } else {
            if (choice != 2) {
                System.out.println("Invalid choice. Payment failed.");
                return;
            }

            paymentMethod = new CashPayment();
        }

        double amount = 0.0;
        System.out.print("Enter the payment amount: ");
        amount = scanner.nextDouble();
        scanner.nextLine();
        ((PaymentMethod)paymentMethod).processPayment(amount);
    }
    }
