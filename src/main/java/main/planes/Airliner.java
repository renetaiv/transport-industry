package main.planes;

import main.ColorType;
import main.Person;
import main.Vehicle;
import main.util.Validator;

import java.util.Set;
import java.util.TreeSet;

public class Airliner extends Vehicle {

    public enum ModelType {
        AMERICAN_AIRLINES_B727_200, EMBRAER_LINEAGE_1000E, AIRBUS_A310_LUFTHANSA
    }

    private Set<Person> passengers;
    private int maxCapacity;

    public Airliner(ModelType name, ColorType color, int maxCapacity) {
        super(String.valueOf(name), color);
        this.passengers = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));
        if (Validator.isValidNumber(1, 800, maxCapacity)) {
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
        this.passengers.stream().forEach(person -> System.out.println(person));
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
