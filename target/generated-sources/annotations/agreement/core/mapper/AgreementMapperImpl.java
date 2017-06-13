package agreement.core.mapper;

import agreement.core.dto.AgreementDTO;
import agreement.core.entities.Agreement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-06-12T22:56:10+0200",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_60 (Oracle Corporation)"
)
@Component
public class AgreementMapperImpl implements AgreementMapper {

    @Override
    public Agreement fromDTO(AgreementDTO agreementDTO) {
        if ( agreementDTO == null ) {
            return null;
        }

        Agreement agreement = new Agreement();

        agreement.setId( agreementDTO.getId() );
        agreement.setDescription( agreementDTO.getDescription() );
        agreement.setIdContractor( agreementDTO.getIdContractor() );
        agreement.setDateFrom( agreementDTO.getDateFrom() );
        agreement.setDateTo( agreementDTO.getDateTo() );

        return agreement;
    }

    @Override
    public AgreementDTO toDTO(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        AgreementDTO agreementDTO = new AgreementDTO();

        agreementDTO.setId( agreement.getId() );
        agreementDTO.setDescription( agreement.getDescription() );
        agreementDTO.setIdContractor( agreement.getIdContractor() );
        agreementDTO.setDateFrom( agreement.getDateFrom() );
        agreementDTO.setDateTo( agreement.getDateTo() );

        return agreementDTO;
    }

    @Override
    public List<Agreement> fromDTO(List<AgreementDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Agreement> list = new ArrayList<Agreement>();
        for ( AgreementDTO agreementDTO : dtoList ) {
            list.add( fromDTO( agreementDTO ) );
        }

        return list;
    }

    @Override
    public List<AgreementDTO> toDTO(List<Agreement> agreements) {
        if ( agreements == null ) {
            return null;
        }

        List<AgreementDTO> list = new ArrayList<AgreementDTO>();
        for ( Agreement agreement : agreements ) {
            list.add( toDTO( agreement ) );
        }

        return list;
    }
}
