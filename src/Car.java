public class Car {
    private String make;
    private String model;
    private boolean availability;
    private double rentalPrice;
    private int year;

    public Car(String make, String model, boolean availability, double rentalPrice, int year) {
        this.make = make;
        this.model = model;
        this.availability = availability;
        this.rentalPrice = rentalPrice;
        this.year = year;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public boolean isAvailable() {
        return this.availability;
    }

    public double getRentalPrice() {
        return this.rentalPrice;
    }

    public int getYear() {
        return this.year;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void displayCarInfo() {
        String var10001 = this.make;
        System.out.println("Make: " + var10001);
        var10001 = this.model;
        System.out.println("Model: " + var10001);
        int var1 = this.year;
        System.out.println("Year: " + var1);
        double var2 = this.rentalPrice;
        System.out.println("Rental Price: " + var2);
        System.out.println("Availability: " + (this.availability ? "Available" : "Not Available"));
    }
}
