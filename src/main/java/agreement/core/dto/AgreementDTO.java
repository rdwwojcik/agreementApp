package agreement.core.dto;

import agreement.core.entities.Contractor;
import agreement.core.tools.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Radek on 11.05.2017.
 */
public class AgreementDTO {

    private Long    agId;
    private String  agDescription;
    @NotNull
    private Contractor agIdContractor;
    @NotNull
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    agDateFrom;
    @NotNull
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    agDateTo;

    public Long getAgId() {
        return agId;
    }

    public void setAgId(Long agId) {
        this.agId = agId;
    }

    public String getAgDescription() {
        return agDescription;
    }

    public void setAgDescription(String agDescription) {
        this.agDescription = agDescription;
    }

    public Contractor getAgIdContractor() {
        return agIdContractor;
    }

    public void setAgIdContractor(Contractor agIdContractor) {
        this.agIdContractor = agIdContractor;
    }

    public Date getAgDateFrom() {
        return agDateFrom;
    }

    public void setAgDateFrom(Date agDateFrom) {
        this.agDateFrom = agDateFrom;
    }

    public Date getAgDateTo() {
        return agDateTo;
    }

    public void setAgDateTo(Date agDateTo) {
        this.agDateTo = agDateTo;
    }
}
