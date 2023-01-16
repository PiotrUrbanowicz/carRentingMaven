package curse.database;

import curse.model.User;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserDB implements IUserDB {
    private final HashMap<String,User> users=new HashMap<>();
    private final String USER_DB_FILE="User.txt";

    // private UserDB instance=new UserDB();
    private UserDB() {
//        this.users.put("piotr",new User("piotr",
//                "34fabc41d484eb1563a1c188e0b30718",User.Rule.USER));//admin
//        this.users.put("admin",new User("admin",
//                "34fabc41d484eb1563a1c188e0b30718", User.Rule.ADMIN));//admin

        try {
            BufferedReader reader=new BufferedReader(new FileReader(USER_DB_FILE));
        String line;
        while((line=reader.readLine())!=null){
            String[] params=line.split(";");

            this.users.put(params[0],
                    new User(params[0], params[1], User.Rule.valueOf(params[2])));
        }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public User findUserByLogin(String login){
        return this.users.get(login);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

//    public static UserDB getInstance(){
//        return instance;
//    }



    public void persistToFile() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DB_FILE));

            boolean flag = false;
            for (User element : this.users.values()) {
                if (flag) {
                    writer.newLine();
                }
                flag = true;
                writer.write(element.convertToData());
                writer.flush();
            }
            writer.close();
            } catch(IOException e){
            System.out.println("Cos sie zepsulo podczas zapisu");
            e.printStackTrace();
            }
        }




}
