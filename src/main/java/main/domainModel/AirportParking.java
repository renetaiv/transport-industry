package main.domainModel;

import main.domainModel.cars.HybridCar;
import main.domainModel.ships.CruiseShip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AirportParking {

    private final static int PRICE_PER_HOUR_FOR_CAR = 5;
    private final static int PRICE_PER_HOUR_FOR_PLANE = 19;
    private final static int PRICE_PER_HOUR_FOR_TRAIN = 12;
    private final static int PRICE_PER_HOUR_FOR_SHIP = 19;

    private final static int CELLS_FOR_CARS = 200;
    private final static int CELLS_FOR_PLANE = 100;
    private final static int CELLS_FOR_TRAIN = 20;
    private final static int CELLS_FOR_SHIP = 50;

    private Map<String, Set<Vehicle>> parkingCells;
    private Map<Vehicle, Integer> reservedHoursForVehicle;
    private int income;

    public AirportParking() {
        this.parkingCells = new HashMap<>();
        this.reservedHoursForVehicle = new HashMap<>();
        this.parkingCells.put(Vehicle.AIRILY, new HashSet<>());
        this.parkingCells.put(Vehicle.MARINE, new HashSet<>());
        this.parkingCells.put(Vehicle.OVERLAND, new HashSet<>());
        this.parkingCells.put(Vehicle.RAILWAY, new HashSet<>());
    }

    public int getIncome() {
        return income;
    }

    public boolean addVehicleToParking(Vehicle vehicle, int hours) {
        boolean haveFreeCell = false;
        switch (vehicle.vehicleKind()) {
            case "Airily":
                if (this.parkingCells.get(vehicle.vehicleKind()).size() < CELLS_FOR_PLANE) {
                    this.parkingCells.get(vehicle.vehicleKind()).add(vehicle);
                    haveFreeCell = true;
                }
                break;
            case "Marine":
                if (this.parkingCells.get(vehicle.vehicleKind()).size() < CELLS_FOR_SHIP) {
                    this.parkingCells.get(vehicle.vehicleKind()).add(vehicle);
                    haveFreeCell = true;
                }
                break;
            case "Railway":
                if (this.parkingCells.get(vehicle.vehicleKind()).size() < CELLS_FOR_TRAIN) {
                    this.parkingCells.get(vehicle.vehicleKind()).add(vehicle);
                    haveFreeCell = true;
                }
                break;
            default:
                if (this.parkingCells.get(vehicle.vehicleKind()).size() < CELLS_FOR_CARS) {
                    this.parkingCells.get(vehicle.vehicleKind()).add(vehicle);
                    haveFreeCell = true;
                }
                break;
        }

        if (haveFreeCell) {
            this.reservedHoursForVehicle.put(vehicle, hours);
            return true;
        } else {
            return false;
        }
    }

    private void payForParking(Vehicle vehicle) {
        switch (vehicle.vehicleKind()) {
            case "Airily":
                this.income += this.reservedHoursForVehicle.get(vehicle) * PRICE_PER_HOUR_FOR_PLANE;
                break;
            case "Marine":
                this.income += this.reservedHoursForVehicle.get(vehicle) * PRICE_PER_HOUR_FOR_SHIP;
                break;
            case "Railway":
                this.income += this.reservedHoursForVehicle.get(vehicle) * PRICE_PER_HOUR_FOR_TRAIN;
                break;
            default:
                this.income += this.reservedHoursForVehicle.get(vehicle) * PRICE_PER_HOUR_FOR_CAR;
                break;
        }
    }

    public void freeReservedCell(Vehicle vehicle) {
        payForParking(vehicle);
        this.reservedHoursForVehicle.remove(vehicle);
        this.parkingCells.get(vehicle.vehicleKind()).remove(vehicle);
        System.out.println(vehicle.getName() + " has vacated its parking space.");
    }
}
