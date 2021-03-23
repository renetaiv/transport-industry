package main;

import main.domainmodel.Person;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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

    default void showSortedPassengersByAge(Set<Person> passengers) {
        Set<Person> sortedByAge = new TreeSet<>(Comparator.comparingInt(Person::getAge));
        sortedByAge.addAll(passengers);
        for (Person person : sortedByAge) {
            System.out.println(person);
        }
    }
}
