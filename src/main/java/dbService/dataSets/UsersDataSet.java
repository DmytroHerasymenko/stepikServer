package dbService.dataSets;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dima on 02.12.16.
 */
@Entity
@Table(name = "users")

public class UsersDataSet implements Serializable{ // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "password", updatable = false)
    private String password;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(long id, String name) {
        this.setId(id);
        this.setPassword(name);
    }

    public UsersDataSet(String name, String pass) {
        this.setId(-1);
        this.setName(name);
        this.setPassword(pass);
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
