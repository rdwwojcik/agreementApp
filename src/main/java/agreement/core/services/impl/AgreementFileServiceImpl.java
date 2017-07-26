package agreement.core.services.impl;

import agreement.core.dto.AgreementFileDTO;
import agreement.core.entities.AgreementFile;
import agreement.core.mapper.AgreementFileMapper;
import agreement.core.mapper.AgreementMapper;
import agreement.core.repositories.AgreementFileRepository;
import agreement.core.services.AgreementFileService;
import jdk.nashorn.internal.objects.NativeArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Radek on 25.07.2017.
 */
@Service
public class AgreementFileServiceImpl implements AgreementFileService {

    private final AgreementFileMapper mapper;

    private final AgreementFileRepository repository;

    @Autowired
    public AgreementFileServiceImpl(AgreementFileMapper mapper, AgreementFileRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public AgreementFileDTO addAgreementFile(AgreementFileDTO fileDTO) {
        return mapper.toDTO(repository.save(mapper.fromDTO(fileDTO)));
    }

    @Override
    public AgreementFileDTO updateAgreementFile(AgreementFileDTO fileDTO) {
        return mapper.toDTO(repository.save(mapper.fromDTO(fileDTO)));
    }

    @Override
    public AgreementFileDTO findById(Long id) {
        return mapper.toDTO(repository.findOne(id));
    }

    @Override
    public List<AgreementFileDTO> findAll() {

        List<AgreementFile> agreementFiles = (List<AgreementFile>) repository.findAll();

        return mapper.toDTO(agreementFiles);
    }
}
