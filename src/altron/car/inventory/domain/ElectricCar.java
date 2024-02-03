package altron.car.inventory.domain;

// Subclass extending altron.car.inventory.domain.Car
public class ElectricCar extends Car {
    private int batteryLife;

    public ElectricCar(String make, String model, int year, int batteryLife) {
        super(make, model, year);
        this.batteryLife = batteryLife;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Battery Life: " + batteryLife + " kWh";
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }
}
