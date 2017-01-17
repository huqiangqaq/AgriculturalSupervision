package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/17 9:46.
 */

public class Announce {

    /**
     * pageNo : 1
     * pageSize : 30
     * count : 1
     * list : [{"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"createDate":"2017-01-17 09:02:44","updateBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2017-01-17 09:02:44","vctitle":"嘎嘎","vccontent":"噶我噶哇嘎嘎","ilevel":"0","iorder":"0","dtcloseddate":"2017-01-17 09:02:41","ijuniorvisit":"0","iactiveflag":"1","readFlag":"0","self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""}]
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,30,'');" onclick="this.select();"/> / <input type="text" value="30" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 1 条</a></li>
     </ul>
     <div style="clear:both;"></div>
     * firstResult : 0
     * maxResults : 30
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
         * id : d2edd04a1be1483ca4ddbe2892c08ac4
         * isNewRecord : false
         * remarks :
         * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""}
         * createDate : 2017-01-17 09:02:44
         * updateBy : {"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""}
         * updateDate : 2017-01-17 09:02:44
         * vctitle : 嘎嘎
         * vccontent : 噶我噶哇嘎嘎
         * ilevel : 0
         * iorder : 0
         * dtcloseddate : 2017-01-17 09:02:41
         * ijuniorvisit : 0
         * iactiveflag : 1
         * readFlag : 0
         * self : false
         * noticevistorIds :
         * noticevistorNames :
         * noticevistcompIds :
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private UpdateByBean updateBy;
        private String updateDate;
        private String vctitle;
        private String vccontent;
        private String ilevel;
        private String iorder;
        private String dtcloseddate;
        private String ijuniorvisit;
        private String iactiveflag;
        private String readFlag;
        private boolean self;
        private String noticevistorIds;
        private String noticevistorNames;
        private String noticevistcompIds;

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

        public String getVctitle() {
            return vctitle;
        }

        public void setVctitle(String vctitle) {
            this.vctitle = vctitle;
        }

        public String getVccontent() {
            return vccontent;
        }

        public void setVccontent(String vccontent) {
            this.vccontent = vccontent;
        }

        public String getIlevel() {
            return ilevel;
        }

        public void setIlevel(String ilevel) {
            this.ilevel = ilevel;
        }

        public String getIorder() {
            return iorder;
        }

        public void setIorder(String iorder) {
            this.iorder = iorder;
        }

        public String getDtcloseddate() {
            return dtcloseddate;
        }

        public void setDtcloseddate(String dtcloseddate) {
            this.dtcloseddate = dtcloseddate;
        }

        public String getIjuniorvisit() {
            return ijuniorvisit;
        }

        public void setIjuniorvisit(String ijuniorvisit) {
            this.ijuniorvisit = ijuniorvisit;
        }

        public String getIactiveflag() {
            return iactiveflag;
        }

        public void setIactiveflag(String iactiveflag) {
            this.iactiveflag = iactiveflag;
        }

        public String getReadFlag() {
            return readFlag;
        }

        public void setReadFlag(String readFlag) {
            this.readFlag = readFlag;
        }

        public boolean isSelf() {
            return self;
        }

        public void setSelf(boolean self) {
            this.self = self;
        }

        public String getNoticevistorIds() {
            return noticevistorIds;
        }

        public void setNoticevistorIds(String noticevistorIds) {
            this.noticevistorIds = noticevistorIds;
        }

        public String getNoticevistorNames() {
            return noticevistorNames;
        }

        public void setNoticevistorNames(String noticevistorNames) {
            this.noticevistorNames = noticevistorNames;
        }

        public String getNoticevistcompIds() {
            return noticevistcompIds;
        }

        public void setNoticevistcompIds(String noticevistcompIds) {
            this.noticevistcompIds = noticevistcompIds;
        }

        public static class CreateByBean {
            /**
             * id : 1
             * isNewRecord : false
             * loginFlag : 1
             * admin : true
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
             * id : 1
             * isNewRecord : false
             * loginFlag : 1
             * admin : true
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
}
