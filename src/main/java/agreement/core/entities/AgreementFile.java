package agreement.core.entities;

import javax.persistence.*;

/**
 * Created by Radek on 07.06.2017.
 */
@Entity
public class AgreementFile {

    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String name;
    private String description;
    private String fileName;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] file;
    @ManyToOne
    @JoinColumn(name = "idAgreement")
    private Agreement idAgreement;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Agreement getIdAgreement() {
        return idAgreement;
    }

    public void setIdAgreement(Agreement idAgreement) {
        this.idAgreement = idAgreement;
    }
}
