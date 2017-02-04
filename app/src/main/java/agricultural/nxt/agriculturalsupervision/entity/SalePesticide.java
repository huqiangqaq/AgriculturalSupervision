package agricultural.nxt.agriculturalsupervision.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by huqiang on 2017/2/4 10:11.
 */

public class SalePesticide {


    /**
     * pageNo : 1
     * pageSize : 20
     * count : 6
     * list : [{"id":"28bf96c28d734654a2e1ae3089731888","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:38:15","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:38:15","fprice":"45","fnumber":"3","vcunit":"袋","dtsodate":1479440257000,"soh":{"id":"20161118758","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"pesticidebatch":{"isNewRecord":true,"vcbatchno":"20170204101050419","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpesticidebatchId":"07676610b3334e12af128b9b5141cdd4"},{"id":"6a3227fb4cd549f0a432e39de520e6a9","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:29:23","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:29:23","fprice":"50","fnumber":"1","vcunit":"瓶","dtsodate":1479439751000,"soh":{"id":"201611181008","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"pesticidebatch":{"isNewRecord":true,"vcbatchno":"20170204101050419","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpesticidebatchId":"07676610b3334e12af128b9b5141cdd4"},{"id":"712a32c2fd1f482c80d5606ef1b1add0","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-16 17:16:00","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-16 17:16:00","fprice":"22","fnumber":"22","vcunit":"瓶","dtsodate":1479287725000,"soh":{"id":"2016111632","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"pesticidebatch":{"isNewRecord":true,"vcbatchno":"20170204101050419","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpesticidebatchId":"07676610b3334e12af128b9b5141cdd4"},{"id":"66341068ea8d484fbe76cd8874748398","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-16 17:15:58","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-16 17:15:58","fprice":"11","fnumber":"11","vcunit":"瓶","dtsodate":1479287725000,"soh":{"id":"2016111632","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"pesticidebatch":{"isNewRecord":true,"vcbatchno":"20170204101050419","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpesticidebatchId":"07676610b3334e12af128b9b5141cdd4"},{"id":"e8b12fcd3d9a47a593a7aec61bbc572d","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-16 11:15:22","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-16 11:15:22","fprice":"2","fnumber":"2","vcunit":"瓶","dtsodate":1479265727000,"soh":{"id":"20161116208","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"pesticidebatch":{"isNewRecord":true,"vcbatchno":"20170204101050419","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpesticidebatchId":"07676610b3334e12af128b9b5141cdd4"},{"id":"3d9685560633469583265efaf9ecb6aa","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-15 15:51:28","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-15 15:51:28","fprice":"2","fnumber":"2","vcunit":"瓶","dtsodate":1479196251000,"soh":{"id":"20161115420","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"pesticidebatch":{"isNewRecord":true,"vcbatchno":"20170204101050419","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpesticidebatchId":"07676610b3334e12af128b9b5141cdd4"}]
     * firstResult : 0
     * maxResults : 20
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');" onclick="this.select();"/> / <input type="text" value="20" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 6 条</a></li>
     </ul>
     <div style="clear:both;"></div>
     */

    private int pageNo;
    private int pageSize;
    private int count;
    private int firstResult;
    private int maxResults;
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

    public static class ListBean implements Parcelable {

        /**
         * id : 28bf96c28d734654a2e1ae3089731888
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2016-11-18 11:38:15
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2016-11-18 11:38:15
         * fprice : 45
         * fnumber : 3
         * vcunit : 袋
         * dtsodate : 1479440257000
         * soh : {"id":"20161118758","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}}
         * pesticidebatch : {"isNewRecord":true,"vcbatchno":"20170204101050419","pesticide":{"isNewRecord":true,"vcpesticidename":"代森锰锌"}}
         * owner : {"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]}
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
        private String dtsodate;
        private SohBean soh;
        private PesticidebatchBean pesticidebatch;
        private OwnerBean owner;
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

        public String getDtsodate() {
            return dtsodate;
        }

        public void setDtsodate(String dtsodate) {
            this.dtsodate = dtsodate;
        }

        public SohBean getSoh() {
            return soh;
        }

        public void setSoh(SohBean soh) {
            this.soh = soh;
        }

        public PesticidebatchBean getPesticidebatch() {
            return pesticidebatch;
        }

        public void setPesticidebatch(PesticidebatchBean pesticidebatch) {
            this.pesticidebatch = pesticidebatch;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public String getTpesticidebatchId() {
            return tpesticidebatchId;
        }

        public void setTpesticidebatchId(String tpesticidebatchId) {
            this.tpesticidebatchId = tpesticidebatchId;
        }

        public static class CreateByBean implements Parcelable {

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.loginFlag);
                dest.writeByte(this.admin ? (byte) 1 : (byte) 0);
                dest.writeString(this.roleNames);
            }

            public CreateByBean() {
            }

            protected CreateByBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.loginFlag = in.readString();
                this.admin = in.readByte() != 0;
                this.roleNames = in.readString();
            }

            public static final Creator<CreateByBean> CREATOR = new Creator<CreateByBean>() {
                @Override
                public CreateByBean createFromParcel(Parcel source) {
                    return new CreateByBean(source);
                }

                @Override
                public CreateByBean[] newArray(int size) {
                    return new CreateByBean[size];
                }
            };
        }

        public static class UpdateByBean implements Parcelable {

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.loginFlag);
                dest.writeByte(this.admin ? (byte) 1 : (byte) 0);
                dest.writeString(this.roleNames);
            }

            public UpdateByBean() {
            }

            protected UpdateByBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.loginFlag = in.readString();
                this.admin = in.readByte() != 0;
                this.roleNames = in.readString();
            }

            public static final Creator<UpdateByBean> CREATOR = new Creator<UpdateByBean>() {
                @Override
                public UpdateByBean createFromParcel(Parcel source) {
                    return new UpdateByBean(source);
                }

                @Override
                public UpdateByBean[] newArray(int size) {
                    return new UpdateByBean[size];
                }
            };
        }

        public static class SohBean implements Parcelable {

            /**
             * id : 20161118758
             * isNewRecord : false
             * myCustomer : {"isNewRecord":true,"vcmycustomername":"王力宏"}
             */

            private String id;
            private boolean isNewRecord;
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

            public MyCustomerBean getMyCustomer() {
                return myCustomer;
            }

            public void setMyCustomer(MyCustomerBean myCustomer) {
                this.myCustomer = myCustomer;
            }

            public static class MyCustomerBean implements Parcelable {

                /**
                 * isNewRecord : true
                 * vcmycustomername : 王力宏
                 */

                private boolean isNewRecord;
                private String vcmycustomername;

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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                    dest.writeString(this.vcmycustomername);
                }

                public MyCustomerBean() {
                }

                protected MyCustomerBean(Parcel in) {
                    this.isNewRecord = in.readByte() != 0;
                    this.vcmycustomername = in.readString();
                }

                public static final Creator<MyCustomerBean> CREATOR = new Creator<MyCustomerBean>() {
                    @Override
                    public MyCustomerBean createFromParcel(Parcel source) {
                        return new MyCustomerBean(source);
                    }

                    @Override
                    public MyCustomerBean[] newArray(int size) {
                        return new MyCustomerBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeParcelable(this.myCustomer, flags);
            }

            public SohBean() {
            }

            protected SohBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.myCustomer = in.readParcelable(MyCustomerBean.class.getClassLoader());
            }

            public static final Creator<SohBean> CREATOR = new Creator<SohBean>() {
                @Override
                public SohBean createFromParcel(Parcel source) {
                    return new SohBean(source);
                }

                @Override
                public SohBean[] newArray(int size) {
                    return new SohBean[size];
                }
            };
        }

        public static class PesticidebatchBean implements Parcelable {

            /**
             * isNewRecord : true
             * vcbatchno : 20170204101050419
             * pesticide : {"isNewRecord":true,"vcpesticidename":"代森锰锌"}
             */

            private boolean isNewRecord;
            private String vcbatchno;
            private PesticideBean pesticide;

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

            public static class PesticideBean implements Parcelable {

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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                    dest.writeString(this.vcpesticidename);
                }

                public PesticideBean() {
                }

                protected PesticideBean(Parcel in) {
                    this.isNewRecord = in.readByte() != 0;
                    this.vcpesticidename = in.readString();
                }

                public static final Creator<PesticideBean> CREATOR = new Creator<PesticideBean>() {
                    @Override
                    public PesticideBean createFromParcel(Parcel source) {
                        return new PesticideBean(source);
                    }

                    @Override
                    public PesticideBean[] newArray(int size) {
                        return new PesticideBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.vcbatchno);
                dest.writeParcelable(this.pesticide, flags);
            }

            public PesticidebatchBean() {
            }

            protected PesticidebatchBean(Parcel in) {
                this.isNewRecord = in.readByte() != 0;
                this.vcbatchno = in.readString();
                this.pesticide = in.readParcelable(PesticideBean.class.getClassLoader());
            }

            public static final Creator<PesticidebatchBean> CREATOR = new Creator<PesticidebatchBean>() {
                @Override
                public PesticidebatchBean createFromParcel(Parcel source) {
                    return new PesticidebatchBean(source);
                }

                @Override
                public PesticidebatchBean[] newArray(int size) {
                    return new PesticidebatchBean[size];
                }
            };
        }

        public static class OwnerBean implements Parcelable {

            /**
             * isNewRecord : true
             * vcorgname : 省建设公司
             * ownerscopes :
             * ownerscopeTypes : [""]
             */

            private boolean isNewRecord;
            private String vcorgname;
            private String ownerscopes;
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

            public String getOwnerscopes() {
                return ownerscopes;
            }

            public void setOwnerscopes(String ownerscopes) {
                this.ownerscopes = ownerscopes;
            }

            public List<String> getOwnerscopeTypes() {
                return ownerscopeTypes;
            }

            public void setOwnerscopeTypes(List<String> ownerscopeTypes) {
                this.ownerscopeTypes = ownerscopeTypes;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.vcorgname);
                dest.writeString(this.ownerscopes);
                dest.writeStringList(this.ownerscopeTypes);
            }

            public OwnerBean() {
            }

            protected OwnerBean(Parcel in) {
                this.isNewRecord = in.readByte() != 0;
                this.vcorgname = in.readString();
                this.ownerscopes = in.readString();
                this.ownerscopeTypes = in.createStringArrayList();
            }

            public static final Creator<OwnerBean> CREATOR = new Creator<OwnerBean>() {
                @Override
                public OwnerBean createFromParcel(Parcel source) {
                    return new OwnerBean(source);
                }

                @Override
                public OwnerBean[] newArray(int size) {
                    return new OwnerBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
            dest.writeParcelable(this.createBy, flags);
            dest.writeString(this.createDate);
            dest.writeParcelable(this.updateBy, flags);
            dest.writeString(this.updateDate);
            dest.writeString(this.fprice);
            dest.writeString(this.fnumber);
            dest.writeString(this.vcunit);
            dest.writeString(this.dtsodate);
            dest.writeParcelable(this.soh, flags);
            dest.writeParcelable(this.pesticidebatch, flags);
            dest.writeParcelable(this.owner, flags);
            dest.writeString(this.tpesticidebatchId);
        }

        public ListBean() {
        }

        protected ListBean(Parcel in) {
            this.id = in.readString();
            this.isNewRecord = in.readByte() != 0;
            this.createBy = in.readParcelable(CreateByBean.class.getClassLoader());
            this.createDate = in.readString();
            this.updateBy = in.readParcelable(UpdateByBean.class.getClassLoader());
            this.updateDate = in.readString();
            this.fprice = in.readString();
            this.fnumber = in.readString();
            this.vcunit = in.readString();
            this.dtsodate = in.readString();
            this.soh = in.readParcelable(SohBean.class.getClassLoader());
            this.pesticidebatch = in.readParcelable(PesticidebatchBean.class.getClassLoader());
            this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
            this.tpesticidebatchId = in.readString();
        }

        public static final Parcelable.Creator<ListBean> CREATOR = new Parcelable.Creator<ListBean>() {
            @Override
            public ListBean createFromParcel(Parcel source) {
                return new ListBean(source);
            }

            @Override
            public ListBean[] newArray(int size) {
                return new ListBean[size];
            }
        };
    }
}
