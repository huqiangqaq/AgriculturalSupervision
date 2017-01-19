package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/18 14:27.
 */

public class PurchaseDetail {

    /**
     * poseedd : [{"id":"d08bbe5b6e094db0990a1b78b8947360","isNewRecord":false,"fponumber":"11","fprice":"11","vcunit":"袋","dtpodate":1479083309000,"pohremarks":"","createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"pohdId":{"id":"2016111782943181","isNewRecord":false,"ftotalmoney":"121","mySupplier":{"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}},"seedId":{"id":"0f571f05aebe46ae80edc656e6748ec4","isNewRecord":false,"vcvarietyname":"二季水稻"},"tpohId":"2016111782943181"}]
     * poh : {"id":"2016111782943181","isNewRecord":false,"remarks":"","dtpodate":"2016-11-14 08:28:29","ftotalmoney":"121","mySupplier":{"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}}
     * msg : 查询成功！
     * success : true
     */

    private PohBean poh;
    private String msg;
    private String success;
    private List<PoseeddBean> poseedd;

    public PohBean getPoh() {
        return poh;
    }

    public void setPoh(PohBean poh) {
        this.poh = poh;
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

    public List<PoseeddBean> getPoseedd() {
        return poseedd;
    }

    public void setPoseedd(List<PoseeddBean> poseedd) {
        this.poseedd = poseedd;
    }

    public static class PohBean {
        /**
         * id : 2016111782943181
         * isNewRecord : false
         * remarks :
         * dtpodate : 2016-11-14 08:28:29
         * ftotalmoney : 121
         * mySupplier : {"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String dtpodate;
        private String ftotalmoney;
        private MySupplierBean mySupplier;

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

        public String getDtpodate() {
            return dtpodate;
        }

        public void setDtpodate(String dtpodate) {
            this.dtpodate = dtpodate;
        }

        public String getFtotalmoney() {
            return ftotalmoney;
        }

        public void setFtotalmoney(String ftotalmoney) {
            this.ftotalmoney = ftotalmoney;
        }

        public MySupplierBean getMySupplier() {
            return mySupplier;
        }

        public void setMySupplier(MySupplierBean mySupplier) {
            this.mySupplier = mySupplier;
        }

        public static class MySupplierBean {
            /**
             * id : f4b31e3acf784b718b771e222fff0d2a
             * isNewRecord : false
             * vcmysuppliername : 小飞哥农产品生产企业
             */

            private String id;
            private boolean isNewRecord;
            private String vcmysuppliername;

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

            public String getVcmysuppliername() {
                return vcmysuppliername;
            }

            public void setVcmysuppliername(String vcmysuppliername) {
                this.vcmysuppliername = vcmysuppliername;
            }
        }
    }

    public static class PoseeddBean {
        /**
         * id : d08bbe5b6e094db0990a1b78b8947360
         * isNewRecord : false
         * fponumber : 11
         * fprice : 11
         * vcunit : 袋
         * dtpodate : 1479083309000
         * pohremarks :
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * pohdId : {"id":"2016111782943181","isNewRecord":false,"ftotalmoney":"121","mySupplier":{"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}}
         * seedId : {"id":"0f571f05aebe46ae80edc656e6748ec4","isNewRecord":false,"vcvarietyname":"二季水稻"}
         * tpohId : 2016111782943181
         */

        private String id;
        private boolean isNewRecord;
        private String fponumber;
        private String fprice;
        private String vcunit;
        private long dtpodate;
        private String pohremarks;
        private CreateByBean createBy;
        private UpdateByBean updateBy;
        private PohdIdBean pohdId;
        private SeedIdBean seedId;
        private String tpohId;

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

        public String getPohremarks() {
            return pohremarks;
        }

        public void setPohremarks(String pohremarks) {
            this.pohremarks = pohremarks;
        }

        public CreateByBean getCreateBy() {
            return createBy;
        }

        public void setCreateBy(CreateByBean createBy) {
            this.createBy = createBy;
        }

        public UpdateByBean getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(UpdateByBean updateBy) {
            this.updateBy = updateBy;
        }

        public PohdIdBean getPohdId() {
            return pohdId;
        }

        public void setPohdId(PohdIdBean pohdId) {
            this.pohdId = pohdId;
        }

        public SeedIdBean getSeedId() {
            return seedId;
        }

        public void setSeedId(SeedIdBean seedId) {
            this.seedId = seedId;
        }

        public String getTpohId() {
            return tpohId;
        }

        public void setTpohId(String tpohId) {
            this.tpohId = tpohId;
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

        public static class PohdIdBean {
            /**
             * id : 2016111782943181
             * isNewRecord : false
             * ftotalmoney : 121
             * mySupplier : {"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}
             */

            private String id;
            private boolean isNewRecord;
            private String ftotalmoney;
            private MySupplierBeanX mySupplier;

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

            public String getFtotalmoney() {
                return ftotalmoney;
            }

            public void setFtotalmoney(String ftotalmoney) {
                this.ftotalmoney = ftotalmoney;
            }

            public MySupplierBeanX getMySupplier() {
                return mySupplier;
            }

            public void setMySupplier(MySupplierBeanX mySupplier) {
                this.mySupplier = mySupplier;
            }

            public static class MySupplierBeanX {
                /**
                 * id : f4b31e3acf784b718b771e222fff0d2a
                 * isNewRecord : false
                 * vcmysuppliername : 小飞哥农产品生产企业
                 */

                private String id;
                private boolean isNewRecord;
                private String vcmysuppliername;

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

                public String getVcmysuppliername() {
                    return vcmysuppliername;
                }

                public void setVcmysuppliername(String vcmysuppliername) {
                    this.vcmysuppliername = vcmysuppliername;
                }
            }
        }

        public static class SeedIdBean {
            /**
             * id : 0f571f05aebe46ae80edc656e6748ec4
             * isNewRecord : false
             * vcvarietyname : 二季水稻
             */

            private String id;
            private boolean isNewRecord;
            private String vcvarietyname;

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

            public String getVcvarietyname() {
                return vcvarietyname;
            }

            public void setVcvarietyname(String vcvarietyname) {
                this.vcvarietyname = vcvarietyname;
            }
        }
    }
}
