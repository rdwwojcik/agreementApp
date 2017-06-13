package agreement.core.services;

import agreement.core.dto.ContractorDTO;
import agreement.core.entities.Contractor;

import java.util.List;

/**
 * Created by Radek on 12.06.2017.
 */
public interface ConractorService {

    ContractorDTO findById(Long id);

    List<ContractorDTO> findAll();

    ContractorDTO create(ContractorDTO contractorDTO);

    ContractorDTO update(ContractorDTO contractorDTO);

    void delete(Long id);

    ContractorDTO findByNip(String nip);

}
