package Entity;
import java.sql.Date;

/**
 *
 * @author DxG
 */
public class Survey {
    private int id;
    private String name;
    private String description;
    //Id of user
    private String user;
    private int status;
    private Date createdDate;
    private String link;
    // contructor is used when get Survey from sql
    public Survey(int id, String name, String description, String user, int status, Date createdDate, String link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
        this.status = status;
        this.createdDate = createdDate;
        this.link = link;
    }

    // contructor is used when insert into database
    public Survey(String name, String description, String user, Date createdDate, String link) {
        this.id=0;
        this.name = name;
        this.description = description;
        this.user = user;
        this.status=0;
        this.createdDate = createdDate;
        this.link = link;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    //If status = 0 -> survey is Created
    //If status = 1 -> survey is Running
    //If status = 2 -> survey is Stopped
    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " | " + name +" | " +  description + " | " + user + " | " + status + " | " + createdDate + " | " + link;
    }
    
}
