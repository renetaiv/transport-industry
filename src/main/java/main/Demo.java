package main;

import main.cars.HybridCar;
import main.cars.InternalCombustionCar;
import main.planes.Airliner;
import main.planes.CargoPlane;
import main.ships.CruiseShip;
import main.trains.PassengerTrain;

public class Demo {

    public static void main(String[] args) {
        Vehicle mazda = new InternalCombustionCar(InternalCombustionCar.ModelType.MAZDA_6, ColorType.GREY, InternalCombustionCar.EngineType.BENZINE);
        Vehicle hybridCar = new HybridCar(HybridCar.ModelType.LEXUS_RX_450H_L, ColorType.BLUE, HybridCar.EngineType.FULL_HYBRID);
        Vehicle passengerTrain = new PassengerTrain(PassengerTrain.ModelType.INDIAN_PACIFIC, ColorType.BLUE, 200);
        Vehicle cruiseShip = new CruiseShip(CruiseShip.ModelType.ADVENTURE_OF_THE_SEAS, ColorType.WHITE, 5000);
        Vehicle boeing = new CargoPlane(CargoPlane.ModelType.BOEING_747_DREAMLIFTER, ColorType.GREY, 200);
        Vehicle airbus = new Airliner(Airliner.ModelType.AIRBUS_A310_LUFTHANSA, ColorType.WHITE, 750);

        ((Airliner) airbus).addPassenger(new Person("Petar Georgiev", 22, 'M'));
        ((Airliner) airbus).addPassenger(new Person("Mariela Ivanova", 25, 'F'));
        ((Airliner) airbus).addPassenger(new Person("Mario Petkov", 30, 'M'));
        ((Airliner) airbus).addPassenger(new Person("Ivan Krustev", 21, 'M'));
        ((Airliner) airbus).addPassenger(new Person("Georgi Taushanov", 48, 'M'));
        ((Airliner) airbus).addPassenger(new Person("Kiril Angelkov", 50, 'M'));
        ((Airliner) airbus).addPassenger(new Person("Iveta Kostova", 38, 'F'));

        System.out.println("------------ Passengers on airliner --------------");
        ((Airliner) airbus).showPassengers();

        System.out.println("------------ Displaying level of environmental friendliness ---------------");
        ((InternalCombustionCar) mazda).displayEnvironmentalFriendliness();
        ((HybridCar) hybridCar).displayEnvironmentalFriendliness();

        System.out.println("----------------------- Displaying kind of vehicle ------------------------");
        mazda.displayVehicleKind();
        cruiseShip.displayVehicleKind();

        TransportCompany transportCompany = new TransportCompany();
        transportCompany.addVehicle(mazda);
        transportCompany.addVehicle(hybridCar);
        transportCompany.addVehicle(airbus);

        System.out.println("-------- Displaying vehicles by category --------");
        transportCompany.displayVehiclesMap();

        System.out.println("--------- Displaying different vehicles ----------");
        System.out.println(mazda);
        System.out.println(cruiseShip);
        System.out.println(passengerTrain);
        System.out.println(boeing);
        System.out.println(airbus);

    }
}