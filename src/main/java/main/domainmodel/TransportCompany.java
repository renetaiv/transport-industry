package main.domainmodel;

import java.util.*;

public class TransportCompany {

    private Map<String, Set<Vehicle>> vehiclesMap;

    public TransportCompany() {
        this.vehiclesMap = new TreeMap<>(Comparator.naturalOrder());
    }

    public Map<String, Set<Vehicle>> getVehiclesMap() {
        return vehiclesMap;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehiclesMap
                .computeIfAbsent(vehicle.vehicleKind(), set -> new HashSet<>())
                .add(vehicle);
    }

    public void displayVehiclesMap() {
        for (Map.Entry<String, Set<Vehicle>> vehicles : this.vehiclesMap.entrySet()) {
            System.out.println(vehicles.getKey() + ":");
            for (Vehicle vehicle : vehicles.getValue()) {
                System.out.println(vehicle.getName());
            }
            System.out.println("--------------------------------------------------");
        }
    }
}
