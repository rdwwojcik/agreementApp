package agreement.core.dto;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Radek on 06.09.2017.
 */
public class CurrentUser extends User {

    private UserDTO userDTO;

    public CurrentUser(UserDTO userDTO) {
        super(userDTO.getLogin(), userDTO.getPasswordHash(), AuthorityUtils.createAuthorityList("USER"));
        this.userDTO = userDTO;
    }
}
