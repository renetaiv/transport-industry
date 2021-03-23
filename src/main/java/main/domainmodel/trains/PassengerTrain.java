package main.domainmodel.trains;

import main.ColorType;
import main.domainmodel.Person;
import main.Travelable;
import main.domainmodel.Vehicle;
import main.util.Validator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PassengerTrain extends Vehicle implements Travelable {

    public enum PassengerTrainModelType {
        INDIAN_PACIFIC, EASTERN_ORIENTAL_EXPRESS
    }

    private Set<Person> passengers;
    private final int maxCapacity;

    public PassengerTrain(PassengerTrainModelType name, ColorType color, int maxCapacity) {
        super(String.valueOf(name), color);
        this.passengers = new TreeSet<>(Comparator.comparing(Person::getName));
        if (Validator.isValidNumber(1, 500, maxCapacity)) {
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