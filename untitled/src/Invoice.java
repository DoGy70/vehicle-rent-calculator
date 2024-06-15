import java.time.LocalDate;

public class Invoice {
    private final String name;
    private final String rentedVehicle;
    private final LocalDate reservationActualReturnDate;
    private final LocalDate reservationStartDate;
    private final LocalDate reservationEndDate;
    private final int reservedRentalDays;
    private final int actualRentedDays;
    private final double rentalCostPerDay;
    private final double initialInsurancePerDay;
    private final double insuranceAdditionPerDay;
    private final double insuranceDiscountPerDay;
    private final double insurancePerDay;
    private final double earlyDiscountForRent;
    private final double earlyDiscountForInsurance;
    private final double totalRent;
    private final double totalInsurance;
    private final double total;


    public Invoice(String name, String rentedVehicle, LocalDate reservationActualReturnDate, LocalDate reservationStartDate, LocalDate reservationEndDate, int reservedRentalDays, int actualRentedDays, double rentalCostPerDay, double initialInsurancePerDay, double insuranceAdditionPerDay, double insuranceDiscountPerDay, double insurancePerDay, double earlyDiscountForRent, double earlyDiscountForInsurance, double totalRent, double totalInsurance, double total) {
        this.name = name;
        this.rentedVehicle = rentedVehicle;
        this.reservationActualReturnDate = reservationActualReturnDate;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservedRentalDays = reservedRentalDays;
        this.actualRentedDays = actualRentedDays;
        this.rentalCostPerDay = rentalCostPerDay;
        this.initialInsurancePerDay = initialInsurancePerDay;
        this.insuranceAdditionPerDay = insuranceAdditionPerDay;
        this.insuranceDiscountPerDay = insuranceDiscountPerDay;
        this.insurancePerDay = insurancePerDay;
        this.earlyDiscountForRent = earlyDiscountForRent;
        this.earlyDiscountForInsurance = earlyDiscountForInsurance;
        this.totalRent = totalRent;
        this.totalInsurance = totalInsurance;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public String getRentedVehicle() {
        return rentedVehicle;
    }

    public LocalDate getReservationActualReturnDate() {
        return reservationActualReturnDate;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public int getReservedRentalDays() {
        return reservedRentalDays;
    }

    public int getActualRentedDays() {
        return actualRentedDays;
    }

    public double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public double getInitialInsurancePerDay() {
        return initialInsurancePerDay;
    }

    public double getInsuranceAdditionPerDay() {
        return insuranceAdditionPerDay;
    }

    public double getInsuranceDiscountPerDay() {
        return insuranceDiscountPerDay;
    }

    public double getInsurancePerDay() {
        return insurancePerDay;
    }

    public double getEarlyDiscountForRent() {
        return earlyDiscountForRent;
    }

    public double getEarlyDiscountForInsurance() {
        return earlyDiscountForInsurance;
    }

    public double getTotalRent() {
        return totalRent;
    }

    public double getTotalInsurance() {
        return totalInsurance;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {

        String formattedRentalCostPerDay = String.format("%.02f", getRentalCostPerDay());
        String formattedInitialInsurancePerDay = String.format("%.02f", getInitialInsurancePerDay());
        String formattedAdditionalInsurancePerDay = String.format("%.02f", getInsuranceAdditionPerDay());
        String formattedInsuranceDiscountPerDay = String.format("%.02f", getInsuranceDiscountPerDay());
        String formattedInsurancePerDay = String.format("%.02f", getInsurancePerDay());
        String formattedEarlyDiscountForRent = String.format("%.02f", getEarlyDiscountForRent());
        String formattedEarlyDiscountForInsurance = String.format("%.02f", getEarlyDiscountForInsurance());
        String formattedTotalRent = String.format("%.02f", getTotalRent());
        String formattedTotalInsurance = String.format("%.02f", getTotalInsurance());
        String formattedTotal = String.format("%.02f", getTotal());

      return "XXXXXXXXXX" +
              "\nDate: " + getReservationActualReturnDate() +
              "\nCustomer Name: " + getName() +
              "\nRented Vehicle: " + getRentedVehicle() +

              "\n\nReservation start date: " + getReservationStartDate() +
              "\nReservation end date: " + getReservationEndDate() +
              "\nReserved rental days: " + getReservedRentalDays() + " days" +

              "\n\nActual return date: " + getReservationActualReturnDate() +
              "\nActual rental days: " + getActualRentedDays() + " days" +

              "\n\nRental cost per day: " + "$" + formattedRentalCostPerDay +
              (getInsuranceDiscountPerDay() != 0 ? "\nInitial insurance per day: $" + formattedInitialInsurancePerDay : getInsuranceAdditionPerDay() != 0 ? "\nInitial insurance per day: $" + formattedInitialInsurancePerDay : "") +
              (getInsuranceAdditionPerDay() != 0 ? "\nAdditional insurance per day: $" + formattedAdditionalInsurancePerDay : "") +
              (getInsuranceDiscountPerDay() != 0 ? "\nInsurance discount per day: $" + formattedInsuranceDiscountPerDay : "") +
              "\nInsurance per day: $" + formattedInsurancePerDay +

              (getEarlyDiscountForRent() != 0 ? "\n\nEarly discount for rent: $" + formattedEarlyDiscountForRent : "") +
              (getEarlyDiscountForInsurance() != 0 ? "\nEarly discount for insurance: $" + formattedEarlyDiscountForInsurance : "") +

              "\n\nTotal rent: $" + formattedTotalRent +
              "\nTotal insurance: $" + formattedTotalInsurance +
              "\nTotal: $" + formattedTotal +
              "\nXXXXXXXXXX";
    }
}
