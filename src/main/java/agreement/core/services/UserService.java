package agreement.core.services;

import agreement.core.dto.UserDTO;
import agreement.core.exceptions.UserRegistrationException;

import java.util.List;

/**
 * Created by Radek on 07.03.2017.
 */
public interface UserService {

    UserDTO createUser(UserDTO user) throws UserRegistrationException;

    UserDTO updateUser(UserDTO user);

    UserDTO findById(Long id);

    UserDTO findByLogin(String login);

    List<UserDTO> findAll();
    
    void deleteUser(Long id);
}
