package curse;

import curse.database.UserDB;
import curse.gui.Gui;
import curse.model.User;

public class Authenticator {
    public static final String seed = "1Tl8*G3Ertpxvj0%8qpy";
    public static User loggedUser;
    private final Gui gui=Gui.getInstance();

    private final static Authenticator instance=new Authenticator();

    private Authenticator() {
    }

    public static Authenticator getInstance() {
        return instance;
    }

    public boolean authenticate() {
        UserDB userDB=UserDB.getInstance();//czemu tu?
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

