package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/9 10:49.
 */

public class Company {

    /**
     * data : {"id":"71d53e9e3ec94472a1dd427c01c0a2b1","isNewRecord":false,"remarks":"无","createDate":"2016-11-19 14:12:11","updateDate":"2016-11-19 14:26:13","area":{"id":"360102","isNewRecord":false,"name":"东湖区","sort":30,"code":"360102","parentId":"0"},"vcorgname":"省建设公司","vccorporation":"刘建设","vcphone":"21452012013","vcaddress":"江西省南昌市东湖区上营坊街61弄-27号","vcbizlicense":"js2016","vcbizlicedate":"2021-08-16 14:17:33","vcbizlicepic":"","vcproductlicense":"201611151417","dtprodlicendate":"2020-11-24   14:18:00","vcprodlicenpic":"","icheckstatus":"1","vccheckerno":"1","vcemail":"liujianshe888@163.com","vcgpsx":"115.907","fgpsy":"28.6858","ikind":"1","vcidnumber":"235125642150213542","ownerscopeList":[{"id":"7bdc775b408a4ed08ae8cfbf135aba86","isNewRecord":false,"createDate":"2016-11-19 14:12:11","updateDate":"2016-11-19 14:26:13","ownerId":"71d53e9e3ec94472a1dd427c01c0a2b1","itype":"0"},{"id":"8c805ecfce9a4147a72ddd03af94f580","isNewRecord":false,"createDate":"2016-11-19 14:12:11","updateDate":"2016-11-19 14:26:13","ownerId":"71d53e9e3ec94472a1dd427c01c0a2b1","itype":"2"},{"id":"fcd593f08c8241928059741c85988214","isNewRecord":false,"createDate":"2016-11-19 14:12:11","updateDate":"2016-11-19 14:26:13","ownerId":"71d53e9e3ec94472a1dd427c01c0a2b1","itype":"1"}],"vccheckerName":"系统管理员","ownerscopeTypes":["0","2","1"]}
     * msg : 获取企业详情成功!
     * success : true
     */

    private DataBean data;
    private String msg;
    private String success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * id : 71d53e9e3ec94472a1dd427c01c0a2b1
         * isNewRecord : false
         * remarks : 无
         * createDate : 2016-11-19 14:12:11
         * updateDate : 2016-11-19 14:26:13
         * area : {"id":"360102","isNewRecord":false,"name":"东湖区","sort":30,"code":"360102","parentId":"0"}
         * vcorgname : 省建设公司
         * vccorporation : 刘建设
         * vcphone : 21452012013
         * vcaddress : 江西省南昌市东湖区上营坊街61弄-27号
         * vcbizlicense : js2016
         * vcbizlicedate : 2021-08-16 14:17:33
         * vcbizlicepic :
         * vcproductlicense : 201611151417
         * dtprodlicendate : 2020-11-24   14:18:00
         * vcprodlicenpic :
         * icheckstatus : 1
         * vccheckerno : 1
         * vcemail : liujianshe888@163.com
         * vcgpsx : 115.907
         * fgpsy : 28.6858
         * ikind : 1
         * vcidnumber : 235125642150213542
         * ownerscopeList : [{"id":"7bdc775b408a4ed08ae8cfbf135aba86","isNewRecord":false,"createDate":"2016-11-19 14:12:11","updateDate":"2016-11-19 14:26:13","ownerId":"71d53e9e3ec94472a1dd427c01c0a2b1","itype":"0"},{"id":"8c805ecfce9a4147a72ddd03af94f580","isNewRecord":false,"createDate":"2016-11-19 14:12:11","updateDate":"2016-11-19 14:26:13","ownerId":"71d53e9e3ec94472a1dd427c01c0a2b1","itype":"2"},{"id":"fcd593f08c8241928059741c85988214","isNewRecord":false,"createDate":"2016-11-19 14:12:11","updateDate":"2016-11-19 14:26:13","ownerId":"71d53e9e3ec94472a1dd427c01c0a2b1","itype":"1"}]
         * vccheckerName : 系统管理员
         * ownerscopeTypes : ["0","2","1"]
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private AreaBean area;
        private String vcorgname;
        private String vccorporation;
        private String vcphone;
        private String vcaddress;
        private String vcbizlicense;
        private String vcbizlicedate;
        private String vcbizlicepic;
        private String vcproductlicense;
        private String dtprodlicendate;
        private String vcprodlicenpic;
        private String icheckstatus;
        private String vccheckerno;
        private String vcemail;
        private String vcgpsx;
        private String fgpsy;
        private String ikind;
        private String vcidnumber;
        private String vccheckerName;
        private String dtcheckdate;
        private List<OwnerscopeListBean> ownerscopeList;
        private List<String> ownerscopeTypes;

        public String getDtcheckdate() {
            return dtcheckdate;
        }

        public void setDtcheckdate(String dtcheckdate) {
            this.dtcheckdate = dtcheckdate;
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

        public String getVccorporation() {
            return vccorporation;
        }

        public void setVccorporation(String vccorporation) {
            this.vccorporation = vccorporation;
        }

        public String getVcphone() {
            return vcphone;
        }

        public void setVcphone(String vcphone) {
            this.vcphone = vcphone;
        }

        public String getVcaddress() {
            return vcaddress;
        }

        public void setVcaddress(String vcaddress) {
            this.vcaddress = vcaddress;
        }

        public String getVcbizlicense() {
            return vcbizlicense;
        }

        public void setVcbizlicense(String vcbizlicense) {
            this.vcbizlicense = vcbizlicense;
        }

        public String getVcbizlicedate() {
            return vcbizlicedate;
        }

        public void setVcbizlicedate(String vcbizlicedate) {
            this.vcbizlicedate = vcbizlicedate;
        }

        public String getVcbizlicepic() {
            return vcbizlicepic;
        }

        public void setVcbizlicepic(String vcbizlicepic) {
            this.vcbizlicepic = vcbizlicepic;
        }

        public String getVcproductlicense() {
            return vcproductlicense;
        }

        public void setVcproductlicense(String vcproductlicense) {
            this.vcproductlicense = vcproductlicense;
        }

        public String getDtprodlicendate() {
            return dtprodlicendate;
        }

        public void setDtprodlicendate(String dtprodlicendate) {
            this.dtprodlicendate = dtprodlicendate;
        }

        public String getVcprodlicenpic() {
            return vcprodlicenpic;
        }

        public void setVcprodlicenpic(String vcprodlicenpic) {
            this.vcprodlicenpic = vcprodlicenpic;
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

        public String getVcemail() {
            return vcemail;
        }

        public void setVcemail(String vcemail) {
            this.vcemail = vcemail;
        }

        public String getVcgpsx() {
            return vcgpsx;
        }

        public void setVcgpsx(String vcgpsx) {
            this.vcgpsx = vcgpsx;
        }

        public String getFgpsy() {
            return fgpsy;
        }

        public void setFgpsy(String fgpsy) {
            this.fgpsy = fgpsy;
        }

        public String getIkind() {
            return ikind;
        }

        public void setIkind(String ikind) {
            this.ikind = ikind;
        }

        public String getVcidnumber() {
            return vcidnumber;
        }

        public void setVcidnumber(String vcidnumber) {
            this.vcidnumber = vcidnumber;
        }

        public String getVccheckerName() {
            return vccheckerName;
        }

        public void setVccheckerName(String vccheckerName) {
            this.vccheckerName = vccheckerName;
        }

        public List<OwnerscopeListBean> getOwnerscopeList() {
            return ownerscopeList;
        }

        public void setOwnerscopeList(List<OwnerscopeListBean> ownerscopeList) {
            this.ownerscopeList = ownerscopeList;
        }

        public List<String> getOwnerscopeTypes() {
            return ownerscopeTypes;
        }

        public void setOwnerscopeTypes(List<String> ownerscopeTypes) {
            this.ownerscopeTypes = ownerscopeTypes;
        }

        public static class AreaBean {
            /**
             * id : 360102
             * isNewRecord : false
             * name : 东湖区
             * sort : 30
             * code : 360102
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

        public static class OwnerscopeListBean {
            /**
             * id : 7bdc775b408a4ed08ae8cfbf135aba86
             * isNewRecord : false
             * createDate : 2016-11-19 14:12:11
             * updateDate : 2016-11-19 14:26:13
             * ownerId : 71d53e9e3ec94472a1dd427c01c0a2b1
             * itype : 0
             */

            private String id;
            private boolean isNewRecord;
            private String createDate;
            private String updateDate;
            private String ownerId;
            private String itype;

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

            public String getOwnerId() {
                return ownerId;
            }

            public void setOwnerId(String ownerId) {
                this.ownerId = ownerId;
            }

            public String getItype() {
                return itype;
            }

            public void setItype(String itype) {
                this.itype = itype;
            }
        }
    }
}
