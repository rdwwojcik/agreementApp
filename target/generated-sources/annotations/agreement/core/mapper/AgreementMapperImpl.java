package agreement.core.mapper;

import agreement.core.dto.AgreementDTO;
import agreement.core.entities.Agreement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-05-29T21:55:44+0200",
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

        agreement.setAgId( agreementDTO.getAgId() );
        agreement.setAgDescription( agreementDTO.getAgDescription() );
        agreement.setAgIdContractor( agreementDTO.getAgIdContractor() );
        agreement.setAgDateFrom( agreementDTO.getAgDateFrom() );
        agreement.setAgDateTo( agreementDTO.getAgDateTo() );

        return agreement;
    }

    @Override
    public AgreementDTO toDTO(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        AgreementDTO agreementDTO = new AgreementDTO();

        agreementDTO.setAgId( agreement.getAgId() );
        agreementDTO.setAgDescription( agreement.getAgDescription() );
        agreementDTO.setAgIdContractor( agreement.getAgIdContractor() );
        agreementDTO.setAgDateFrom( agreement.getAgDateFrom() );
        agreementDTO.setAgDateTo( agreement.getAgDateTo() );

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
