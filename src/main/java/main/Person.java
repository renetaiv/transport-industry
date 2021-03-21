package main;

import main.util.Validator;

public class Person {

    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        if (Validator.isValidText(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Not valid name input!");
        }
        if (Validator.isValidNumber(1, 99, age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Not valid age input!");
        }
        if (gender == 'M' || gender == 'm' || gender == 'F' || gender == 'f') {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Not valid gender input!");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
