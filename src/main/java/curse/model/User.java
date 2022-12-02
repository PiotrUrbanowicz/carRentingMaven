package curse.model;

import curse.Authenticator;
import org.apache.commons.codec.digest.DigestUtils;

public class User {
    private String login;
    private String password;
    private Rule rule;

    public User() {
    }

    public User(String login, String password, Rule rule) {
        this.login = login;
        this.password = password;
        this.rule = rule;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User)){
            return false;
        }
        User temp=(User)obj;
        return this.getLogin().equals(temp.getLogin())
                && this.getPassword().equals(
                        DigestUtils.md5Hex(temp.getPassword()+ Authenticator.seed));
    }

    public enum Rule{
        USER,
        ADMIN
    }

    public String convertToData(){

        return new StringBuilder()
                .append(this.getLogin())
                .append(";")
                .append(this.getPassword())
                .append(";")
                .append(this.getRule())
                .toString();
    }

}
