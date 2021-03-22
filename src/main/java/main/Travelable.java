package main;

import java.util.Set;

public interface Travelable {

    default void addPassenger(Person person, Set<Person> passengers, int maxCapacity){
        if (passengers.size() < maxCapacity) {
            passengers.add(person);
        }
    }

    default void showPassengers(Set<Person> passengers) {
        for (Person passenger : passengers) {
            System.out.println(passenger);
        }
    }
}
