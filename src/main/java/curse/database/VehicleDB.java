package curse.database;

import curse.IllegalDataInDatabaseFile.IllegalDataInDatabaseFile;
import curse.model.Bus;
import curse.model.Car;
import curse.model.Motorcycle;
import curse.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDB implements IVehicleDB {

    private final List<Vehicle> vehicles=new ArrayList<>();
    private final String VEHICLE_DB_FILE ="VehicleDB.txt";
    private final static VehicleDB instance=new VehicleDB();

    private VehicleDB(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(VEHICLE_DB_FILE));
            String line;
            while((line=reader.readLine())!=null) {
                Vehicle vehicle=convertDataToVehicle(line);
                if(vehicle!=null){
                    this.vehicles.add(vehicle);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public boolean rentVehicle(String plate){
        for (Vehicle currentVehicle:vehicles) {
            if(currentVehicle.getPlate().equals(plate) && !currentVehicle.isRent()) {
                currentVehicle.setRent(true);
                    return true;
                }
            }
        return false;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static VehicleDB getInstance(){
        return instance;
    }

    ///////////////////////
    public void persistToFile(){
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(VEHICLE_DB_FILE));

            writer.write(this.vehicles.get(0).convertToData());
            for (int i = 1; i <vehicles.toArray().length; i++) {
                writer.newLine();
                writer.write(this.vehicles.get(i).convertToData());
            writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("cos nie dziala");
            e.printStackTrace();
        }
    }


    ////////////////////////
    private Vehicle convertDataToVehicle(String data){
        String[] vehicleData=data.split(";");
        switch (vehicleData[0]){
            case "Car":
                return new Car(vehicleData);
            case "Bus":
                return new Bus(vehicleData);
            case "Motorcycle":
               return new Motorcycle(vehicleData);
            default: {
                try {
                    throw new IllegalDataInDatabaseFile();
                } catch (IllegalDataInDatabaseFile e) {
                    e.printStackTrace();
                }
                return null;

            }

        }

}


}
