package agreement.core.services;

import agreement.core.dto.AgreementFileDTO;
import agreement.core.entities.AgreementFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Radek on 25.07.2017.
 */
public interface AgreementFileService {

    AgreementFileDTO addAgreementFile(AgreementFileDTO fileDTO) throws IOException;

    AgreementFileDTO updateAgreementFile(AgreementFileDTO fileDTO) throws IOException;

    AgreementFileDTO findById(Long id);

//    List<AgreementFileDTO> findAll();
}
