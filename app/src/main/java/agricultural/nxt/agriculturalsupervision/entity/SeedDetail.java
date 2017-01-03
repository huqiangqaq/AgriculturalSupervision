package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/3 10:25.
 */

public class SeedDetail {

    /**
     * id : 08e95658080742b5a1f579f2223b6825
     * isNewRecord : false
     * remarks : 二季水稻
     * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
     * createDate : 2016-12-19 16:55:45
     * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
     * updateDate : 2016-12-19 16:55:45
     * vcvarietyname : 晚稻种子
     * vccategory : 水稻
     * vcproductionunit : 南昌水稻生产有限公司
     * vcbusinesslicense : 赣A-SD2016
     * vcquarantineno : JY-jxnc2016
     * btransgene : 0
     * vcappraisal : 好评
     * vcuniquecode : sd20161219145421420
     * icheckstatus : -1
     * owner : {"isNewRecord":true,"vcorgname":"省建设公司","ownerscopeTypes":[""]}
     */

    private String id;
    private boolean isNewRecord;
    private String remarks;
    private CreateByBean createBy;
    private String createDate;
    private UpdateByBean updateBy;
    private String updateDate;
    private String vcvarietyname;
    private String vccategory;
    private String vcproductionunit;
    private String vcbusinesslicense;
    private String vcquarantineno;
    private String btransgene;
    private String vcappraisal;
    private String vcuniquecode;
    private String icheckstatus;
    private OwnerBean owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public CreateByBean getCreateBy() {
        return createBy;
    }

    public void setCreateBy(CreateByBean createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public UpdateByBean getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(UpdateByBean updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getVcvarietyname() {
        return vcvarietyname;
    }

    public void setVcvarietyname(String vcvarietyname) {
        this.vcvarietyname = vcvarietyname;
    }

    public String getVccategory() {
        return vccategory;
    }

    public void setVccategory(String vccategory) {
        this.vccategory = vccategory;
    }

    public String getVcproductionunit() {
        return vcproductionunit;
    }

    public void setVcproductionunit(String vcproductionunit) {
        this.vcproductionunit = vcproductionunit;
    }

    public String getVcbusinesslicense() {
        return vcbusinesslicense;
    }

    public void setVcbusinesslicense(String vcbusinesslicense) {
        this.vcbusinesslicense = vcbusinesslicense;
    }

    public String getVcquarantineno() {
        return vcquarantineno;
    }

    public void setVcquarantineno(String vcquarantineno) {
        this.vcquarantineno = vcquarantineno;
    }

    public String getBtransgene() {
        return btransgene;
    }

    public void setBtransgene(String btransgene) {
        this.btransgene = btransgene;
    }

    public String getVcappraisal() {
        return vcappraisal;
    }

    public void setVcappraisal(String vcappraisal) {
        this.vcappraisal = vcappraisal;
    }

    public String getVcuniquecode() {
        return vcuniquecode;
    }

    public void setVcuniquecode(String vcuniquecode) {
        this.vcuniquecode = vcuniquecode;
    }

    public String getIcheckstatus() {
        return icheckstatus;
    }

    public void setIcheckstatus(String icheckstatus) {
        this.icheckstatus = icheckstatus;
    }

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public static class CreateByBean {
        /**
         * id : 刘建设
         * isNewRecord : false
         * loginFlag : 1
         * admin : false
         * roleNames :
         */

        private String id;
        private boolean isNewRecord;
        private String loginFlag;
        private boolean admin;
        private String roleNames;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(String roleNames) {
            this.roleNames = roleNames;
        }
    }

    public static class UpdateByBean {
        /**
         * id : 刘建设
         * isNewRecord : false
         * loginFlag : 1
         * admin : false
         * roleNames :
         */

        private String id;
        private boolean isNewRecord;
        private String loginFlag;
        private boolean admin;
        private String roleNames;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(String roleNames) {
            this.roleNames = roleNames;
        }
    }

    public static class OwnerBean {
        /**
         * isNewRecord : true
         * vcorgname : 省建设公司
         * ownerscopeTypes : [""]
         */

        private boolean isNewRecord;
        private String vcorgname;
        private List<String> ownerscopeTypes;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getVcorgname() {
            return vcorgname;
        }

        public void setVcorgname(String vcorgname) {
            this.vcorgname = vcorgname;
        }

        public List<String> getOwnerscopeTypes() {
            return ownerscopeTypes;
        }

        public void setOwnerscopeTypes(List<String> ownerscopeTypes) {
            this.ownerscopeTypes = ownerscopeTypes;
        }
    }
}
