package main;

import main.domainmodel.Person;
import main.domainmodel.TransportCompany;
import main.domainmodel.Vehicle;
import main.domainmodel.VehicleParking;
import main.domainmodel.cars.HybridCar;
import main.domainmodel.cars.InternalCombustionCar;
import main.domainmodel.planes.Airliner;
import main.domainmodel.planes.CargoPlane;
import main.domainmodel.ships.CruiseShip;
import main.domainmodel.trains.PassengerTrain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) {
        Vehicle mazda = new InternalCombustionCar(InternalCombustionCar.InternalCombustionCarModelType.MAZDA_6, ColorType.GREY, InternalCombustionCar.EngineType.BENZINE);
        Vehicle hybridCar = new HybridCar(HybridCar.HybridCarModelType.LEXUS_RX_450H_L, ColorType.BLUE, "B6549CA", HybridCar.EngineType.FULL_HYBRID);
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

        VehicleParking parking = new VehicleParking();
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

        Vehicle embraer = new Airliner(Airliner.AirlinerModelType.EMBRAER_LINEAGE_1000E, ColorType.BLUE, 600);

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            String query = "INSERT INTO hybrid_cars(registration_number, model, color, engine)" + "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ((HybridCar) hybridCar).getRegistrationNumber());
            preparedStatement.setString(2, hybridCar.getName());
            preparedStatement.setString(3, hybridCar.getColor().toString());
            preparedStatement.setString(4, ((HybridCar) hybridCar).getEngine().toString());
            preparedStatement.executeUpdate();

            executeQueryForAirliner(airbus, connection);
            executeQueryForAirliner(embraer, connection);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQueryForAirliner(Vehicle airliner, Connection connection) throws SQLException {
        String query = "INSERT INTO airliners(model, color, max_capacity)" + "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, airliner.getName());
        preparedStatement.setString(2, airliner.getColor().toString());
        preparedStatement.setString(3, String.valueOf(((Airliner) airliner).getMaxCapacity()));
        preparedStatement.executeUpdate();
    }
}