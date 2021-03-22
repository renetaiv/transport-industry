package main.domainModel.ships;

import main.ColorType;
import main.domainModel.Vehicle;
import main.util.Validator;

public class SailingShip extends Vehicle {

    public enum SailingShipModelType {
        ROYAL_CLIPPER_ITINERARY, SANTA_MARIA, FLYING_CLOUD
    }

    private final int numberOfMasts;

    public SailingShip(SailingShipModelType name, ColorType color, int numberOfMasts) {
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
