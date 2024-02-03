package altron.car.inventory.service;

import altron.car.inventory.domain.Car;
import altron.car.inventory.domain.ElectricCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarInventorySystem {
    private final List<Car> cars;

    public CarInventorySystem(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(String make, String model, int year, Integer batteryLife) {
        Car car;
        if (batteryLife == null) {
            car = new Car(make, model, year);
        } else {
            car = new ElectricCar(make, model, year, batteryLife);
        }
        cars.add(car);
    }

    //Generic method for adding ALL types of cars
    //This leaves the validation at the model creation level
    //Ensuring we don't modify the validation logic each time we add a different type of car
    public void addCar(Car car) {
        cars.add(car);
    }

    public void showCars() {
        for (Car car : cars) {
            System.out.println(car.displayInfo());
        }
    }

    public List<Car> searchCars(String make) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.displayInfo().contains(make)) {
                result.add(car);
            }
        }
        return result;
    }

    public void sortCarsBy(String property) {
        if ("year".equals(property)) {
            Collections.sort(cars, Comparator.comparingInt(Car::getYear));
        }
    }

    public static void main(String[] args) {

        CarInventorySystem carInventorySystem = new CarInventorySystem(new ArrayList<>());
        // Example usage
        carInventorySystem.addCar("Toyota", "Corolla", 2020, null);
        carInventorySystem.addCar("Tesla", "Model S", 2022, 24);
        carInventorySystem.addCar("Ford", "Mustang", 2021, null);
        carInventorySystem.addCar("BMW", "M3", 2021, null);
        carInventorySystem.addCar("BMW", "i8", 2021, 50);
        carInventorySystem.addCar(new Car("Auid","A3",2020));

        // Testing the functions
        System.out.println(carInventorySystem.searchCars("Tesla"));
        carInventorySystem.sortCarsBy("year");
        carInventorySystem.showCars();
    }
}
