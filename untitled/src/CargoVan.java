public class CargoVan extends Vehicle{
    private int driverExperience;
    public CargoVan(String brand, String model, double value, int driverExperience) {
        super(brand, model, value, 0.0003, 50, VehicleType.CARGOVAN);
        this.driverExperience = driverExperience;
    }

    public int getDriverExperience() {
        return driverExperience;
    }

    public void setDriverExperience(int driverExperience) {
        this.driverExperience = driverExperience;
    }
}
