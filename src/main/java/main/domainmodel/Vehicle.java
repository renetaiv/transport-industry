package main.domainmodel;

import main.ColorType;
import main.util.Validator;

abstract public class Vehicle {

    public static final String MARINE = "Marine";
    public static final String OVERLAND = "Overland";
    public static final String RAILWAY = "Railway";
    public static final String AIRILY = "Airily";

    private String name;
    private ColorType color;

    public Vehicle(String name, ColorType color) {
        if (Validator.validatorCheck(name)) {
            this.name = name;
        }
        this.color = color;
    }

    protected abstract String vehicleKind();

    public abstract int getVehiclePricePerHour();

    public abstract int getVehicleMaxParkingCells();

    public void displayVehicleKind() {
        System.out.println(this.name + ": " + vehicleKind());
    }

    public String getName() {
        return name;
    }

    public ColorType getColor() {
        return color;
    }


}
