package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/2/4 10:59.
 */

public class SalePestDeatil {

    /**
     * msg : 查询成功！
     * sopesticided : [{"id":"6a3227fb4cd549f0a432e39de520e6a9","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:29:23","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:29:23","fprice":"50","fnumber":"1","vcunit":"瓶","dtsodate":1479439751000,"sohremarks":"","vcRegName":"王菲","vcRegIDCode":"23512452365214253","soh":{"isNewRecord":true,"ftotalmoney":"50","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}},"pesticidebatch":{"id":"82943343a2b4499db4975c348a8f2e88","isNewRecord":false,"vcbatchno":"2017020410584575","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}},"tsohId":"201611181008","tpesticidebatchId":"07676610b3334e12af128b9b5141cdd4"}]
     * success : true
     * soh : {"id":"201611181008","isNewRecord":false,"remarks":"","dtsodate":"2016-11-18 11:29:11","ftotalmoney":"50","vcRegName":"王菲","vcRegIDCode":"23512452365214253","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}}
     */

    private String msg;
    private String success;
    private SohBean soh;
    private List<SopesticidedBean> sopesticided;

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

    public List<SopesticidedBean> getSopesticided() {
        return sopesticided;
    }

    public void setSopesticided(List<SopesticidedBean> sopesticided) {
        this.sopesticided = sopesticided;
    }

    public static class SohBean {
        /**
         * id : 201611181008
         * isNewRecord : false
         * remarks :
         * dtsodate : 2016-11-18 11:29:11
         * ftotalmoney : 50
         * vcRegName : 王菲
         * vcRegIDCode : 23512452365214253
         * myCustomer : {"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String dtsodate;
        private String ftotalmoney;
        private String vcRegName;
        private String vcRegIDCode;
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

        public String getVcRegName() {
            return vcRegName;
        }

        public void setVcRegName(String vcRegName) {
            this.vcRegName = vcRegName;
        }

        public String getVcRegIDCode() {
            return vcRegIDCode;
        }

        public void setVcRegIDCode(String vcRegIDCode) {
            this.vcRegIDCode = vcRegIDCode;
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

    public static class SopesticidedBean {
        /**
         * id : 6a3227fb4cd549f0a432e39de520e6a9
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2016-11-18 11:29:23
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2016-11-18 11:29:23
         * fprice : 50
         * fnumber : 1
         * vcunit : 瓶
         * dtsodate : 1479439751000
         * sohremarks :
         * vcRegName : 王菲
         * vcRegIDCode : 23512452365214253
         * soh : {"isNewRecord":true,"ftotalmoney":"50","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}}
         * pesticidebatch : {"id":"82943343a2b4499db4975c348a8f2e88","isNewRecord":false,"vcbatchno":"2017020410584575","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}}
         * tsohId : 201611181008
         * tpesticidebatchId : 07676610b3334e12af128b9b5141cdd4
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
        private String vcRegName;
        private String vcRegIDCode;
        private SohBeanX soh;
        private PesticidebatchBean pesticidebatch;
        private String tsohId;
        private String tpesticidebatchId;

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

        public String getVcRegName() {
            return vcRegName;
        }

        public void setVcRegName(String vcRegName) {
            this.vcRegName = vcRegName;
        }

        public String getVcRegIDCode() {
            return vcRegIDCode;
        }

        public void setVcRegIDCode(String vcRegIDCode) {
            this.vcRegIDCode = vcRegIDCode;
        }

        public SohBeanX getSoh() {
            return soh;
        }

        public void setSoh(SohBeanX soh) {
            this.soh = soh;
        }

        public PesticidebatchBean getPesticidebatch() {
            return pesticidebatch;
        }

        public void setPesticidebatch(PesticidebatchBean pesticidebatch) {
            this.pesticidebatch = pesticidebatch;
        }

        public String getTsohId() {
            return tsohId;
        }

        public void setTsohId(String tsohId) {
            this.tsohId = tsohId;
        }

        public String getTpesticidebatchId() {
            return tpesticidebatchId;
        }

        public void setTpesticidebatchId(String tpesticidebatchId) {
            this.tpesticidebatchId = tpesticidebatchId;
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
             * ftotalmoney : 50
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

        public static class PesticidebatchBean {
            /**
             * id : 82943343a2b4499db4975c348a8f2e88
             * isNewRecord : false
             * vcbatchno : 2017020410584575
             * pesticide : {"isNewRecord":true,"vcpesticidename":"代森锰锌"}
             */

            private String id;
            private boolean isNewRecord;
            private String vcbatchno;
            private PesticideBean pesticide;

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

            public PesticideBean getPesticide() {
                return pesticide;
            }

            public void setPesticide(PesticideBean pesticide) {
                this.pesticide = pesticide;
            }

            public static class PesticideBean {
                /**
                 * isNewRecord : true
                 * vcpesticidename : 代森锰锌
                 */

                private boolean isNewRecord;
                private String vcpesticidename;

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
}
