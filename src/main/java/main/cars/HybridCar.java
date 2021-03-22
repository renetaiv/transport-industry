package main.cars;

import main.ColorType;
import main.Vehicle;

public class HybridCar extends Vehicle {

    public enum ModelType {
        LEXUS_ES_300H, TOYOTA_RAV4, HONDA_NSX, LEXUS_RX_450H_L, HONDA_JAZZ
    }

    public enum EngineType {
        FULL_HYBRID, LIGHT_HYBRID
    }

    private final EngineType engine;

    public HybridCar(ModelType name, ColorType color, EngineType engine) {
        super(String.valueOf(name), color);
        this.engine = engine;
    }

    public void displayEnvironmentalFriendliness() {
        if (this.engine.equals(EngineType.FULL_HYBRID)) {
            System.out.println("The level of environmental friendliness about " + getName() + " is very high.");
        } else {
            System.out.println("The level of environmental friendliness about " + getName() + " is medium.");
        }
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
