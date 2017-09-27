package agreement.core.dto;

import agreement.core.security.Role;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by Radek on 13.05.2017.
 */
public class UserDTO{

    private Long    id;
    @NotNull
    private String  name;
    @NotNull
    private String  lastName;
    @NotNull
    @Length(min = 8, max = 30, message = "Login - not correct long of login")
    private String  login;
    @NotNull
    @Length(min = 8, max = 30, message = "Password - not correct long of password")
    private String  password;
    private String  passwordHash;
    private String  email;
    private Role    role;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String lastName, String login) {
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

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        UserDTO userDTO = (UserDTO) o;
//
//        if (!id.equals(userDTO.id)) return false;
//        if (!name.equals(userDTO.name)) return false;
//        if (!lastName.equals(userDTO.lastName)) return false;
//        return login.equals(userDTO.login);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + name.hashCode();
//        result = 31 * result + lastName.hashCode();
//        result = 31 * result + login.hashCode();
//        return result;
//    }
}
