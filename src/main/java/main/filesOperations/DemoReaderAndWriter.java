package main.filesOperations;

import main.ColorType;
import main.domainModel.TransportCompany;
import main.domainModel.Vehicle;
import main.domainModel.planes.Airliner;
import main.domainModel.trains.PassengerTrain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DemoReaderAndWriter {

    public static void main(String[] args) {
        File file = new File("vehicles_names.txt");

        TransportCompany transportCompany = new TransportCompany();
        transportCompany.addVehicle(new PassengerTrain(PassengerTrain.ModelType.INDIAN_PACIFIC, ColorType.BLUE,
                200));
        transportCompany.addVehicle(new Airliner(Airliner.ModelType.EMBRAER_LINEAGE_1000E, ColorType.WHITE,
                500));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            List<String> text = new ArrayList<>();
            for (Map.Entry<String, Set<Vehicle>> stringArrayListEntry : transportCompany.getVehiclesMap().entrySet()) {
                for (Vehicle vehicle : stringArrayListEntry.getValue()) {
                    text.add(vehicle.getName() + '\n');
                }
            }

            for (String s : text) {
                bufferedWriter.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
