package main;

import main.domainModel.Person;

import java.util.Set;

public interface Travelable {

    default boolean addPassenger(Person person, Set<Person> passengers, int maxCapacity){
        if (passengers.size() < maxCapacity) {
            passengers.add(person);
            return true;
        } else {
            return false;
        }
    }

    default void showPassengers(Set<Person> passengers) {
        for (Person passenger : passengers) {
            System.out.println(passenger);
        }
    }
}
