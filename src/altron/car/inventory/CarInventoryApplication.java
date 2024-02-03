package altron.car.inventory;

import altron.car.inventory.domain.Car;
import altron.car.inventory.service.InventoryManager;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarInventoryApplication {

    public static void main(String[] args) {

        InventoryManager inventoryManager = new InventoryManager(new CopyOnWriteArrayList<>());
        // Example usage
        inventoryManager.addCar("Toyota", "Corolla", 2020, null);
        inventoryManager.addCar("Tesla", "Model S", 2022, 24);
        inventoryManager.addCar("Ford", "Mustang", 2021, null);
        inventoryManager.addCar("BMW", "M3", 2021, null);
        inventoryManager.addCar("BMW", "i8", 2021, 50);
        inventoryManager.addCar(new Car("Auid","A3",2020));

        // Testing the functions
        System.out.println(inventoryManager.searchCars("BMW"));
        inventoryManager.sortCarsBy("year");
        inventoryManager.showCars();
    }
}
