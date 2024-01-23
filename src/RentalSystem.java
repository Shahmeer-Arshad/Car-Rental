import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class RentalSystem {
    private List<Car> carList = new ArrayList();
    private List<Rental> rentalList = new ArrayList();
    private List<Customer> customerList = new ArrayList();

    public RentalSystem() {
        this.initializeCarList();
    }

    private void initializeCarList() {
        this.carList.add(new Car("Toyota", "Corolla", true, 50.0, 2020));
        this.carList.add(new Car("Honda", "Civic", true, 60.0, 2021));
        this.carList.add(new Car("Ford", "Mustang", true, 70.0, 2021));
        this.carList.add(new Car("Chevrolet", "Cruze", true, 55.0, 2022));
        this.carList.add(new Car("BMW", "X5", true, 90.0, 2020));
        this.carList.add(new Car("Mercedes-Benz", "E-Class", true, 85.0, 2022));
        this.carList.add(new Car("Audi", "A4", true, 75.0, 2021));
        this.carList.add(new Car("Lexus", "RX 350", true, 80.0, 2021));
        this.carList.add(new Car("Volkswagen", "Golf", true, 60.0, 2022));
        this.carList.add(new Car("Subaru", "Outback", true, 65.0, 2021));
        this.carList.add(new Car("Hyundai", "Elantra", true, 50.0, 2022));
        this.carList.add(new Car("Kia", "Sorento", true, 70.0, 2021));
        this.carList.add(new Car("Nissan", "Altima", true, 55.0, 2020));
        this.carList.add(new Car("Mazda", "CX-5", true, 65.0, 2022));
        this.carList.add(new Car("Jeep", "Wrangler", true, 75.0, 2021));
        this.carList.add(new Car("GMC", "Terrain", true, 60.0, 2021));
        this.carList.add(new Car("Ram", "1500", true, 80.0, 2020));
        this.carList.add(new Car("Chrysler", "Pacifica", true, 70.0, 2022));
        this.carList.add(new Car("Land Rover", "Range Rover", true, 120.0, 2021));
        this.carList.add(new Car("Tesla", "Model S", true, 150.0, 2022));
    }

    public void addCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the make: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the rental price: ");
        double rentalPrice = scanner.nextDouble();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        Car car = new Car(make, model, true, rentalPrice, year);
        this.carList.add(car);
        System.out.println("Car added successfully!");
    }

    public void removeCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the make of the car to remove: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the car to remove: ");
        String model = scanner.nextLine();
        Car carToRemove = null;
        Iterator var5 = this.carList.iterator();

        while(var5.hasNext()) {
            Car car = (Car)var5.next();
            if (car.getMake().equals(make) && car.getModel().equals(model)) {
                carToRemove = car;
                break;
            }
        }

        if (carToRemove != null) {
            this.carList.remove(carToRemove);
            System.out.println("Car removed successfully!");
        } else {
            System.out.println("Car not found!");
        }

    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the customer contact information: ");
        String contactInfo = scanner.nextLine();
        Customer customer = new Customer(name, contactInfo);
        this.customerList.add(customer);
        System.out.println("Customer added successfully!");
    }

    public void rentCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the customer contact information: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter the make of the car to rent: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the car to rent: ");
        String model = scanner.nextLine();
        System.out.print("Enter the rental duration (in days): ");
        int rentalDuration = scanner.nextInt();
        Car rentedCar = null;
        Iterator var8 = this.carList.iterator();

        while(var8.hasNext()) {
            Car car = (Car)var8.next();
            if (car.getMake().equals(make) && car.getModel().equals(model) && car.isAvailable()) {
                rentedCar = car;
                break;
            }
        }

        if (rentedCar != null) {
            rentedCar.setAvailability(false);
            Customer customer = new Customer(name, contactInfo);
            Rental rental = new Rental(rentalDuration, rentedCar, customer);
            this.rentalList.add(rental);
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car not found or not available for rent!");
        }

    }

    public void returnCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the make of the car to return: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model of the car to return: ");
        String model = scanner.nextLine();
        Rental rentalToReturn = null;
        Iterator var5 = this.rentalList.iterator();

        while(var5.hasNext()) {
            Rental rental = (Rental)var5.next();
            if (rental.getRentedCar().getMake().equals(make) && rental.getRentedCar().getModel().equals(model)) {
                rentalToReturn = rental;
                break;
            }
        }

        if (rentalToReturn != null) {
            this.rentalList.remove(rentalToReturn);
            rentalToReturn.getRentedCar().setAvailability(true);
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("Rental record not found!");
        }

    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        Iterator var1 = this.carList.iterator();

        while(var1.hasNext()) {
            Car car = (Car)var1.next();
            if (car.isAvailable()) {
                car.displayCarInfo();
                System.out.println();
            }
        }

    }

    public void displayRentedCars() {
        System.out.println("Rented Cars:");
        Iterator var1 = this.rentalList.iterator();

        while(var1.hasNext()) {
            Rental rental = (Rental)var1.next();
            rental.displayRentalInfo();
            System.out.println();
        }

    }
}
