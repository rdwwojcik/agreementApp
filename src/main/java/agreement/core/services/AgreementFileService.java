package agreement.core.services;

import agreement.core.dto.AgreementFileDTO;
import agreement.core.entities.AgreementFile;

import java.util.List;

/**
 * Created by Radek on 25.07.2017.
 */
public interface AgreementFileService {

    AgreementFileDTO addAgreementFile(AgreementFileDTO fileDTO);

    AgreementFileDTO updateAgreementFile(AgreementFileDTO fileDTO);

    AgreementFileDTO findById(Long id);

    List<AgreementFileDTO> findAll();
}
