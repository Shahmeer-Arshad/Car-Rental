public class Rental {
    private int rentalDuration;
    private Car rentedCar;
    private Customer customer;

    public Rental(int rentalDuration, Car rentedCar, Customer customer) {
        this.rentalDuration = rentalDuration;
        this.rentedCar = rentedCar;
        this.customer = customer;
    }

    public int getRentalDuration() {
        return this.rentalDuration;
    }

    public Car getRentedCar() {
        return this.rentedCar;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void displayRentalInfo() {
        System.out.println("Rental Duration: " + this.rentalDuration);
        System.out.println("Customer Information:");
        this.customer.displayCustomerInfo();
        System.out.println("Rented Car Information:");
        this.rentedCar.displayCarInfo();
    }
}
