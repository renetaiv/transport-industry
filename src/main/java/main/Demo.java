package main;

import main.domainModel.AirportParking;
import main.domainModel.Person;
import main.domainModel.TransportCompany;
import main.domainModel.Vehicle;
import main.domainModel.cars.HybridCar;
import main.domainModel.cars.InternalCombustionCar;
import main.domainModel.planes.Airliner;
import main.domainModel.planes.CargoPlane;
import main.domainModel.ships.CruiseShip;
import main.domainModel.trains.PassengerTrain;

public class Demo {

    public static void main(String[] args) {
        Vehicle mazda = new InternalCombustionCar(InternalCombustionCar.InternalCombustionCarModelType.MAZDA_6, ColorType.GREY, InternalCombustionCar.EngineType.BENZINE);
        Vehicle hybridCar = new HybridCar(HybridCar.HybridCarModelType.LEXUS_RX_450H_L, ColorType.BLUE, HybridCar.EngineType.FULL_HYBRID);
        Vehicle passengerTrain = new PassengerTrain(PassengerTrain.PassengerTrainModelType.INDIAN_PACIFIC, ColorType.BLUE, 200);
        Vehicle cruiseShip = new CruiseShip(CruiseShip.CruiseShipModelType.ADVENTURE_OF_THE_SEAS, ColorType.WHITE, 5000);
        Vehicle boeing = new CargoPlane(CargoPlane.CargoPlaneModelType.BOEING_747_DREAMLIFTER, ColorType.GREY, 200);
        Vehicle airbus = new Airliner(Airliner.AirlinerModelType.AIRBUS_A310_LUFTHANSA, ColorType.WHITE, 750);

        ((Airliner) airbus).addPassenger(new Person("Petar Georgiev", 22, true), ((Airliner) airbus).getPassengers(),
                ((Airliner) airbus).getMaxCapacity());
        ((Airliner) airbus).addPassenger(new Person("Mariela Ivanova", 25, false), ((Airliner) airbus).getPassengers(),
                ((Airliner) airbus).getMaxCapacity());
        ((Airliner) airbus).addPassenger(new Person("Mario Petkov", 30, true), ((Airliner) airbus).getPassengers(),
                ((Airliner) airbus).getMaxCapacity());
        ((Airliner) airbus).addPassenger(new Person("Ivan Krustev", 21, true), ((Airliner) airbus).getPassengers(),
                ((Airliner) airbus).getMaxCapacity());
        ((Airliner) airbus).addPassenger(new Person("Georgi Taushanov", 48, true), ((Airliner) airbus).getPassengers(),
                ((Airliner) airbus).getMaxCapacity());
        ((Airliner) airbus).addPassenger(new Person("Kiril Angelkov", 50, true), ((Airliner) airbus).getPassengers(),
                ((Airliner) airbus).getMaxCapacity());
        ((Airliner) airbus).addPassenger(new Person("Iveta Kostova", 38, false), ((Airliner) airbus).getPassengers(),
                ((Airliner) airbus).getMaxCapacity());

        System.out.println("----- Passengers on airliner sorted by name ------");
        ((Airliner) airbus).showPassengers(((Airliner) airbus).getPassengers());

        System.out.println("------ Passengers on airline sorted by age -------");
        ((Airliner) airbus).showSortedPassengersByAge(((Airliner) airbus).getPassengers());

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
        transportCompany.addVehicle(passengerTrain);

        System.out.println("-------- Displaying vehicles by category --------");
        transportCompany.displayVehiclesMap();

        System.out.println("--------- Displaying different vehicles ----------");
        System.out.println(mazda);
        System.out.println(cruiseShip);
        System.out.println(passengerTrain);
        System.out.println(boeing);
        System.out.println(airbus);

        AirportParking parking = new AirportParking();
        parking.addVehicleToParking(airbus, 8);
        parking.addVehicleToParking(mazda, 15);
        parking.addVehicleToParking(hybridCar, 3);
        parking.addVehicleToParking(cruiseShip, 30);

        System.out.println("------------- Show parking vehicles --------------");
        parking.showVehiclesAtParking();

        System.out.println("-------- Show leaving cars from the parking --------");
        parking.freeReservedCell(airbus);
        //parking.freeReservedCell(passengerTrain);
        parking.freeReservedCell(mazda);
        parking.freeReservedCell(cruiseShip);

        System.out.println("-------------- Show parking's income ---------------");
        System.out.println(parking.getIncome() + " BGN");

        System.out.println("---- Show the other vehicles in the parking lot ----");
        parking.showVehiclesAtParking();
    }
}