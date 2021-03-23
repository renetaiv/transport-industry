package main.filesoperations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.ColorType;
import main.domainmodel.Vehicle;
import main.domainmodel.cars.InternalCombustionCar;
import main.domainmodel.planes.Airliner;
import main.domainmodel.trains.PassengerTrain;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DemoWritingInFile {

    public static void main(String[] args) {
        Airliner airliner = new Airliner(Airliner.AirlinerModelType.AIRBUS_A310_LUFTHANSA, ColorType.WHITE, 500);
        InternalCombustionCar internalCombustionCar = new InternalCombustionCar(InternalCombustionCar.InternalCombustionCarModelType.BMW_318,
                ColorType.BLACK, InternalCombustionCar.EngineType.DIESEL);

        PassengerTrain.PassengerTrainModelType[] trainModels = PassengerTrain.PassengerTrainModelType.values();
        ColorType[] colors = ColorType.values();
        //Generate train with random parameters
        Vehicle train = new PassengerTrain(trainModels[new Random().nextInt(trainModels.length)],
                colors[new Random().nextInt(colors.length)], (int) (Math.random() * 500) + 1);

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
