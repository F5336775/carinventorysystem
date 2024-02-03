package altron.car.inventory.service;

import altron.car.inventory.domain.Car;
import altron.car.inventory.domain.ElectricCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarInventorySystem {
    private static List<Car> cars = new ArrayList<>();

    public static void addCar(String make, String model, int year, Integer batteryLife) {
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
    public static void addCar(Car car) {
        cars.add(car);
    }

    public static void showCars() {
        for (Car car : cars) {
            System.out.println(car.displayInfo());
        }
    }

    public static List<Car> searchCars(String make) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.displayInfo().contains(make)) {
                result.add(car);
            }
        }
        return result;
    }

    public static void sortCarsBy(String property) {
        if ("year".equals(property)) {
            Collections.sort(cars, Comparator.comparingInt(Car::getYear));
        }
    }

    public static void main(String[] args) {
        // Example usage
        addCar("Toyota", "Corolla", 2020, null);
        addCar("Tesla", "Model S", 2022, 24);
        addCar("Ford", "Mustang", 2021, null);
        addCar("BMW", "M3", 2021, null);
        addCar("BMW", "i8", 2021, 50);
        addCar(new Car("Auid","A3",2020));

        // Testing the functions
        System.out.println(searchCars("Tesla"));
        sortCarsBy("year");
        showCars();
    }
}
