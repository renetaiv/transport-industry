package main.filesOperations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DemoReadingJson {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader reader = new FileReader("vehicles.json")) {
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            String text = gson.toJson(jsonElement);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
