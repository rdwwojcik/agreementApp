package agreement.core.services;

import agreement.core.entities.User;

/**
 * Created by Radek on 07.03.2017.
 */
public interface UserServices {

    public User createUser(User user);
    public User updateUser(User user);
    public User findUser(Long id);
    public void deleteUser(Long id);
}
