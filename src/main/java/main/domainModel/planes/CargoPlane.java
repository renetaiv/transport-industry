package main.domainModel.planes;

import main.ColorType;
import main.domainModel.Vehicle;
import main.util.Validator;

public class CargoPlane extends Vehicle {

    public enum CargoPlaneModelType {
        ANTONOV_AN_225_MRIYA, BOEING_747_DREAMLIFTER, AERO_SPACELINES_SUPER_GUPPY
    }

    private final int maxCargoWeight; // in tons

    public CargoPlane(CargoPlaneModelType name, ColorType color, int maxCargoWeight) {
        super(String.valueOf(name), color);
        if (Validator.isValidNumber(1, 250, maxCargoWeight)) {
            this.maxCargoWeight = maxCargoWeight;
        } else {
            throw new IllegalArgumentException("Not valid number of max cargo weight!");
        }
    }

    @Override
    public String vehicleKind() {
        return AIRILY;
    }

    @Override
    public String toString() {
        return "CargoPlane{" +
                "name='" + super.getName() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", maxCargoWeight=" + maxCargoWeight +
                '}';
    }
}
