package agreement.core.entities.enums;

/**
 * Created by Radek on 21.03.2017.
 */
public enum ContractorEnum {

    SSO(17787),
    KKB(17781),
    D2D(17790),
    SF(17785);

    private long id;

    ContractorEnum(long id){
        this.id = id;
    }

}
