package agreement.core.entities;

import agreement.core.tools.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Radek on 21.03.2017.
 */
@Entity
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    agId;
    private String  agDescription;
    @ManyToOne
    @JoinColumn(name = "agIdContractor")
    private Contractor agIdContractor;
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    agDateFrom;
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    agDateTo;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    agCreatedDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    agModificationDate;

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

    public Date getAgCreatedDate() {
        return agCreatedDate;
    }

    public void setAgCreatedDate(Date agCreatedDate) {
        this.agCreatedDate = agCreatedDate;
    }

    public Date getAgModificationDate() {
        return agModificationDate;
    }

    public void setAgModificationDate(Date agModificationDate) {
        this.agModificationDate = agModificationDate;
    }
}
