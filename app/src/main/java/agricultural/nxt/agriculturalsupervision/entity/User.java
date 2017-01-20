package agricultural.nxt.agriculturalsupervision.entity;

/**
 * Created by huqiang on 2017/1/20 13:45.
 */

public class User {


    /**
     * id : 124342ec97ae400ab942ecafca20547a
     * isNewRecord : false
     * remarks :
     * createBy : {"id":"-1","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
     * createDate : 2016-11-15 14:15:21
     * updateBy : {"id":"124342ec97ae400ab942ecafca20547a","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
     * updateDate : 2017-01-13 13:56:10
     * loginName : 刘建设
     * no : 000000
     * name : 刘建设
     * email : 839168655@qq.com
     * phone :
     * mobile : 187
     * userType : 3
     * loginIp : 171.34.77.124
     * loginDate : 2017-01-20 13:23:17
     * loginFlag : 1
     * photo :
     * oldLoginIp : 171.34.77.124
     * oldLoginDate : 2017-01-20 13:20:08
     * admin : false
     * roleNames : 农药经销商,化肥经销商,种子经销商
     */

    private String id;
    private boolean isNewRecord;
    private String remarks;
    private CreateByBean createBy;
    private String createDate;
    private UpdateByBean updateBy;
    private String updateDate;
    private String loginName;
    private String no;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String userType;
    private String loginIp;
    private String loginDate;
    private String loginFlag;
    private String photo;
    private String oldLoginIp;
    private String oldLoginDate;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOldLoginIp() {
        return oldLoginIp;
    }

    public void setOldLoginIp(String oldLoginIp) {
        this.oldLoginIp = oldLoginIp;
    }

    public String getOldLoginDate() {
        return oldLoginDate;
    }

    public void setOldLoginDate(String oldLoginDate) {
        this.oldLoginDate = oldLoginDate;
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

    public static class CreateByBean {
        /**
         * id : -1
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
         * id : 124342ec97ae400ab942ecafca20547a
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
}
