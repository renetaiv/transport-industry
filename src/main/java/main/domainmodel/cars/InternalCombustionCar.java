package main.domainmodel.cars;

import main.ColorType;
import main.domainmodel.Vehicle;

public class InternalCombustionCar extends Vehicle {

    public enum InternalCombustionCarModelType {
        MAZDA_6, NISSAN_MICRA_1500, BMW_318, SCODA_OCTAVIA_DSG
    }

    public enum EngineType {
        DIESEL, BENZINE
    }

    private final EngineType engine;

    public InternalCombustionCar(InternalCombustionCarModelType name, ColorType color, EngineType engine) {
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
    public int getVehiclePricePerHour() {
        return 5;
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