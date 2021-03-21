package main.cars;

import main.ColorType;
import main.Vehicle;

public class InternalCombustionCar extends Vehicle {

    public enum ModelType {
        MAZDA_6, NISSAN_MICRA_1500, BMW_318, SCODA_OCTAVIA_DSG
    }

    public enum EngineType {
        DIESEL, BENZINE
    }

    private EngineType engine;

    public InternalCombustionCar(ModelType name, ColorType color, EngineType engine) {
        super(String.valueOf(name), color);
        this.engine = engine;
    }

    public void displayEnvironmentalFriendliness() {
        System.out.println("The level of environmental friendliness about " + getName() + " is very low.");
    }

    @Override
    public String vehicleKind() {
        return OVERLAND;
    }

    @Override
    public String toString() {
        return "InternalCombustionCar{" +
                "name='" + super.getName() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}