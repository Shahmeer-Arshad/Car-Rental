
import java.util.Scanner;

class CashPayment extends PaymentMethod {
    CashPayment() {
    }

    public void processPayment(double amount) {
        System.out.println("Processing cash payment...");
        Scanner scanner = new Scanner(System.in);

        double cashReceived;
        do {
            System.out.print("Enter the amount of cash received: $");
            cashReceived = scanner.nextDouble();
            scanner.nextLine();
            if (cashReceived < amount) {
                System.out.println("Cash received is less than the amount due. Please try again.");
            }
        } while(cashReceived < amount);

        double change = cashReceived - amount;
        System.out.println("Payment of $" + amount + " received in cash.");
        System.out.println("Change: $" + change);
    }
}
