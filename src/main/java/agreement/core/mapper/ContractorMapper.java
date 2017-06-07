package agreement.core.mapper;

import agreement.core.dto.ContractorDTO;
import agreement.core.entities.Contractor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Radek on 07.06.2017.
 */
@Mapper(componentModel = "spring")
public interface ContractorMapper  {

    ContractorMapper INSTANCE = Mappers.getMapper(ContractorMapper.class);

    ContractorDTO toDTO(Contractor contractor);

    Contractor fromDTO(ContractorDTO contractorDTO);

    List<ContractorDTO> toDTO(List<Contractor> contractors);

    List<Contractor> fromDTO(List<ContractorDTO> contractors);
}
