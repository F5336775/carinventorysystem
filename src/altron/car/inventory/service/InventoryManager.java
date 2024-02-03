package altron.car.inventory.service;

import altron.car.inventory.domain.Car;
import altron.car.inventory.domain.ElectricCar;
import altron.car.inventory.exception.DisplayCarsException;
import altron.car.inventory.exception.SearchCarStrategyException;
import altron.car.inventory.exception.SortingStrategyException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManager {
    private final List<Car> cars;

    public InventoryManager(List<Car> cars) {
        this.cars = cars;
    }

    public synchronized void addCar(String make, String model, int year, Integer batteryLife) {
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
    public synchronized void addCar(Car car) {
        cars.add(car);
    }

    //Function to delete car from list

    public void showCars() {
        try {
            cars.stream().forEach(System.out::println);
        } catch (Exception e) {
            throw new DisplayCarsException("Exception thrown while displaying the list of cars: " + e);
        }
    }

    public List<Car> searchCars(String make) {
        try {
            return cars.stream()
                    .filter(car -> car.displayInfo().contains(make))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new SearchCarStrategyException("Exception thrown while searching the list of cars by: " + make + " : " + e);
        }
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
            throw new SortingStrategyException("Exception thrown while sorting the list of cars by: " + property + " : " + e);
        }
    }


}
