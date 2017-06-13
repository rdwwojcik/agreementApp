package agreement.core.dto;

import agreement.core.entities.AgreementFile;
import agreement.core.entities.Contractor;
import agreement.core.tools.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Radek on 11.05.2017.
 */
public class AgreementDTO {

    private Long    id;
    private String  description;
    @NotNull
    private Contractor idContractor;
    private List<AgreementFile> files;
    @NotNull
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    dateFrom;
    @NotNull
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    dateTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contractor getIdContractor() {
        return idContractor;
    }

    public void setIdContractor(Contractor idContractor) {
        this.idContractor = idContractor;
    }

    public List<AgreementFile> getFiles() {
        return files;
    }

    public void setFiles(List<AgreementFile> files) {
        this.files = files;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
