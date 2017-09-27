package agreement.core.services.impl;

import agreement.core.dto.UserDTO;
import agreement.core.entities.User;
import agreement.core.exceptions.AccountDoesNotExistException;
import agreement.core.exceptions.UserRegistrationException;
import agreement.core.mapper.UserMapper;
import agreement.core.repositories.UserRepository;
import agreement.core.security.Password;
import agreement.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Radek on 07.03.2017.
 */
@Service
public class UserServicesImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Autowired
    public UserServicesImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserDTO existUser = findByLogin(userDTO.getLogin());
        if (existUser != null){
            throw new UserRegistrationException(UserRegistrationException.FailReason.USER_ALREADY_EXISTS);
        }

        User user = userMapper.fromDTO(userDTO);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(user.getPassword());
        user.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        user.setCreationDate(new Date());
        user.setModificationDate(new Date());

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(UserDTO user) {

        User updated;
        if(userRepository.findOne(user.getId()) != null){
            updated = userMapper.fromDTO(user);
            updated.setModificationDate(new Date());
            updated = userRepository.save(updated);
        }
        else{
            throw new AccountDoesNotExistException("User not exist");
        }

        return userMapper.toDTO(updated);
    }

    @Override
    public UserDTO findById(Long id){

        User user = userRepository.findOne(id);
        if (user == null){
            throw new AccountDoesNotExistException();
        }

        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO findByLogin(String login) {

        User user = userRepository.findByLogin(login);

        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {

        List<User> users = (List<User>) userRepository.findAll();

        return userMapper.toDTO(users);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
