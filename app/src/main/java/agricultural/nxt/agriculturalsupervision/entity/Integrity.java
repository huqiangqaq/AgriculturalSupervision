package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2016/12/27 10:57.
 */

public class Integrity {


    /**
     * pageNo : 1
     * pageSize : 30
     * count : 5
     * list : [{"id":"d99fdbd33db64be288e5b48dd1abf92c","isNewRecord":false,"createDate":"2016-12-26 13:40:36","updateDate":"2016-12-26 13:55:40","ownerId":"104edbd9497346c096062e476ee3da7e","dtarosedate":"2016-12-09 00:00:00","vcillegalcomp":"水稻种子公司","vcillegalprod":"0001号晚稻种子","vcdesc":"种子不发芽","vcpunishment":"回收问题产品","iproducttype":"0","vccheckno":"bb89eca4f4324460bc1ca9911a889489","dtcheckdate":"2016-12-26 13:55:31","icheckstatus":"1","ownerName":"5y"},{"id":"9001976534164ef49745777ce585b083","isNewRecord":false,"createDate":"2016-11-12 15:15:14","updateDate":"2016-11-12 15:15:14","ownerId":"1","dtarosedate":"2016-11-12 15:13:35","vcillegalcomp":"XXX农资店","vcillegalprod":"优品01","vcdesc":"在该店购买的种子有50%的都无法长出小麦","iproducttype":"0","icheckstatus":"-1","remarks2":"","ownerName":"山东省总公司"},{"id":"40ef6a2b1ac54abc9b7952c8257c3f2d","isNewRecord":false,"createDate":"2016-11-11 17:03:35","updateDate":"2016-11-11 17:03:35","ownerId":"0e60792375fd441eb58045729e40980c","dtarosedate":"2016-11-11 17:03:31","vcillegalcomp":"江西农药公司","vcillegalprod":"农药001","vcdesc":"没有成分描述","iproducttype":"2","icheckstatus":"-1","remarks2":"","ownerName":"农信通江西分公司006"},{"id":"e208dbed83534912a4e282e6f6173ca2","isNewRecord":false,"createDate":"2016-10-28 14:57:44","updateDate":"2016-10-28 15:11:56","ownerId":"993120394d3b4356a523c38929e0b957","dtarosedate":"2016-10-28 14:21:34","vcillegalcomp":"***种子有限公司","vcillegalprod":"大豆种子001","vcdesc":"大豆种子001发芽率低，与描述不符","vcpunishment":"","iproducttype":"0","vccheckno":"5abb26600250463ebd0e574ed7a9cc41","dtcheckdate":"2016-10-28 15:11:12","icheckstatus":"1","remarks2":"","ownerName":"江西农信通二"},{"id":"fe45cd15731142d2b8cdd5c754caa51d","isNewRecord":false,"createDate":"2016-10-28 13:48:58","updateDate":"2016-10-28 13:48:58","ownerId":"c7bc66d864934b51b71d36e57a8ef05e","dtarosedate":"2016-10-28 13:47:29","vcillegalcomp":"***化肥有限公司","vcillegalprod":"化肥001","vcdesc":"化肥001缺少成分描述","vcpunishment":"化肥001 添加成份描述","iproducttype":"1","vccheckno":"5abb26600250463ebd0e574ed7a9cc41","dtcheckdate":"2016-10-28 13:47:27","icheckstatus":"1","remarks2":"","ownerName":"南昌市政府管理部门"}]
     * maxResults : 30
     * firstResult : 0
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,30,'');" onclick="this.select();"/> / <input type="text" value="30" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 5 条</a></li>
     </ul>
     <div style="clear:both;"></div>
     */

    private int pageNo;
    private int pageSize;
    private int count;
    private int maxResults;
    private int firstResult;
    private String html;
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

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : d99fdbd33db64be288e5b48dd1abf92c
         * isNewRecord : false
         * createDate : 2016-12-26 13:40:36
         * updateDate : 2016-12-26 13:55:40
         * ownerId : 104edbd9497346c096062e476ee3da7e
         * dtarosedate : 2016-12-09 00:00:00
         * vcillegalcomp : 水稻种子公司
         * vcillegalprod : 0001号晚稻种子
         * vcdesc : 种子不发芽
         * vcpunishment : 回收问题产品
         * iproducttype : 0
         * vccheckno : bb89eca4f4324460bc1ca9911a889489
         * dtcheckdate : 2016-12-26 13:55:31
         * icheckstatus : 1
         * ownerName : 5y
         * remarks2 :
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String ownerId;
        private String dtarosedate;
        private String vcillegalcomp;
        private String vcillegalprod;
        private String vcdesc;
        private String vcpunishment;
        private String iproducttype;
        private String vccheckno;
        private String dtcheckdate;
        private String icheckstatus;
        private String ownerName;
        private String remarks2;

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

        public String getDtarosedate() {
            return dtarosedate;
        }

        public void setDtarosedate(String dtarosedate) {
            this.dtarosedate = dtarosedate;
        }

        public String getVcillegalcomp() {
            return vcillegalcomp;
        }

        public void setVcillegalcomp(String vcillegalcomp) {
            this.vcillegalcomp = vcillegalcomp;
        }

        public String getVcillegalprod() {
            return vcillegalprod;
        }

        public void setVcillegalprod(String vcillegalprod) {
            this.vcillegalprod = vcillegalprod;
        }

        public String getVcdesc() {
            return vcdesc;
        }

        public void setVcdesc(String vcdesc) {
            this.vcdesc = vcdesc;
        }

        public String getVcpunishment() {
            return vcpunishment;
        }

        public void setVcpunishment(String vcpunishment) {
            this.vcpunishment = vcpunishment;
        }

        public String getIproducttype() {
            return iproducttype;
        }

        public void setIproducttype(String iproducttype) {
            this.iproducttype = iproducttype;
        }

        public String getVccheckno() {
            return vccheckno;
        }

        public void setVccheckno(String vccheckno) {
            this.vccheckno = vccheckno;
        }

        public String getDtcheckdate() {
            return dtcheckdate;
        }

        public void setDtcheckdate(String dtcheckdate) {
            this.dtcheckdate = dtcheckdate;
        }

        public String getIcheckstatus() {
            return icheckstatus;
        }

        public void setIcheckstatus(String icheckstatus) {
            this.icheckstatus = icheckstatus;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getRemarks2() {
            return remarks2;
        }

        public void setRemarks2(String remarks2) {
            this.remarks2 = remarks2;
        }
    }
}
