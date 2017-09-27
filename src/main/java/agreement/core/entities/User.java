package agreement.core.entities;

import agreement.core.security.Role;
import agreement.core.tools.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Radek on 07.03.2017.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id", updatable = false)
    private Long    id;
    @Column(name = "us_imie", nullable = false)
    private String  name;
    @Column(name = "us_nazwisko", nullable = false)
    private String  lastName;
    @Column(name = "us_login", nullable = false, unique = true)
    private String  login;
    @Column(name = "us_haslo", nullable = false)
    @JsonIgnore
    private String  password;
    @Column(name = "us_password_hash", nullable = false)
    @JsonIgnore
    private String  passwordHash;
    @Column(name = "us_email", nullable = false)
    private String email;
    @Column(name = "us_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "us_data_utworzenia")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    creationDate;
    @Column(name = "us_czas_bazy")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    modificationDate;

    public User(){}

    public User(Long id, String name, String lastName, String login) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return login.equals(user.login)
                && lastName.equals(user.lastName)
                && name.equals(user.name)
                && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + login.hashCode();
        return result;
    }
}
