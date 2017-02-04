package agricultural.nxt.agriculturalsupervision.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by huqiang on 2017/2/4 13:18.
 */

public class SaleFer {

    /**
     * pageNo : 1
     * pageSize : 20
     * count : 10
     * list : [{"id":"c4dc84e67a294b129b33ea70a59f0d9e","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 13:04:45","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 13:04:45","fprice":"10","fnumber":"2","vcunit":"袋","dtsodate":1479446267000,"soh":{"id":"20161118182","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"ca93115010e14cb89f35c5f6150cb691","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:19:31","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:19:31","fprice":"2","fnumber":"1","vcunit":"袋","dtsodate":1479440006000,"soh":{"id":"20161118461","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"16b2daf98bfd48c18e1567a28b848c4a","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:15:35","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:15:35","fprice":"25","fnumber":"2","vcunit":"袋","dtsodate":1479439719000,"soh":{"id":"20161118963","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"338177f16cf34ee6b183a37246f9321c","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:14:43","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:14:43","fprice":"22","fnumber":"1","vcunit":"袋","dtsodate":1479439657000,"soh":{"id":"2016111885","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"73337c841a894f239137ca4559663c31","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:14:43","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:14:43","fprice":"34","fnumber":"1","vcunit":"袋","dtsodate":1479439657000,"soh":{"id":"2016111885","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"5eba3d3b70394178bb7e1f85f04245aa","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:03:10","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:03:10","fprice":"65","fnumber":"1","vcunit":"袋","dtsodate":1479439016000,"soh":{"id":"20161118713","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"071858ca0bdf4d4a9f88565628096ae5","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-18 11:00:51","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-18 11:00:51","fprice":"80","fnumber":"1","vcunit":"袋","dtsodate":1479438874000,"soh":{"id":"20161118279","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"ccf6f25d742249f3adf3ca2f3cf6b0c5","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-17 10:11:43","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-17 10:11:43","fprice":"3","fnumber":"3","vcunit":"袋","dtsodate":1479349526000,"soh":{"id":"20161117733","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"ec94d3e97bae4a7fb87a72f6658526b4","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-17 08:51:38","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-17 08:51:38","fprice":"2","fnumber":"2","vcunit":"袋","dtsodate":1479344121000,"soh":{"id":"201611171012","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"},{"id":"30de67d34d8f479d9dc766456fa39b34","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2016-11-17 08:50:32","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-17 08:50:32","fprice":"1","fnumber":"1","vcunit":"袋","dtsodate":1479344121000,"soh":{"id":"201611171012","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}},"fertilizerbatch":{"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tfertilizerbatchId":"3f16957cb5634303ba7735154a08ee91"}]
     * firstResult : 0
     * maxResults : 20
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');" onclick="this.select();"/> / <input type="text" value="20" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 10 条</a></li>
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
         * id : c4dc84e67a294b129b33ea70a59f0d9e
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2016-11-18 13:04:45
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2016-11-18 13:04:45
         * fprice : 10
         * fnumber : 2
         * vcunit : 袋
         * dtsodate : 1479446267000
         * soh : {"id":"20161118182","isNewRecord":false,"myCustomer":{"isNewRecord":true,"vcmycustomername":"王力宏"}}
         * fertilizerbatch : {"isNewRecord":true,"vcbatchno":"2017020413182944","fertilizer":{"isNewRecord":true,"vcfertilizename":"尿素123"}}
         * owner : {"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]}
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
        private String dtsodate;
        private SohBean soh;
        private FertilizerbatchBean fertilizerbatch;
        private OwnerBean owner;
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

        public FertilizerbatchBean getFertilizerbatch() {
            return fertilizerbatch;
        }

        public void setFertilizerbatch(FertilizerbatchBean fertilizerbatch) {
            this.fertilizerbatch = fertilizerbatch;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public String getTfertilizerbatchId() {
            return tfertilizerbatchId;
        }

        public void setTfertilizerbatchId(String tfertilizerbatchId) {
            this.tfertilizerbatchId = tfertilizerbatchId;
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
             * id : 20161118182
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

        public static class FertilizerbatchBean implements Parcelable {

            /**
             * isNewRecord : true
             * vcbatchno : 2017020413182944
             * fertilizer : {"isNewRecord":true,"vcfertilizename":"尿素123"}
             */

            private boolean isNewRecord;
            private String vcbatchno;
            private FertilizerBean fertilizer;

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

            public static class FertilizerBean implements Parcelable {

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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                    dest.writeString(this.vcfertilizename);
                }

                public FertilizerBean() {
                }

                protected FertilizerBean(Parcel in) {
                    this.isNewRecord = in.readByte() != 0;
                    this.vcfertilizename = in.readString();
                }

                public static final Creator<FertilizerBean> CREATOR = new Creator<FertilizerBean>() {
                    @Override
                    public FertilizerBean createFromParcel(Parcel source) {
                        return new FertilizerBean(source);
                    }

                    @Override
                    public FertilizerBean[] newArray(int size) {
                        return new FertilizerBean[size];
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
                dest.writeParcelable(this.fertilizer, flags);
            }

            public FertilizerbatchBean() {
            }

            protected FertilizerbatchBean(Parcel in) {
                this.isNewRecord = in.readByte() != 0;
                this.vcbatchno = in.readString();
                this.fertilizer = in.readParcelable(FertilizerBean.class.getClassLoader());
            }

            public static final Creator<FertilizerbatchBean> CREATOR = new Creator<FertilizerbatchBean>() {
                @Override
                public FertilizerbatchBean createFromParcel(Parcel source) {
                    return new FertilizerbatchBean(source);
                }

                @Override
                public FertilizerbatchBean[] newArray(int size) {
                    return new FertilizerbatchBean[size];
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
            dest.writeParcelable(this.fertilizerbatch, flags);
            dest.writeParcelable(this.owner, flags);
            dest.writeString(this.tfertilizerbatchId);
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
            this.fertilizerbatch = in.readParcelable(FertilizerbatchBean.class.getClassLoader());
            this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
            this.tfertilizerbatchId = in.readString();
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
