package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2016/12/20 15:12.
 */

public class RecodeReturn {


    /**
     * pageNo : 1
     * pageSize : 10
     * count : 24
     * list : [{"id":"822730dbd5c94081b36ec64f83336799","isNewRecord":false,"createDate":"2016-12-05 13:39:18","updateDate":"2016-12-05 13:38:25","vcvarietyname":"浚单18","vccategory":"玉米种子","btransgene":"0","vccheckerno":"江夏区农业局","dtcheckdate":"2016-12-05 13:39:18","owner":{"isNewRecord":true,"vcorgname":"惠农","ownerscopeTypes":[""]}}]
     * html :
     * maxResults : 10
     */

    private int pageNo;
    private int pageSize;
    private int count;
    private String html;
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
         * id : 822730dbd5c94081b36ec64f83336799
         * isNewRecord : false
         * createDate : 2016-12-05 13:39:18
         * updateDate : 2016-12-05 13:38:25
         * vcvarietyname : 浚单18
         * vccategory : 玉米种子
         * btransgene : 0
         * vccheckerno : 江夏区农业局
         * dtcheckdate : 2016-12-05 13:39:18
         * owner : {"isNewRecord":true,"vcorgname":"惠农","ownerscopeTypes":[""]}
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String vcvarietyname;
        private String vccategory;
        private String btransgene;
        private String vccheckerno;
        private String dtcheckdate;
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

        public String getBtransgene() {
            return btransgene;
        }

        public void setBtransgene(String btransgene) {
            this.btransgene = btransgene;
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

        public static class OwnerBean {
            /**
             * isNewRecord : true
             * vcorgname : 惠农
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
