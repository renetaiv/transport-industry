package main.trains;

import main.ColorType;
import main.Person;
import main.Vehicle;
import main.util.Validator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PassengerTrain extends Vehicle {

    public enum ModelType {
        INDIAN_PACIFIC, EASTERN_ORIENTAL_EXPRESS
    }

    private Set<Person> passengers;
    private int maxCapacity;

    public PassengerTrain(ModelType name, ColorType color, int maxCapacity) {
        super(String.valueOf(name), color);
        this.passengers = new TreeSet<>(Comparator.comparing(Person::getName));
        if (Validator.isValidNumber(1, 500, maxCapacity)) {
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Too large number of max capacity!");
        }
    }

    @Override
    public String vehicleKind() {
        return RAILWAY;
    }

    @Override
    public String toString() {
        return "PassengerTrain{" +
                "name='" + super.getName() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", passengers=" + passengers + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}