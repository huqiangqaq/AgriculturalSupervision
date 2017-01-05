package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/4 10:24.
 */

public class PesticideDetail {

    /**
     * id : 1ae7c086dde444afa95f5d1dd8572276
     * isNewRecord : false
     * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
     * createDate : 2017-01-04 10:07:33
     * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
     * updateDate : 2017-01-04 10:07:33
     * vcpesticidename : 2甲4氯钠
     * vcnetcontent : 50
     * vcproductunit : 山东省济南绿邦化工有限公司
     * vcdescription : 2甲4氯钠 56%
     * vcgrantno : PD20110001
     * vcplaceoforigin : 南昌
     * vcinstructions : 茎叶喷雾
     * vcstandards : 1008-1260克/公顷
     * vcbrand : 胡强
     * vcspec : 161516
     * vcuniquecode : 11561561
     * icheckstatus : -1
     * owner : {"isNewRecord":true,"vcorgname":"省建设公司","ownerscopeTypes":[""]}
     */

    private String id;
    private boolean isNewRecord;
    private CreateByBean createBy;
    private String createDate;
    private UpdateByBean updateBy;
    private String updateDate;
    private String vcpesticidename;
    private String vcnetcontent;
    private String vcproductunit;
    private String vcdescription;
    private String vcgrantno;
    private String vcplaceoforigin;
    private String vcinstructions;
    private String vcstandards;
    private String vcbrand;
    private String vcspec;
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

    public String getVcpesticidename() {
        return vcpesticidename;
    }

    public void setVcpesticidename(String vcpesticidename) {
        this.vcpesticidename = vcpesticidename;
    }

    public String getVcnetcontent() {
        return vcnetcontent;
    }

    public void setVcnetcontent(String vcnetcontent) {
        this.vcnetcontent = vcnetcontent;
    }

    public String getVcproductunit() {
        return vcproductunit;
    }

    public void setVcproductunit(String vcproductunit) {
        this.vcproductunit = vcproductunit;
    }

    public String getVcdescription() {
        return vcdescription;
    }

    public void setVcdescription(String vcdescription) {
        this.vcdescription = vcdescription;
    }

    public String getVcgrantno() {
        return vcgrantno;
    }

    public void setVcgrantno(String vcgrantno) {
        this.vcgrantno = vcgrantno;
    }

    public String getVcplaceoforigin() {
        return vcplaceoforigin;
    }

    public void setVcplaceoforigin(String vcplaceoforigin) {
        this.vcplaceoforigin = vcplaceoforigin;
    }

    public String getVcinstructions() {
        return vcinstructions;
    }

    public void setVcinstructions(String vcinstructions) {
        this.vcinstructions = vcinstructions;
    }

    public String getVcstandards() {
        return vcstandards;
    }

    public void setVcstandards(String vcstandards) {
        this.vcstandards = vcstandards;
    }

    public String getVcbrand() {
        return vcbrand;
    }

    public void setVcbrand(String vcbrand) {
        this.vcbrand = vcbrand;
    }

    public String getVcspec() {
        return vcspec;
    }

    public void setVcspec(String vcspec) {
        this.vcspec = vcspec;
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
