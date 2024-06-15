public class Car extends Vehicle{
    private String rating;


    public Car(String brand, String model, double value, String rating) {
        super(brand, model, value, 0.0001, 20, VehicleType.CAR);
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
