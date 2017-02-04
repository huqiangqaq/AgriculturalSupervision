package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/2/4 9:45.
 */

public class SaleDetail {

    /**
     * msg : 查询成功！
     * success : true
     * soh : {"id":"201611181036","isNewRecord":false,"remarks":"","dtsodate":"2016-11-18 15:17:29","ftotalmoney":"142","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}}
     * soseedd : [{"id":"25086ab2e3654aa8a7b5a3b0fbc1f8d4","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-19 09:59:56","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 15:03:57","fprice":"23","fnumber":"2","vcunit":"袋","dtsodate":1479453449000,"sohremarks":"","soh":{"isNewRecord":true,"ftotalmoney":"46","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}},"seedbatch":{"id":"0f571f05aebe46ae80edc656e6748ec4","isNewRecord":false,"vcbatchno":"2017020494518106","seed":{"isNewRecord":true,"vcvarietyname":"二季水稻"}},"tsohId":"201611181036","tseedbatchId":"423fc8edd1ea4409a711a50a024b5b6e"},{"id":"8007fde49fa34e2f9af0d88528c8265d","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 15:03:57","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 15:03:57","fprice":"32","fnumber":"3","vcunit":"袋","dtsodate":1479453449000,"sohremarks":"","soh":{"isNewRecord":true,"ftotalmoney":"96","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}},"seedbatch":{"id":"0f571f05aebe46ae80edc656e6748ec4","isNewRecord":false,"vcbatchno":"2017020494518106","seed":{"isNewRecord":true,"vcvarietyname":"二季水稻"}},"tsohId":"201611181036","tseedbatchId":"423fc8edd1ea4409a711a50a024b5b6e"}]
     */

    private String msg;
    private String success;
    private SohBean soh;
    private List<SoseeddBean> soseedd;

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

    public SohBean getSoh() {
        return soh;
    }

    public void setSoh(SohBean soh) {
        this.soh = soh;
    }

    public List<SoseeddBean> getSoseedd() {
        return soseedd;
    }

    public void setSoseedd(List<SoseeddBean> soseedd) {
        this.soseedd = soseedd;
    }

    public static class SohBean {
        /**
         * id : 201611181036
         * isNewRecord : false
         * remarks :
         * dtsodate : 2016-11-18 15:17:29
         * ftotalmoney : 142
         * myCustomer : {"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String dtsodate;
        private String ftotalmoney;
        private MyCustomerBean myCustomer;

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

        public String getDtsodate() {
            return dtsodate;
        }

        public void setDtsodate(String dtsodate) {
            this.dtsodate = dtsodate;
        }

        public String getFtotalmoney() {
            return ftotalmoney;
        }

        public void setFtotalmoney(String ftotalmoney) {
            this.ftotalmoney = ftotalmoney;
        }

        public MyCustomerBean getMyCustomer() {
            return myCustomer;
        }

        public void setMyCustomer(MyCustomerBean myCustomer) {
            this.myCustomer = myCustomer;
        }

        public static class MyCustomerBean {
            /**
             * id : e08e6d60f4c043fb9b82a7aa3ab0b89b
             * isNewRecord : false
             * vcmycustomername : 王力宏
             */

            private String id;
            private boolean isNewRecord;
            private String vcmycustomername;

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

            public String getVcmycustomername() {
                return vcmycustomername;
            }

            public void setVcmycustomername(String vcmycustomername) {
                this.vcmycustomername = vcmycustomername;
            }
        }
    }

    public static class SoseeddBean {
        /**
         * id : 25086ab2e3654aa8a7b5a3b0fbc1f8d4
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2017-01-19 09:59:56
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2016-11-18 15:03:57
         * fprice : 23
         * fnumber : 2
         * vcunit : 袋
         * dtsodate : 1479453449000
         * sohremarks :
         * soh : {"isNewRecord":true,"ftotalmoney":"46","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}}
         * seedbatch : {"id":"0f571f05aebe46ae80edc656e6748ec4","isNewRecord":false,"vcbatchno":"2017020494518106","seed":{"isNewRecord":true,"vcvarietyname":"二季水稻"}}
         * tsohId : 201611181036
         * tseedbatchId : 423fc8edd1ea4409a711a50a024b5b6e
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private UpdateByBean updateBy;
        private String updateDate;
        private String fprice;
        private String fnumber;
        private String vcunit;
        private long dtsodate;
        private String sohremarks;
        private SohBeanX soh;
        private SeedbatchBean seedbatch;
        private String tsohId;
        private String tseedbatchId;

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

        public String getFprice() {
            return fprice;
        }

        public void setFprice(String fprice) {
            this.fprice = fprice;
        }

        public String getFnumber() {
            return fnumber;
        }

        public void setFnumber(String fnumber) {
            this.fnumber = fnumber;
        }

        public String getVcunit() {
            return vcunit;
        }

        public void setVcunit(String vcunit) {
            this.vcunit = vcunit;
        }

        public long getDtsodate() {
            return dtsodate;
        }

        public void setDtsodate(long dtsodate) {
            this.dtsodate = dtsodate;
        }

        public String getSohremarks() {
            return sohremarks;
        }

        public void setSohremarks(String sohremarks) {
            this.sohremarks = sohremarks;
        }

        public SohBeanX getSoh() {
            return soh;
        }

        public void setSoh(SohBeanX soh) {
            this.soh = soh;
        }

        public SeedbatchBean getSeedbatch() {
            return seedbatch;
        }

        public void setSeedbatch(SeedbatchBean seedbatch) {
            this.seedbatch = seedbatch;
        }

        public String getTsohId() {
            return tsohId;
        }

        public void setTsohId(String tsohId) {
            this.tsohId = tsohId;
        }

        public String getTseedbatchId() {
            return tseedbatchId;
        }

        public void setTseedbatchId(String tseedbatchId) {
            this.tseedbatchId = tseedbatchId;
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

        public static class SohBeanX {
            /**
             * isNewRecord : true
             * ftotalmoney : 46
             * myCustomer : {"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}
             */

            private boolean isNewRecord;
            private String ftotalmoney;
            private MyCustomerBeanX myCustomer;

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

            public MyCustomerBeanX getMyCustomer() {
                return myCustomer;
            }

            public void setMyCustomer(MyCustomerBeanX myCustomer) {
                this.myCustomer = myCustomer;
            }

            public static class MyCustomerBeanX {
                /**
                 * id : e08e6d60f4c043fb9b82a7aa3ab0b89b
                 * isNewRecord : false
                 * vcmycustomername : 王力宏
                 */

                private String id;
                private boolean isNewRecord;
                private String vcmycustomername;

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

                public String getVcmycustomername() {
                    return vcmycustomername;
                }

                public void setVcmycustomername(String vcmycustomername) {
                    this.vcmycustomername = vcmycustomername;
                }
            }
        }

        public static class SeedbatchBean {
            /**
             * id : 0f571f05aebe46ae80edc656e6748ec4
             * isNewRecord : false
             * vcbatchno : 2017020494518106
             * seed : {"isNewRecord":true,"vcvarietyname":"二季水稻"}
             */

            private String id;
            private boolean isNewRecord;
            private String vcbatchno;
            private SeedBean seed;

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

            public String getVcbatchno() {
                return vcbatchno;
            }

            public void setVcbatchno(String vcbatchno) {
                this.vcbatchno = vcbatchno;
            }

            public SeedBean getSeed() {
                return seed;
            }

            public void setSeed(SeedBean seed) {
                this.seed = seed;
            }

            public static class SeedBean {
                /**
                 * isNewRecord : true
                 * vcvarietyname : 二季水稻
                 */

                private boolean isNewRecord;
                private String vcvarietyname;

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
}
