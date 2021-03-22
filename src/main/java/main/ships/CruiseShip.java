package main.ships;

import main.ColorType;
import main.Person;
import main.Vehicle;
import main.util.Validator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CruiseShip extends Vehicle {

    public enum ModelType {
        ADVENTURE_OF_THE_SEAS, ALLURE_OF_THE_SEAS, AMSTERDAM, CARIBBEAN_PRINCESS
    }

    private Set<Person> passengers;
    private int maxCapacity;

    public CruiseShip(ModelType name, ColorType color, int maxCapacity) {
        super(String.valueOf(name), color);
        this.passengers = new TreeSet<>(Comparator.comparing(Person::getName));
        if (Validator.isValidNumber(1, 7000, maxCapacity)) {
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Too large number of max capacity!");
        }
    }

    public void addPassenger(Person person) {
        if (this.passengers.size() < maxCapacity) {
            this.passengers.add(person);
        }
    }

    public void showPassengers() {
        for (Person passenger : this.passengers) {
            System.out.println(passenger);
        }
    }

    @Override
    protected String vehicleKind() {
        return MARINE;
    }

    @Override
    public String toString() {
        return "CruiseShip{" +
                "name='" + super.getName() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", passengers=" + passengers + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
