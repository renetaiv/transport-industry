package main.domainmodel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VehicleParking {

    private final static int CELLS_FOR_CARS = 200;
    private final static int CELLS_FOR_PLANES = 100;
    private final static int CELLS_FOR_TRAINS = 20;
    private final static int CELLS_FOR_SHIPS = 50;

    private Map<String, Set<Vehicle>> parkingCells;
    private Map<Vehicle, Integer> reservedHoursForVehicle;
    private int income;

    public VehicleParking() {
        this.parkingCells = new HashMap<>();
        this.reservedHoursForVehicle = new HashMap<>();
        this.parkingCells.put(Vehicle.AIRILY, new HashSet<>());
        this.parkingCells.put(Vehicle.MARINE, new HashSet<>());
        this.parkingCells.put(Vehicle.OVERLAND, new HashSet<>());
        this.parkingCells.put(Vehicle.RAILWAY, new HashSet<>());
    }

    public int getIncome() {
        return this.income;
    }

    public boolean addVehicleToParking(Vehicle vehicle, int hours) {
        boolean haveFreeCell = false;
        switch (vehicle.vehicleKind()) {
            case "Airily":
                if (this.parkingCells.get(vehicle.vehicleKind()).size() < CELLS_FOR_PLANES) {
                    this.parkingCells.get(vehicle.vehicleKind()).add(vehicle);
                    haveFreeCell = true;
                }
                break;
            case "Marine":
                if (this.parkingCells.get(vehicle.vehicleKind()).size() < CELLS_FOR_SHIPS) {
                    this.parkingCells.get(vehicle.vehicleKind()).add(vehicle);
                    haveFreeCell = true;
                }
                break;
            case "Railway":
                if (this.parkingCells.get(vehicle.vehicleKind()).size() < CELLS_FOR_TRAINS) {
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

    public void showVehiclesAtParking() {
        for (Map.Entry<String, Set<Vehicle>> vehicles : this.parkingCells.entrySet()) {
            System.out.println(vehicles.getKey() + ":");
            for (Vehicle vehicle : vehicles.getValue()) {
                System.out.println(vehicle.getName());
            }
            System.out.println("-----------------------------");
        }
    }

    private void payForParking(Vehicle vehicle) {
        this.income += this.reservedHoursForVehicle.get(vehicle) * vehicle.getVehiclePricePerHour();
    }

    public void freeReservedCell(Vehicle vehicle) {
        if (parkingCells.get(vehicle.vehicleKind()).contains(vehicle)) {
            payForParking(vehicle);
            this.reservedHoursForVehicle.remove(vehicle);
            this.parkingCells.get(vehicle.vehicleKind()).remove(vehicle);
            System.out.println(vehicle.getName() + " has vacated its parking space.");
        } else {
            System.out.println(vehicle.getName() + " is not part of the parking lot.");
        }
    }
}
