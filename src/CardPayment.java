class CardPayment extends PaymentMethod {
    CardPayment() {
    }

    public void processPayment(double amount) {
        System.out.println("Processing card payment...");
        System.out.println("Payment of $" + amount + " successfully processed using a card.");
    }
}
