package agreement.core.dto;

import agreement.core.entities.enums.ContractorEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Radek on 07.06.2017.
 */
public class ContractorDTO {

    private Long   id;
    @NotNull
    @Length(min = 5, max = 50, message = "Incorrect name length min: 5, max: 50")
    private String name;
    @NotNull
    private ContractorEnum type;
    private List<AgreementDTO> agreements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContractorEnum getType() {
        return type;
    }

    public void setType(ContractorEnum type) {
        this.type = type;
    }

    public List<AgreementDTO> getAgreements() {
        return agreements;
    }

    public void setAgreements(List<AgreementDTO> agreements) {
        this.agreements = agreements;
    }
}
