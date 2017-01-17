package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/17 11:13.
 */

public class AnnounceDetail {

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
     * noticevistcompList : [{"id":"33eafab74540471596bff8353c91863a","isNewRecord":false,"createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"createDate":"2017-01-17 08:50:16","updateBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2017-01-17 09:02:44","notice":{"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""},"vcorgno":"06ec89414f2b4ae4a8afe0511b137a00","vcorgName":"农信通测试","ireadflag":"1","dtreaddate":"2017-01-17 09:05:36"},{"id":"2234c5cd293e4d04b47927551154ff7e","isNewRecord":false,"createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"createDate":"2017-01-17 09:02:44","updateBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2017-01-17 09:02:44","notice":{"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""},"vcorgno":"b56f98d12bb94a209e8758a342ae0726","vcorgName":"农信通测试02","ireadflag":"0"},{"id":"b56e95f2fbdd44e6b1f302f85afeba0d","isNewRecord":false,"createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"createDate":"2017-01-17 09:02:44","updateBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2017-01-17 09:02:44","notice":{"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""},"vcorgno":"9d1649ba715e42f78698c81d25c67c34","vcorgName":"胡强1","ireadflag":"0"},{"id":"fe1ed46aae8b4c1b8563464e9a96603d","isNewRecord":false,"createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"createDate":"2017-01-17 09:02:44","updateBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2017-01-17 09:02:44","notice":{"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""},"vcorgno":"6fa027c4e4604f90ae2a55fb055b4c5f","vcorgName":"胡强","ireadflag":"0"}]
     * noticevistorList : [{"id":"01d186dd02c14f16a93d501f130d8711","isNewRecord":false,"createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"createDate":"2017-01-17 09:02:44","updateBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2017-01-17 09:02:44","notice":{"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""},"ireadflag":"0","vcreaderno":"c0f3a3f1544a4753aa59ab6006a2a6f4","vcreadername":"南昌市农业局管理员"},{"id":"84d739543a704c4a8f25a1cd4ade4434","isNewRecord":false,"createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"createDate":"2017-01-17 10:19:47","updateBy":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2017-01-17 09:02:44","notice":{"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""},"ireadflag":"1","dtreaddate":"2017-01-17 10:35:06","vcreaderno":"71568b9e00a140dea064aebe8d6b6577","vcreadername":"胡强"}]
     * self : false
     * noticevistorIds : c0f3a3f1544a4753aa59ab6006a2a6f4,71568b9e00a140dea064aebe8d6b6577
     * noticevistorNames : 南昌市农业局管理员,胡强
     * noticevistcompIds : 06ec89414f2b4ae4a8afe0511b137a00,b56f98d12bb94a209e8758a342ae0726,9d1649ba715e42f78698c81d25c67c34,6fa027c4e4604f90ae2a55fb055b4c5f
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
    private boolean self;
    private String noticevistorIds;
    private String noticevistorNames;
    private String noticevistcompIds;
    private List<NoticevistcompListBean> noticevistcompList;
    private List<NoticevistorListBean> noticevistorList;

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

    public List<NoticevistcompListBean> getNoticevistcompList() {
        return noticevistcompList;
    }

    public void setNoticevistcompList(List<NoticevistcompListBean> noticevistcompList) {
        this.noticevistcompList = noticevistcompList;
    }

    public List<NoticevistorListBean> getNoticevistorList() {
        return noticevistorList;
    }

    public void setNoticevistorList(List<NoticevistorListBean> noticevistorList) {
        this.noticevistorList = noticevistorList;
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

    public static class NoticevistcompListBean {
        /**
         * id : 33eafab74540471596bff8353c91863a
         * isNewRecord : false
         * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""}
         * createDate : 2017-01-17 08:50:16
         * updateBy : {"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""}
         * updateDate : 2017-01-17 09:02:44
         * notice : {"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""}
         * vcorgno : 06ec89414f2b4ae4a8afe0511b137a00
         * vcorgName : 农信通测试
         * ireadflag : 1
         * dtreaddate : 2017-01-17 09:05:36
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBeanX createBy;
        private String createDate;
        private UpdateByBeanX updateBy;
        private String updateDate;
        private NoticeBean notice;
        private String vcorgno;
        private String vcorgName;
        private String ireadflag;
        private String dtreaddate;

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

        public CreateByBeanX getCreateBy() {
            return createBy;
        }

        public void setCreateBy(CreateByBeanX createBy) {
            this.createBy = createBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public UpdateByBeanX getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(UpdateByBeanX updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public NoticeBean getNotice() {
            return notice;
        }

        public void setNotice(NoticeBean notice) {
            this.notice = notice;
        }

        public String getVcorgno() {
            return vcorgno;
        }

        public void setVcorgno(String vcorgno) {
            this.vcorgno = vcorgno;
        }

        public String getVcorgName() {
            return vcorgName;
        }

        public void setVcorgName(String vcorgName) {
            this.vcorgName = vcorgName;
        }

        public String getIreadflag() {
            return ireadflag;
        }

        public void setIreadflag(String ireadflag) {
            this.ireadflag = ireadflag;
        }

        public String getDtreaddate() {
            return dtreaddate;
        }

        public void setDtreaddate(String dtreaddate) {
            this.dtreaddate = dtreaddate;
        }

        public static class CreateByBeanX {
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

        public static class UpdateByBeanX {
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

        public static class NoticeBean {
            /**
             * id : d2edd04a1be1483ca4ddbe2892c08ac4
             * isNewRecord : false
             * self : false
             * noticevistorIds :
             * noticevistorNames :
             * noticevistcompIds :
             */

            private String id;
            private boolean isNewRecord;
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
        }
    }

    public static class NoticevistorListBean {
        /**
         * id : 01d186dd02c14f16a93d501f130d8711
         * isNewRecord : false
         * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""}
         * createDate : 2017-01-17 09:02:44
         * updateBy : {"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""}
         * updateDate : 2017-01-17 09:02:44
         * notice : {"id":"d2edd04a1be1483ca4ddbe2892c08ac4","isNewRecord":false,"self":false,"noticevistorIds":"","noticevistorNames":"","noticevistcompIds":""}
         * ireadflag : 0
         * vcreaderno : c0f3a3f1544a4753aa59ab6006a2a6f4
         * vcreadername : 南昌市农业局管理员
         * dtreaddate : 2017-01-17 10:35:06
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBeanXX createBy;
        private String createDate;
        private UpdateByBeanXX updateBy;
        private String updateDate;
        private NoticeBeanX notice;
        private String ireadflag;
        private String vcreaderno;
        private String vcreadername;
        private String dtreaddate;

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

        public CreateByBeanXX getCreateBy() {
            return createBy;
        }

        public void setCreateBy(CreateByBeanXX createBy) {
            this.createBy = createBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public UpdateByBeanXX getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(UpdateByBeanXX updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public NoticeBeanX getNotice() {
            return notice;
        }

        public void setNotice(NoticeBeanX notice) {
            this.notice = notice;
        }

        public String getIreadflag() {
            return ireadflag;
        }

        public void setIreadflag(String ireadflag) {
            this.ireadflag = ireadflag;
        }

        public String getVcreaderno() {
            return vcreaderno;
        }

        public void setVcreaderno(String vcreaderno) {
            this.vcreaderno = vcreaderno;
        }

        public String getVcreadername() {
            return vcreadername;
        }

        public void setVcreadername(String vcreadername) {
            this.vcreadername = vcreadername;
        }

        public String getDtreaddate() {
            return dtreaddate;
        }

        public void setDtreaddate(String dtreaddate) {
            this.dtreaddate = dtreaddate;
        }

        public static class CreateByBeanXX {
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

        public static class UpdateByBeanXX {
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

        public static class NoticeBeanX {
            /**
             * id : d2edd04a1be1483ca4ddbe2892c08ac4
             * isNewRecord : false
             * self : false
             * noticevistorIds :
             * noticevistorNames :
             * noticevistcompIds :
             */

            private String id;
            private boolean isNewRecord;
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
        }
    }
}
