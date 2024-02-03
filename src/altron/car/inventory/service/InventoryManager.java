package altron.car.inventory.service;

import altron.car.inventory.domain.Car;
import altron.car.inventory.domain.ElectricCar;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManager {
    private final List<Car> cars;

    public InventoryManager(List<Car> cars) {
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
        cars.stream().forEach(System.out::println);
    }

    public List<Car> searchCars(String make) {
        return cars.stream()
                .filter(car -> car.displayInfo().contains(make))
                .collect(Collectors.toList());
    }

    public void sortCarsBy(String property) {
        try {
            if ("year".equals(property)) {
                Collections.sort(cars, Comparator.comparingInt(Car::getYear));
            }

            if ("model".equals(property)) {
                Collections.sort(cars, Comparator.comparing(Car::getModel));
            }

            if ("make".equals(property)) {
                Collections.sort(cars, Comparator.comparing(Car::getMake));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
