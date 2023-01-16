package curse.gui;

import curse.Authenticator;
import curse.database.IVehicleDB;
import curse.database.VehicleDB;
import curse.model.*;
import curse.model.builders.MotorcycleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class Gui {

    @Autowired
    IVehicleDB vehicleDB;

    public final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    //  private final static Gui instance=new Gui();
   // private Gui() {}
//    public static Gui getInstance(){
//        return instance;
//    }
    public void showMenu(){
        System.out.println(" MENU ");
        System.out.println("1.List vehicles");
        System.out.println("2.Rent vehicle");
        if(Authenticator.loggedUser.getRule()== User.Rule.ADMIN){
            System.out.println("3.Add vehicle");
        }
            System.out.println("4.Exit");
    }

    public void listVehicles(List<Vehicle> vehicles){

        for (Vehicle currentVehicle : vehicles) {
            System.out.println(currentVehicle);
        }
    }

    public User readLoginAndPassword(){
        User user=new User();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Login:");
        user.setLogin(scanner.nextLine());
        System.out.println("Password: ");
        user.setPassword(scanner.nextLine());
        Random ran=new Random();

        return user;
    }

    public void addVehicle(){
        System.out.println("1.Car");
        System.out.println("2.Bus");
        System.out.println("3.Motocycle");
        Scanner scanner=new Scanner(System.in);
        switch (scanner.nextLine()){
            case "1":
                Car car=new Car();
                System.out.println("plate:");
                car.setPlate(scanner.nextLine());
                System.out.println("price:");
                car.setPrice(Integer.parseInt(scanner.nextLine()));
                car.setRent(false);
                vehicleDB.addVehicle(car);
                break;

            case "2":
                Bus bus=new Bus();
                System.out.println("plate:");
                bus.setPlate(scanner.nextLine());
                System.out.println("Price:");
                bus.setPrice(Integer.parseInt(scanner.nextLine()));
                bus.setRent(false);
                System.out.println("Seats:");
                bus.setSeats(Integer.parseInt(scanner.nextLine()));
                vehicleDB.addVehicle(bus);
                break;
            case "3":
                Motorcycle motocycle=new Motorcycle();
                MotorcycleBuilder mb=new MotorcycleBuilder();
                System.out.println("plate:");
                mb.plate(scanner.nextLine());
                System.out.println("Price:");
                mb.price(Double.parseDouble(scanner.nextLine()));
                System.out.println("cart(n/y):");
                mb.cart(scanner.nextLine().equals("y"));

                vehicleDB.addVehicle(mb.build());
                System.out.println("motorcycle added");
                break;
            default:
                System.out.println("wrong choose");
                break;
        }
    }

    public BufferedReader getReader() {
        return reader;
    }
}
