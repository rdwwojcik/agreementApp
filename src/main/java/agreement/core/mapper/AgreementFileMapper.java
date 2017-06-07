package agreement.core.mapper;

import agreement.core.dto.AgreementDTO;
import agreement.core.dto.AgreementFileDTO;
import agreement.core.entities.AgreementFile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Radek on 07.06.2017.
 */
@Mapper(componentModel = "spring")
public interface AgreementFileMapper {

    AgreementFileMapper INSTANCE = Mappers.getMapper(AgreementFileMapper.class);

    AgreementFileDTO toDTO(AgreementFile agreementFile);

    AgreementFile fromDTO(AgreementFileDTO fileDTO);

    List<AgreementFile> fromDTO(List<AgreementFileDTO> fileDTO);

    List<AgreementFileDTO> toDTO(List<AgreementFile> agreementFiles);
}
