package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/9 16:11.
 */

public class CompanyAdd {

    /**
     * msg : 获取企业详情成功!
     * data : {"id":"11e7482787794c8c9bda28e7e155f865","isNewRecord":false,"createBy":{"id":"fa79976cbf79492dba1901c0f721f17e","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-06 10:42:54","updateDate":"2017-01-06 10:42:54","area":{"id":"360111","isNewRecord":false,"name":"青山湖区","sort":30,"code":"360111","parentId":"0"},"vcorgname":"吹空调的企鹅","icheckstatus":"-2","ikind":"0","ownerscopeTypes":[""]}
     * success : true
     */

    private String msg;
    private DataBean data;
    private String success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * id : 11e7482787794c8c9bda28e7e155f865
         * isNewRecord : false
         * createBy : {"id":"fa79976cbf79492dba1901c0f721f17e","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2017-01-06 10:42:54
         * updateDate : 2017-01-06 10:42:54
         * area : {"id":"360111","isNewRecord":false,"name":"青山湖区","sort":30,"code":"360111","parentId":"0"}
         * vcorgname : 吹空调的企鹅
         * icheckstatus : -2
         * ikind : 0
         * ownerscopeTypes : [""]
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private AreaBean area;
        private String vcorgname;
        private String icheckstatus;
        private String ikind;
        private List<String> ownerscopeTypes;

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

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public AreaBean getArea() {
            return area;
        }

        public void setArea(AreaBean area) {
            this.area = area;
        }

        public String getVcorgname() {
            return vcorgname;
        }

        public void setVcorgname(String vcorgname) {
            this.vcorgname = vcorgname;
        }

        public String getIcheckstatus() {
            return icheckstatus;
        }

        public void setIcheckstatus(String icheckstatus) {
            this.icheckstatus = icheckstatus;
        }

        public String getIkind() {
            return ikind;
        }

        public void setIkind(String ikind) {
            this.ikind = ikind;
        }

        public List<String> getOwnerscopeTypes() {
            return ownerscopeTypes;
        }

        public void setOwnerscopeTypes(List<String> ownerscopeTypes) {
            this.ownerscopeTypes = ownerscopeTypes;
        }

        public static class CreateByBean {
            /**
             * id : fa79976cbf79492dba1901c0f721f17e
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

        public static class AreaBean {
            /**
             * id : 360111
             * isNewRecord : false
             * name : 青山湖区
             * sort : 30
             * code : 360111
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private String code;
            private String parentId;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }
        }
    }
}
