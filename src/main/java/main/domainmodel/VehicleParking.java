package main.domainmodel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VehicleParking {

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

        if (this.parkingCells.get(vehicle.vehicleKind()).size() < vehicle.getVehicleMaxParkingCells()) {
            this.parkingCells.get(vehicle.vehicleKind()).add(vehicle);
            haveFreeCell = true;
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
