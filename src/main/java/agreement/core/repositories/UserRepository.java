package agreement.core.repositories;

import agreement.core.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Radek on 07.03.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
