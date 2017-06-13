package agreement.core.dto;

import agreement.core.entities.Agreement;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by Radek on 07.06.2017.
 */
public class AgreementFileDTO {

    private Long id;
    @NotNull
    @Length(min = 5, max = 50, message = "Incorrect name length min:5, max:50")
    private String name;
    @NotNull
    private byte[] file;
    private String extension;
    @NotNull
    private Agreement agreement;

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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }
}
