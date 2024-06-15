public class Motorcycle extends Vehicle{
    private int driverAge;
    public Motorcycle(String brand, String model, double value, int driverAge) {
        super(brand, model, value, 0.0002, 15, VehicleType.MOTORCYCLE);
        this.driverAge = driverAge;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }
}
