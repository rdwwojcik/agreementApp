package agreement.core.entities;

import agreement.core.tools.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Radek on 21.03.2017.
 */
@Entity
public class Agreement {

    @Id
    @Column(name = "agreement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  description;
    @ManyToOne
    @JoinColumn(name = "idContractor")
    private Contractor idContractor;
    @OneToMany(mappedBy = "idAgreement")
    private List<AgreementFile> files;
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    dateFrom;
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    dateTo;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    modificationDate;

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

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date fateFrom) {
        this.dateFrom = fateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
