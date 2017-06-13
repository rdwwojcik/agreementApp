package agreement.core.repositories;

import agreement.core.entities.Contractor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Radek on 12.06.2017.
 */
@Repository
public interface ContractorRepository extends CrudRepository<Contractor, Long> {

    Contractor findByNip(String nip);
}
