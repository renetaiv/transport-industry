package main.filesOperations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.ColorType;
import main.Vehicle;
import main.cars.InternalCombustionCar;
import main.planes.Airliner;
import main.trains.PassengerTrain;
import main.util.Randomizer;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DemoWritingInFile {

    public static void main(String[] args) {
        Airliner airliner = new Airliner(Airliner.ModelType.AIRBUS_A310_LUFTHANSA, ColorType.WHITE, 500);
        InternalCombustionCar internalCombustionCar = new InternalCombustionCar(InternalCombustionCar.ModelType.BMW_318,
                ColorType.BLACK, InternalCombustionCar.EngineType.DIESEL);

        PassengerTrain.ModelType[] trainModels = PassengerTrain.ModelType.values();
        ColorType[] colors = ColorType.values();
        //Generate train with random parameters
        Vehicle train = new PassengerTrain(trainModels[new Random().nextInt(trainModels.length)],
                colors[new Random().nextInt(colors.length)], Randomizer.getRandomNumber(1, 500));

        //xml
        try (FileOutputStream fileOutputStream = new FileOutputStream("vehicles.xml")) {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOutputStream));
            encoder.writeObject(airliner.toString());
            encoder.writeObject(internalCombustionCar.toString());
            encoder.writeObject(train.toString());
            encoder.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("vehicles.json")) {
            String text = gson.toJson(airliner);
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
