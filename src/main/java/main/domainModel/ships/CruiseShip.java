package main.domainModel.ships;

import main.ColorType;
import main.domainModel.Person;
import main.Travelable;
import main.domainModel.Vehicle;
import main.util.Validator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CruiseShip extends Vehicle implements Travelable {

    public enum ModelType {
        ADVENTURE_OF_THE_SEAS, ALLURE_OF_THE_SEAS, AMSTERDAM, CARIBBEAN_PRINCESS
    }

    private Set<Person> passengers;
    private final int maxCapacity;

    public CruiseShip(ModelType name, ColorType color, int maxCapacity) {
        super(String.valueOf(name), color);
        this.passengers = new TreeSet<>(Comparator.comparing(Person::getName));
        if (Validator.isValidNumber(1, 7000, maxCapacity)) {
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Too large number of max capacity!");
        }
    }

    public Set<Person> getPassengers() {
        return passengers;
    }

    public int getMaxCapacity() {
        return maxCapacity;
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
