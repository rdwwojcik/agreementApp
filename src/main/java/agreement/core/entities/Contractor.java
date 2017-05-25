package agreement.core.entities;

import agreement.core.tools.CustomDateSerializer;
import agreement.core.entities.enums.KontrahentEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Radek on 21.03.2017.
 */
@Entity
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    coId;
    private String  coName;
    @Enumerated(EnumType.ORDINAL)
    private KontrahentEnum coType;
    @OneToMany(mappedBy = "agIdContractor")
    private List<Agreement> agreements;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    coCreatedDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date    coModificationDate;

    public Long getCoId() {
        return coId;
    }

    public void setCoId(Long coId) {
        this.coId = coId;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public KontrahentEnum getCoType() {
        return coType;
    }

    public void setCoType(KontrahentEnum coType) {
        this.coType = coType;
    }

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(List<Agreement> agreements) {
        this.agreements = agreements;
    }

    public Date getCoCreatedDate() {
        return coCreatedDate;
    }

    public void setCoCreatedDate(Date coCreatedDate) {
        this.coCreatedDate = coCreatedDate;
    }

    public Date getCoModificationDate() {
        return coModificationDate;
    }

    public void setCoModificationDate(Date coModificationDate) {
        this.coModificationDate = coModificationDate;
    }
}
