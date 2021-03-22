package main.domainModel;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TransportCompany {

    private Map<String, ArrayList<Vehicle>> vehiclesMap;

    public TransportCompany() {
        this.vehiclesMap = new TreeMap<>((v1, v2) -> v1.compareTo(v2));
    }

    public Map<String, ArrayList<Vehicle>> getVehiclesMap() {
        return vehiclesMap;
    }

    public void addVehicle(Vehicle vehicle) {
        if (!this.vehiclesMap.containsKey(vehicle.vehicleKind())) {
            this.vehiclesMap.put(vehicle.vehicleKind(), new ArrayList<>());
        }
        this.vehiclesMap.get(vehicle.vehicleKind()).add(vehicle);
    }

    public void displayVehiclesMap() {
        for (Map.Entry<String, ArrayList<Vehicle>> vehicles : this.vehiclesMap.entrySet()) {
            System.out.println(vehicles.getKey() + ":");
            for (Vehicle vehicle : vehicles.getValue()) {
                System.out.println(vehicle.getName());
            }
            System.out.println("--------------------------------------------------");
        }
    }
}
