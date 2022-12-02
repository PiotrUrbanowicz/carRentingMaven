package curse;

import curse.database.UserDB;
import curse.gui.Gui;
import curse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Authenticator {
    public static final String seed = "1Tl8*G3Ertpxvj0%8qpy";
    public static User loggedUser;
    @Autowired
    private Gui gui;



    @Autowired
    private UserDB userDB;



  //  private final static Authenticator instance=new Authenticator();

  //  private Authenticator() {}

//    public static Authenticator getInstance() {
//        return instance;
//    }

    public boolean authenticate() {
        for (int i = 0; i < 3; i++) {
            User user = gui.readLoginAndPassword();
            User userFromDB = userDB.findUserByLogin(user.getLogin());
            if (userFromDB != null && userFromDB.equals(user)) {
                Authenticator.loggedUser = userFromDB;
                return true;
            }
        }
        return false;
    }
}

