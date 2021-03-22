package main.domainModel;

import main.util.Validator;

public class Person {

    private String name;
    private int age;
    private boolean isMale;

    public Person(String name, int age, boolean isMale) {
        if (Validator.validatorCheck(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Not valid name input!");
        }
        if (Validator.isValidNumber(1, 99, age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Not valid age input!");
        }
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}
