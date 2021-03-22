package main.domainModel.planes;

import main.ColorType;
import main.domainModel.Person;
import main.Travelable;
import main.domainModel.Vehicle;
import main.util.Validator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Airliner extends Vehicle implements Travelable {

    public enum ModelType {
        AMERICAN_AIRLINES_B727_200, EMBRAER_LINEAGE_1000E, AIRBUS_A310_LUFTHANSA
    }

    private Set<Person> passengers;
    private final int maxCapacity;

    public Airliner(ModelType name, ColorType color, int maxCapacity) {
        super(String.valueOf(name), color);
        this.passengers = new TreeSet<>(Comparator.comparing(Person::getName));
        if (Validator.isValidNumber(1, 800, maxCapacity)) {
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Too large number of max capacity!");
        }
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Set<Person> getPassengers() {
        return passengers;
    }

    @Override
    public String vehicleKind() {
        return AIRILY;
    }

    @Override
    public String toString() {
        return "Airliner{" +
                "name='" + super.getName() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", passengers=" + passengers + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
