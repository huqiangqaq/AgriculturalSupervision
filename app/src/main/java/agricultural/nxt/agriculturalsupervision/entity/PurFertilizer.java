package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/19 13:20.
 */

public class PurFertilizer {

    /**
     * pageNo : 1
     * pageSize : 20
     * count : 1
     * list : [{"id":"5573120cf0464d2e8133648fe33d965e","isNewRecord":false,"remarks":"采购尿素","createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-11-15 15:11:29","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2016-11-15 15:11:29","fponumber":"2","fprice":"2","vcunit":"袋","dtpodate":1479194669000,"poh":{"id":"20161115152448737","isNewRecord":false,"tMysupplierName":"小飞哥农产品生产企业","tmysupplierId":"f4b31e3acf784b718b771e222fff0d2a"},"fertilizer":{"id":"e128df0b829e4fd6874faadf87084b4a","isNewRecord":false,"vcfertilizename":"尿素123"},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpohId":"20161115152448737","tfertilizerId":"e128df0b829e4fd6874faadf87084b4a"}]
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');" onclick="this.select();"/> / <input type="text" value="20" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 1 条</a></li>
     </ul>
     <div style="clear:both;"></div>
     * firstResult : 0
     * maxResults : 20
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
         * id : 5573120cf0464d2e8133648fe33d965e
         * isNewRecord : false
         * remarks : 采购尿素
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false}
         * createDate : 2016-11-15 15:11:29
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false}
         * updateDate : 2016-11-15 15:11:29
         * fponumber : 2
         * fprice : 2
         * vcunit : 袋
         * dtpodate : 1479194669000
         * poh : {"id":"20161115152448737","isNewRecord":false,"tMysupplierName":"小飞哥农产品生产企业","tmysupplierId":"f4b31e3acf784b718b771e222fff0d2a"}
         * fertilizer : {"id":"e128df0b829e4fd6874faadf87084b4a","isNewRecord":false,"vcfertilizename":"尿素123"}
         * owner : {"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]}
         * tpohId : 20161115152448737
         * tfertilizerId : e128df0b829e4fd6874faadf87084b4a
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private UpdateByBean updateBy;
        private String updateDate;
        private String fponumber;
        private String fprice;
        private String vcunit;
        private long dtpodate;
        private PohBean poh;
        private FertilizerBean fertilizer;
        private OwnerBean owner;
        private String tpohId;
        private String tfertilizerId;

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

        public String getFponumber() {
            return fponumber;
        }

        public void setFponumber(String fponumber) {
            this.fponumber = fponumber;
        }

        public String getFprice() {
            return fprice;
        }

        public void setFprice(String fprice) {
            this.fprice = fprice;
        }

        public String getVcunit() {
            return vcunit;
        }

        public void setVcunit(String vcunit) {
            this.vcunit = vcunit;
        }

        public long getDtpodate() {
            return dtpodate;
        }

        public void setDtpodate(long dtpodate) {
            this.dtpodate = dtpodate;
        }

        public PohBean getPoh() {
            return poh;
        }

        public void setPoh(PohBean poh) {
            this.poh = poh;
        }

        public FertilizerBean getFertilizer() {
            return fertilizer;
        }

        public void setFertilizer(FertilizerBean fertilizer) {
            this.fertilizer = fertilizer;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public String getTpohId() {
            return tpohId;
        }

        public void setTpohId(String tpohId) {
            this.tpohId = tpohId;
        }

        public String getTfertilizerId() {
            return tfertilizerId;
        }

        public void setTfertilizerId(String tfertilizerId) {
            this.tfertilizerId = tfertilizerId;
        }

        public static class CreateByBean {
            /**
             * id : 刘建设
             * isNewRecord : false
             * loginFlag : 1
             * roleNames :
             * admin : false
             */

            private String id;
            private boolean isNewRecord;
            private String loginFlag;
            private String roleNames;
            private boolean admin;

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

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }

            public boolean isAdmin() {
                return admin;
            }

            public void setAdmin(boolean admin) {
                this.admin = admin;
            }
        }

        public static class UpdateByBean {
            /**
             * id : 刘建设
             * isNewRecord : false
             * loginFlag : 1
             * roleNames :
             * admin : false
             */

            private String id;
            private boolean isNewRecord;
            private String loginFlag;
            private String roleNames;
            private boolean admin;

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

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }

            public boolean isAdmin() {
                return admin;
            }

            public void setAdmin(boolean admin) {
                this.admin = admin;
            }
        }

        public static class PohBean {
            /**
             * id : 20161115152448737
             * isNewRecord : false
             * tMysupplierName : 小飞哥农产品生产企业
             * tmysupplierId : f4b31e3acf784b718b771e222fff0d2a
             */

            private String id;
            private boolean isNewRecord;
            private String tMysupplierName;
            private String tmysupplierId;

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

            public String getTMysupplierName() {
                return tMysupplierName;
            }

            public void setTMysupplierName(String tMysupplierName) {
                this.tMysupplierName = tMysupplierName;
            }

            public String getTmysupplierId() {
                return tmysupplierId;
            }

            public void setTmysupplierId(String tmysupplierId) {
                this.tmysupplierId = tmysupplierId;
            }
        }

        public static class FertilizerBean {
            /**
             * id : e128df0b829e4fd6874faadf87084b4a
             * isNewRecord : false
             * vcfertilizename : 尿素123
             */

            private String id;
            private boolean isNewRecord;
            private String vcfertilizename;

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

            public String getVcfertilizename() {
                return vcfertilizename;
            }

            public void setVcfertilizename(String vcfertilizename) {
                this.vcfertilizename = vcfertilizename;
            }
        }

        public static class OwnerBean {
            /**
             * isNewRecord : true
             * vcorgname : 省建设公司
             * ownerscopes :
             * ownerscopeTypes : [""]
             */

            private boolean isNewRecord;
            private String vcorgname;
            private String ownerscopes;
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

            public String getOwnerscopes() {
                return ownerscopes;
            }

            public void setOwnerscopes(String ownerscopes) {
                this.ownerscopes = ownerscopes;
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
