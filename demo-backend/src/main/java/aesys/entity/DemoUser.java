package aesys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class DemoUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Email(message = "Email should be valid")
    @Column(name="EMAIL", length=50, nullable=false, unique=false)
    private String email;

    @NotNull(message = "Name cannot be null")
    @Column(name="USERNAME", length=50, nullable=false, unique=false)
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DemoUser(long id, @Email(message = "Email should be valid") String email,
            @NotNull(message = "Name cannot be null") String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public DemoUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
