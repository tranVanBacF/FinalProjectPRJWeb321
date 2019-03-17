package Entity;

import java.sql.Date;

/**
 *
 * @author DxG
 */
public class User {
    private String name;
    private String email;
    private Date birthday;
    private Date registrationDate;
    private String username;
    private String password;

    
    public User(String name, String email, Date birthday, Date registrationDate, String username, String password) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
