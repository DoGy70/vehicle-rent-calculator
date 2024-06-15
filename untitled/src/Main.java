import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();
        Pattern ratingPattern = Pattern.compile("[1-5]");

        System.out.println("Welcome to our vehicle rental system!");


        System.out.println("Enter your first name: ");
        String firstName = in.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = in.nextLine();

        System.out.println("Enter your vehicle's type (car | motorcycle | cargo van)");
        String vehicleType = in.nextLine();

        while (!vehicleType.equalsIgnoreCase("car") && !vehicleType.equalsIgnoreCase("motorcycle") && !vehicleType.equalsIgnoreCase("cargo van")) {
            System.out.println("Please enter a valid vehicle type (car | motorcycle | cargo van)");
            vehicleType = in.nextLine();
        }

        System.out.println("Enter your vehicle's brand: ");
        String vehicleBrand = in.nextLine();

        System.out.println("Enter your vehicle's model: ");
        String vehicleModel = in.nextLine();

        System.out.println("Enter your vehicle's price: ");
        double vehiclePrice = Double.parseDouble(in.nextLine());


        System.out.println("Enter year of rental: ");
        int yearStartRental = Integer.parseInt(in.nextLine());

        System.out.println("Enter month of rental: ");
        int monthStartRental = Integer.parseInt(in.nextLine());

        System.out.println("Enter day of rental: ");
        int dayStartRental = Integer.parseInt(in.nextLine());


        System.out.println("Enter year of expected return: ");
        int yearExpectedReturn = Integer.parseInt(in.nextLine());

        System.out.println("Enter month of expected return: ");
        int monthExpectedReturn = Integer.parseInt(in.nextLine());

        System.out.println("Enter day of expected return: ");
        int dayExpectedReturn = Integer.parseInt(in.nextLine());

        LocalDate startRentalDate = LocalDate.of(yearStartRental, monthStartRental, dayStartRental);
        LocalDate returnDate = LocalDate.of(yearExpectedReturn, monthExpectedReturn, dayExpectedReturn);


        while (startRentalDate.until(returnDate, ChronoUnit.DAYS) < 0 || startRentalDate.until(currentDate, ChronoUnit.DAYS) < 0) {
            System.out.println("Please, make sure that the date of RETURN is AFTER the day of RENT.");

            System.out.println("Enter year of rental: ");
            yearStartRental = Integer.parseInt(in.nextLine());

            System.out.println("Enter month of rental: ");
            monthStartRental = Integer.parseInt(in.nextLine());

            System.out.println("Enter day of rental: ");
            dayStartRental = Integer.parseInt(in.nextLine());


            System.out.println("Enter year of expected return: ");
            yearExpectedReturn = Integer.parseInt(in.nextLine());

            System.out.println("Enter month of expected return: ");
            monthExpectedReturn = Integer.parseInt(in.nextLine());

            System.out.println("Enter day of expected return: ");
            dayExpectedReturn = Integer.parseInt(in.nextLine());

            startRentalDate = LocalDate.of(yearStartRental, monthStartRental, dayStartRental);
            returnDate = LocalDate.of(yearExpectedReturn, monthExpectedReturn, dayExpectedReturn);
        }

        long expectedRentDays = startRentalDate.until(returnDate, ChronoUnit.DAYS);
        long actualRentDays = startRentalDate.until(currentDate, ChronoUnit.DAYS);

        vehicleType = vehicleType.toLowerCase();
        Vehicle vehicle = null;

        switch (vehicleType){
            case ("car"):
                System.out.println("Enter safety rating (1-5): ");
                String vehicleRating = in.nextLine();
                while (!ratingPattern.matcher(vehicleRating).matches()) {
                    System.out.println("Please enter a valid rating (1-5): ");
                    vehicleRating = in.nextLine();
                }
                vehicle = new Car(vehicleBrand, vehicleModel, vehiclePrice, vehicleRating);

                break;

            case ("motorcycle"):
                System.out.println("Please enter your age: ");
                int driverAge = Integer.parseInt(in.nextLine());
                vehicle = new Motorcycle(vehicleBrand, vehicleModel, vehiclePrice, driverAge);
                break;

            case ("cargo van"):
                System.out.println("Please enter your driving experience in years: ");
                int driverExperience = Integer.parseInt(in.nextLine());
                vehicle = new CargoVan(vehicleBrand, vehicleModel, vehiclePrice, driverExperience);
                break;
        }

        if (vehicle == null) {
            System.out.println("Something went wrong");
            return;
        }

        if (startRentalDate.until(returnDate, ChronoUnit.DAYS) >= 7) {
            switch (vehicle.getVehicleType()) {
                case CAR -> vehicle.setRental(15);

                case MOTORCYCLE -> vehicle.setRental(10);

                case CARGOVAN -> vehicle.setRental(40);
            }
        }

        double initialInsurancePerDay = vehicle.getValue() * vehicle.getInsurancePercentage();
        double insuranceDiscountPerDay = 0;
        double insuranceAdditionPerDay = 0;

        switch (vehicle.getVehicleType()) {
            case CAR -> {
                Car car = (Car) vehicle;
                String carRating = car.getRating();

                if(carRating.equalsIgnoreCase("4") || carRating.equalsIgnoreCase("5")) {
                    insuranceDiscountPerDay = initialInsurancePerDay - initialInsurancePerDay * 0.1;
                }
            }

            case MOTORCYCLE -> {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                int driverAge = motorcycle.getDriverAge();

                if (driverAge < 25) {
                    insuranceAdditionPerDay = initialInsurancePerDay * 0.2;
                }
            }

            case CARGOVAN -> {
                CargoVan cargoVan = (CargoVan) vehicle;
                int driverExperience = cargoVan.getDriverExperience();

                if (driverExperience > 5) {
                    insuranceDiscountPerDay = initialInsurancePerDay * 0.15;
                }
            }
        }

        double totalInsurancePerDay = initialInsurancePerDay - insuranceDiscountPerDay + insuranceAdditionPerDay;
        double totalInsurance = totalInsurancePerDay * actualRentDays;
        double earlyReturnInsurance = ((initialInsurancePerDay - insuranceDiscountPerDay + insuranceAdditionPerDay) * expectedRentDays) - totalInsurance;

        double totalRent = (vehicle.getRental() * actualRentDays) + ((vehicle.getRental() / 2) * (expectedRentDays - actualRentDays));
        double earlyReturnRent = (vehicle.getRental() * expectedRentDays) - totalRent;

        double total = totalInsurance + totalRent;

        String name = firstName + " " + lastName;
        String rentedVehicle = vehicle.getBrand() + " " + vehicle.getModel();
        Invoice invoice = new Invoice(name, rentedVehicle, currentDate, startRentalDate, returnDate, (int) expectedRentDays, (int) actualRentDays, vehicle.getRental(), initialInsurancePerDay, insuranceAdditionPerDay, insuranceDiscountPerDay, totalInsurancePerDay, earlyReturnRent, earlyReturnInsurance, totalRent, totalInsurance, total);
        System.out.println(invoice);

    }
}