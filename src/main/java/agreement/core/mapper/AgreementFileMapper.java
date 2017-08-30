package agreement.core.mapper;

import agreement.core.dto.AgreementDTO;
import agreement.core.dto.AgreementFileDTO;
import agreement.core.entities.AgreementFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.List;

/**
 * Created by Radek on 07.06.2017.
 */
@Mapper(componentModel = "spring")
public interface AgreementFileMapper {

    AgreementFileMapper INSTANCE = Mappers.getMapper(AgreementFileMapper.class);

    @Mapping(target = "file", expression = "java(agreement.core.mapper.utils.AgreementFileMapperUtil.convertByteToMf(agreementFile))")
    AgreementFileDTO toDTO(AgreementFile agreementFile);

    @Mappings({
        @Mapping(target = "file", expression = "java(fileDTO.getFile().getBytes())"),
        @Mapping(target = "fileName", expression = "java(fileDTO.getFile().getOriginalFilename())")
    })
    AgreementFile fromDTO(AgreementFileDTO fileDTO) throws IOException;

//    List<AgreementFile> fromDTO(List<AgreementFileDTO> fileDTO);

//    List<AgreementFileDTO> toDTO(List<AgreementFile> agreementFiles);
}
