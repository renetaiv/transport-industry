package main.filesOperations;

import main.ColorType;
import main.TransportIndustry;
import main.Vehicle;
import main.planes.Airliner;
import main.trains.PassengerTrain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoReaderAndWriter {

    public static void main(String[] args) {
        File file = new File("vehicles_names.txt");

        TransportIndustry transportIndustry = new TransportIndustry();
        transportIndustry.addVehicle(new PassengerTrain(PassengerTrain.ModelType.INDIAN_PACIFIC, ColorType.BLUE,
                200));
        transportIndustry.addVehicle(new Airliner(Airliner.ModelType.EMBRAER_LINEAGE_1000E, ColorType.WHITE,
                500));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            List<String> text = new ArrayList<>();
            for (Map.Entry<String, ArrayList<Vehicle>> stringArrayListEntry : transportIndustry.getVehiclesMap().entrySet()) {
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
