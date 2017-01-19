package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/1/19 14:09.
 */

public class PurPestDetail {

    /**
     * msg : 查询成功！
     * success : true
     * popesticided : [{"id":"58c4bde330dc49dc8dc7cf1a1c5d07d4","isNewRecord":false,"remarks":"采购农药","createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-11-15 15:05:59","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2016-11-15 15:05:59","fponumber":"2","fprice":"2","vcunit":"瓶","dtpodate":1479107929000,"pohremarks":"","poh":{"id":"2016111515191863","isNewRecord":false,"ftotalmoney":"4","mySupplier":{"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}},"pesticide":{"id":"82943343a2b4499db4975c348a8f2e88","isNewRecord":false,"vcpesticidename":"代森锰锌"},"tpohId":"2016111515191863"}]
     * poh : {"id":"2016111515191863","isNewRecord":false,"remarks":"","dtpodate":"2016-11-14 15:18:49","ftotalmoney":"4","mySupplier":{"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}}
     */

    private String msg;
    private String success;
    private PohBean poh;
    private List<PopesticidedBean> popesticided;

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

    public PohBean getPoh() {
        return poh;
    }

    public void setPoh(PohBean poh) {
        this.poh = poh;
    }

    public List<PopesticidedBean> getPopesticided() {
        return popesticided;
    }

    public void setPopesticided(List<PopesticidedBean> popesticided) {
        this.popesticided = popesticided;
    }

    public static class PohBean {
        /**
         * id : 2016111515191863
         * isNewRecord : false
         * remarks :
         * dtpodate : 2016-11-14 15:18:49
         * ftotalmoney : 4
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

    public static class PopesticidedBean {
        /**
         * id : 58c4bde330dc49dc8dc7cf1a1c5d07d4
         * isNewRecord : false
         * remarks : 采购农药
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false}
         * createDate : 2016-11-15 15:05:59
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false}
         * updateDate : 2016-11-15 15:05:59
         * fponumber : 2
         * fprice : 2
         * vcunit : 瓶
         * dtpodate : 1479107929000
         * pohremarks :
         * poh : {"id":"2016111515191863","isNewRecord":false,"ftotalmoney":"4","mySupplier":{"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"vcmysuppliername":"小飞哥农产品生产企业"}}
         * pesticide : {"id":"82943343a2b4499db4975c348a8f2e88","isNewRecord":false,"vcpesticidename":"代森锰锌"}
         * tpohId : 2016111515191863
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
        private String pohremarks;
        private PohBeanX poh;
        private PesticideBean pesticide;
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

        public String getPohremarks() {
            return pohremarks;
        }

        public void setPohremarks(String pohremarks) {
            this.pohremarks = pohremarks;
        }

        public PohBeanX getPoh() {
            return poh;
        }

        public void setPoh(PohBeanX poh) {
            this.poh = poh;
        }

        public PesticideBean getPesticide() {
            return pesticide;
        }

        public void setPesticide(PesticideBean pesticide) {
            this.pesticide = pesticide;
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

        public static class PohBeanX {
            /**
             * id : 2016111515191863
             * isNewRecord : false
             * ftotalmoney : 4
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

        public static class PesticideBean {
            /**
             * id : 82943343a2b4499db4975c348a8f2e88
             * isNewRecord : false
             * vcpesticidename : 代森锰锌
             */

            private String id;
            private boolean isNewRecord;
            private String vcpesticidename;

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

            public String getVcpesticidename() {
                return vcpesticidename;
            }

            public void setVcpesticidename(String vcpesticidename) {
                this.vcpesticidename = vcpesticidename;
            }
        }
    }
}
