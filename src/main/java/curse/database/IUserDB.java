package curse.database;

import curse.model.User;

import java.util.List;

public interface IUserDB {

    User findUserByLogin(String login);
    List<User> getUsers();
    void persistToFile();

}
