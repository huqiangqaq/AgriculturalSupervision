package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/4 13:40.
 */

public class Fertilizer {

    /**
     * pageNo : 1
     * pageSize : 10
     * count : 1
     * list : [{"id":"e128df0b829e4fd6874faadf87084b4a","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-15 14:52:18","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-15 14:52:18","vcfertilizename":"尿素","vcnetcontent":"50kg","vcproductunit":"江西南昌有限公司","vcdescription":"尿素化肥","vcgrantno":"ns123456789","vcplaceoforigin":"江西南昌","vcinstructions":"安全使用","vcstandards":"亩/10kg","vcbrand":"肥达","vcuniquecode":"ns20161115150512012","icheckstatus":"1","vccheckerno":"系统管理员","dtcheckdate":"2016-11-15 14:53:08","owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopeTypes":[""]}}]
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,10,'');" onclick="this.select();"/> / <input type="text" value="10" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 1 条</a></li>
     </ul>
     <div style="clear:both;"></div>
     * firstResult : 0
     * maxResults : 10
     */

    private int pageNo;
    private int pageSize;
    private int count;
    private String html;
    private int firstResult;
    private int maxResults;
    private List<ListBean> list;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : e128df0b829e4fd6874faadf87084b4a
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2016-11-15 14:52:18
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2016-11-15 14:52:18
         * vcfertilizename : 尿素
         * vcnetcontent : 50kg
         * vcproductunit : 江西南昌有限公司
         * vcdescription : 尿素化肥
         * vcgrantno : ns123456789
         * vcplaceoforigin : 江西南昌
         * vcinstructions : 安全使用
         * vcstandards : 亩/10kg
         * vcbrand : 肥达
         * vcuniquecode : ns20161115150512012
         * icheckstatus : 1
         * vccheckerno : 系统管理员
         * dtcheckdate : 2016-11-15 14:53:08
         * owner : {"isNewRecord":true,"vcorgname":"省建设公司","ownerscopeTypes":[""]}
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private UpdateByBean updateBy;
        private String updateDate;
        private String vcfertilizename;
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
        private String vccheckerno;
        private String dtcheckdate;
        private OwnerBean owner;

        public String getVcspec() {
            return vcspec;
        }

        public void setVcspec(String vcspec) {
            this.vcspec = vcspec;
        }

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

        public String getVcfertilizename() {
            return vcfertilizename;
        }

        public void setVcfertilizename(String vcfertilizename) {
            this.vcfertilizename = vcfertilizename;
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

        public String getVccheckerno() {
            return vccheckerno;
        }

        public void setVccheckerno(String vccheckerno) {
            this.vccheckerno = vccheckerno;
        }

        public String getDtcheckdate() {
            return dtcheckdate;
        }

        public void setDtcheckdate(String dtcheckdate) {
            this.dtcheckdate = dtcheckdate;
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
}
