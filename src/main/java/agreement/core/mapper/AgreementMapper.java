package agreement.core.mapper;

import agreement.core.dto.AgreementDTO;
import agreement.core.entities.Agreement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Radek on 13.05.2017.
 */
@Mapper(componentModel = "spring")
public interface AgreementMapper {

    AgreementMapper INSTANCE = Mappers.getMapper(AgreementMapper.class);

    Agreement fromDTO(AgreementDTO agreementDTO);

    AgreementDTO toDTO(Agreement agreement);

    List<Agreement> fromDTO(List<AgreementDTO> dtoList);

    List<AgreementDTO> toDTO(List<Agreement> agreements);
}
