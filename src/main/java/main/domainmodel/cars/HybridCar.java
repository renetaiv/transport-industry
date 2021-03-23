package main.domainmodel.cars;

import main.ColorType;
import main.domainmodel.Vehicle;

public class HybridCar extends Vehicle {

    public enum HybridCarModelType {
        LEXUS_ES_300H, TOYOTA_RAV4, HONDA_NSX, LEXUS_RX_450H_L, HONDA_JAZZ
    }

    public enum EngineType {
        FULL_HYBRID, LIGHT_HYBRID
    }

    private final EngineType engine;

    public HybridCar(HybridCarModelType name, ColorType color, EngineType engine) {
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
    public int getVehiclePricePerHour() {
        return 5;
    }

    @Override
    public int getVehicleMaxParkingCells() {
        return 200;
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
