package agricultural.nxt.agriculturalsupervision.entity;

/**
 * Created by huqiang on 2017/1/11 11:05.
 */

public class PesticideLib {

    /**
     * isNewRecord : true
     * remarks :
     * createDate : 2016-10-31 15:42:42
     * updateDate : 2016-11-09 15:36:23
     * registrationNo : PD20110064
     * name : 滴丁·乙草胺
     * companyName : 辽宁三征化学有限公司
     * toxicity : 低毒
     * compositionAndContent : 2,4-滴丁酯 28%、乙草胺 50%
     * validity : 2016.01.11-2021.01.11
     * formulation : 乳油
     * registrationCropName : 春玉米田
     * preventObjectName : 一年生杂草
     * dosage : 2372.6-2565克/公顷
     * applicationMethod : 播后苗前土壤喷雾
     */

    private boolean isNewRecord;
    private String remarks;
    private String createDate;
    private String updateDate;
    private String registrationNo;
    private String name;
    private String companyName;
    private String toxicity;
    private String compositionAndContent;
    private String validity;
    private String formulation;
    private String registrationCropName;
    private String preventObjectName;
    private String dosage;
    private String applicationMethod;

    public boolean isIsNewRecord() {
        return isNewRecord;
    }

    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getToxicity() {
        return toxicity;
    }

    public void setToxicity(String toxicity) {
        this.toxicity = toxicity;
    }

    public String getCompositionAndContent() {
        return compositionAndContent;
    }

    public void setCompositionAndContent(String compositionAndContent) {
        this.compositionAndContent = compositionAndContent;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getRegistrationCropName() {
        return registrationCropName;
    }

    public void setRegistrationCropName(String registrationCropName) {
        this.registrationCropName = registrationCropName;
    }

    public String getPreventObjectName() {
        return preventObjectName;
    }

    public void setPreventObjectName(String preventObjectName) {
        this.preventObjectName = preventObjectName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getApplicationMethod() {
        return applicationMethod;
    }

    public void setApplicationMethod(String applicationMethod) {
        this.applicationMethod = applicationMethod;
    }
}
