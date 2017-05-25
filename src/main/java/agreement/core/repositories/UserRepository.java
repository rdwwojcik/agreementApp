package agreement.core.repositories;

import agreement.core.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Radek on 07.03.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
}
