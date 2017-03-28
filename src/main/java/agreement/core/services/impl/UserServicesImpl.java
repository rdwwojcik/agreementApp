package agreement.core.services.impl;

import agreement.core.entities.User;
import agreement.core.repositories.UserRepository;
import agreement.core.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Radek on 07.03.2017.
 */
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
