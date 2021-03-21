package main.ships;

import main.ColorType;
import main.Vehicle;
import main.util.Validator;

public class SailingShip extends Vehicle {

    public enum ModelType {
        ROYAL_CLIPPER_ITINERARY, SANTA_MARIA, FLYING_CLOUD
    }

    private int numberOfMasts;

    public SailingShip(ModelType name, ColorType color, int numberOfMasts) {
        super(String.valueOf(name), color);
        if (Validator.isValidNumber(1, 5, numberOfMasts)) {
            this.numberOfMasts = numberOfMasts;
        } else {
            throw new IllegalArgumentException("Not valid number of masts!");
        }
    }

    @Override
    protected String vehicleKind() {
        return MARINE;
    }

    @Override
    public String toString() {
        return "SailingShip{" +
                "name='" + super.getName() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", numberOfMasts=" + numberOfMasts +
                '}';
    }
}
