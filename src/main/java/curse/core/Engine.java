package curse.core;

import curse.Authenticator;
import curse.database.IUserDB;
import curse.database.IVehicleDB;
import curse.database.UserDB;
import curse.database.VehicleDB;
import curse.gui.Gui;
import curse.model.User;

import java.io.IOException;

public class Engine {

    private final static Engine instance=new Engine();
    private final IVehicleDB vehicleDB=VehicleDB.getInstance();
    private final IUserDB userDB=UserDB.getInstance();
    private final Gui gui=Gui.getInstance();
    private final Authenticator authenticator=Authenticator.getInstance();
    private Engine() {}

    public static Engine getInstance(){
        return instance;
    }

    public void start() throws IOException {
        boolean isWorking= authenticator.authenticate();

        //zadajesz sobie pytanie czy ktoś kiedyś powinien tą zmienną zmienić jeśli nie to wrzucasz final
        while(isWorking) {
            gui.showMenu();
            switch (gui.getReader().readLine()) {
                case "1":
                    gui.listVehicles(vehicleDB.getVehicles());
                    break;
                case "2":// czemu nie wsadzimy tego do gui
                    System.out.println("Plate: ");
                    if (vehicleDB.rentVehicle(gui.getReader().readLine())) {
                        System.out.println("car is rented");
                    } else {
                        System.out.println("rent error");
                    }
                    break;
                case "3":
                    if(Authenticator.loggedUser.getRule()== User.Rule.ADMIN){
                        gui.addVehicle();
                    }
                    break;
                case "4":
                    vehicleDB.persistToFile();
                    userDB.persistToFile();
                    gui.getReader().close();
                    isWorking=false;
                    //exit(0);
                    break;
                default:
                    System.out.println("wrong number");
                    break;
            }
        }




    }
}