package curse.database;

import curse.model.Vehicle;

import java.util.List;

public interface IVehicleDB {
    boolean rentVehicle(String plate);
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    void persistToFile();

}
