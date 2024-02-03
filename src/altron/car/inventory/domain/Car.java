package altron.car.inventory.domain;

import java.util.Objects;

// Car class
public class Car implements Comparable<Car> {
    // Encapsulation :All the properties are private and accessors and mutator methods provided.
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    //No argument constructor to be called by frameworks/3rd party libraries
    public Car() {
    }

    //This is the equivalent of the toString method defined below
    public String displayInfo() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.year, o.year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year && Objects.equals(make, car.make) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year);
    }
}
