package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2017/2/4 13:48.
 */

public class FerDetail {

    /**
     * msg : 查询成功！
     * sofertilizerd : [{"id":"ca93115010e14cb89f35c5f6150cb691","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:19:31","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:19:31","fprice":"2","fnumber":"1","vcunit":"袋","dtsodate":1479440006000,"sohremarks":"","soh":{"isNewRecord":true,"ftotalmoney":"2","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"id":"e128df0b829e4fd6874faadf87084b4a","isNewRecord":false,"vcbatchno":"20170204134716341","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"tsohId":"20161118461","tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"}]
     * success : true
     * soh : {"id":"20161118461","isNewRecord":false,"remarks":"","dtsodate":"2016-11-18 11:33:26","ftotalmoney":"2","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}}
     */

    private String msg;
    private String success;
    private SohBean soh;
    private List<SofertilizerdBean> sofertilizerd;

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

    public List<SofertilizerdBean> getSofertilizerd() {
        return sofertilizerd;
    }

    public void setSofertilizerd(List<SofertilizerdBean> sofertilizerd) {
        this.sofertilizerd = sofertilizerd;
    }

    public static class SohBean {
        /**
         * id : 20161118461
         * isNewRecord : false
         * remarks :
         * dtsodate : 2016-11-18 11:33:26
         * ftotalmoney : 2
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

    public static class SofertilizerdBean {
        /**
         * id : ca93115010e14cb89f35c5f6150cb691
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2016-11-18 11:19:31
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2016-11-18 11:19:31
         * fprice : 2
         * fnumber : 1
         * vcunit : 袋
         * dtsodate : 1479440006000
         * sohremarks :
         * soh : {"isNewRecord":true,"ftotalmoney":"2","myCustomer":{"id":"e08e6d60f4c043fb9b82a7aa3ab0b89b","isNewRecord":false,"vcmycustomername":"王力宏"}}
         * fertilizerbatch : {"id":"e128df0b829e4fd6874faadf87084b4a","isNewRecord":false,"vcbatchno":"20170204134716341","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}}
         * tsohId : 20161118461
         * tfertilizerbatchId : 3f16957cb5634303ba7735154a08ee91
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
        private FertilizerbatchBean fertilizerbatch;
        private String tsohId;
        private String tfertilizerbatchId;

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

        public FertilizerbatchBean getFertilizerbatch() {
            return fertilizerbatch;
        }

        public void setFertilizerbatch(FertilizerbatchBean fertilizerbatch) {
            this.fertilizerbatch = fertilizerbatch;
        }

        public String getTsohId() {
            return tsohId;
        }

        public void setTsohId(String tsohId) {
            this.tsohId = tsohId;
        }

        public String getTfertilizerbatchId() {
            return tfertilizerbatchId;
        }

        public void setTfertilizerbatchId(String tfertilizerbatchId) {
            this.tfertilizerbatchId = tfertilizerbatchId;
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
             * ftotalmoney : 2
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

        public static class FertilizerbatchBean {
            /**
             * id : e128df0b829e4fd6874faadf87084b4a
             * isNewRecord : false
             * vcbatchno : 20170204134716341
             * fertilizer : {"isNewRecord":true,"vcfertilizename":"尿素123"}
             */

            private String id;
            private boolean isNewRecord;
            private String vcbatchno;
            private FertilizerBean fertilizer;

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

            public FertilizerBean getFertilizer() {
                return fertilizer;
            }

            public void setFertilizer(FertilizerBean fertilizer) {
                this.fertilizer = fertilizer;
            }

            public static class FertilizerBean {
                /**
                 * isNewRecord : true
                 * vcfertilizename : 尿素123
                 */

                private boolean isNewRecord;
                private String vcfertilizename;

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
        }
    }
}
