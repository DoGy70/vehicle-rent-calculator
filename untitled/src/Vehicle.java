public abstract class Vehicle {
    private String brand;
    private String model;
    private double value;
    private final double insurancePercentage;
    private double rental;
    private final VehicleType vehicleType;

    public Vehicle(String brand, String model, double value, double insurancePercentage, double rental, VehicleType vehicleType) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.insurancePercentage = insurancePercentage;
        this.rental = rental;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getRental() {
        return rental;
    }

    public void setRental(double rental) {
        this.rental = rental;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getValue() {
        return value;
    }

    public double getInsurancePercentage() {
        return insurancePercentage;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", value=" + value +
                ", insurancePercentage=" + insurancePercentage +
                ", rental=" + rental +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
