package agreement.core.repositories;

import agreement.core.entities.AgreementFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Radek on 25.07.2017.
 */
@Repository
public interface AgreementFileRepository extends CrudRepository<AgreementFile, Long> {
}
