package agreement.core.services.impl;

import agreement.core.dto.ContractorDTO;
import agreement.core.entities.Contractor;
import agreement.core.exceptions.ContractorRegistrationException;
import agreement.core.mapper.ContractorMapper;
import agreement.core.repositories.ContractorRepository;
import agreement.core.services.ConractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Radek on 12.06.2017.
 */
@Service
public class ContractorServiceImpl implements ConractorService {

    private ContractorRepository contractorRepository;
    private ContractorMapper     contractorMapper;

    @Autowired
    public ContractorServiceImpl(ContractorRepository contractorRepository, ContractorMapper contractorMapper) {
        this.contractorRepository = contractorRepository;
        this.contractorMapper = contractorMapper;
    }

    @Override
    public ContractorDTO findById(Long id) {

        Contractor contractor = contractorRepository.findOne(id);
        if(contractor == null){
            throw new ContractorRegistrationException(ContractorRegistrationException.FailReason.CONTRACTOR_NOT_FOUND);
        }
        return contractorMapper.toDTO(contractor);
    }

    @Override
    public List<ContractorDTO> findAll() {
        return contractorMapper.toDTO((List<Contractor>) contractorRepository.findAll());
    }

    @Override
    public ContractorDTO create(ContractorDTO contractorDTO) {

        ContractorDTO existContractor = findByNip(contractorDTO.getNip());

        if(existContractor != null){
            throw new ContractorRegistrationException(ContractorRegistrationException.FailReason.CONTRACTOR_ALREADY_EXIST);
        }

        Contractor contractor = contractorMapper.fromDTO(contractorDTO);
        contractor.setCreatedDate(new Date());
        contractor.setModificationDate(new Date());

        return contractorMapper.toDTO(contractorRepository.save(contractor));
    }

    @Override
    public ContractorDTO update(ContractorDTO contractorDTO) {

        Contractor contractor;
        if(contractorRepository.findOne(contractorDTO.getId()) != null){
            contractor = contractorMapper.fromDTO(contractorDTO);
            contractor.setModificationDate(new Date());
            contractor = contractorRepository.save(contractor);
        }
        else{
            throw new ContractorRegistrationException(ContractorRegistrationException.FailReason.CONTRACTOR_NOT_FOUND);
        }

        return contractorMapper.toDTO(contractor);
    }

    @Override
    public void delete(Long id) {
        contractorRepository.delete(id);
    }

    @Override
    public ContractorDTO findByNip(String nip) {
        return contractorMapper.toDTO(contractorRepository.findByNip(nip));
    }
}
