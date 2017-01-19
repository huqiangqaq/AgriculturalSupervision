package agricultural.nxt.agriculturalsupervision.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by huqiang on 2017/1/19 11:33.
 */

public class PurPesticide {


    /**
     * pageNo : 1
     * pageSize : 20
     * count : 1
     * list : [{"id":"58c4bde330dc49dc8dc7cf1a1c5d07d4","isNewRecord":false,"remarks":"采购农药","createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-11-15 15:05:59","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2016-11-15 15:05:59","fponumber":"2","fprice":"2","vcunit":"瓶","dtpodate":1479107929000,"poh":{"id":"2016111515191863","isNewRecord":false,"tMysupplierName":"小飞哥农产品生产企业","tmysupplierId":"f4b31e3acf784b718b771e222fff0d2a"},"pesticide":{"id":"82943343a2b4499db4975c348a8f2e88","isNewRecord":false,"vcpesticidename":"代森锰锌"},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpesticideId":"82943343a2b4499db4975c348a8f2e88","tpohId":"2016111515191863"}]
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');" onclick="this.select();"/> / <input type="text" value="20" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 1 条</a></li>
     </ul>
     <div style="clear:both;"></div>
     * firstResult : 0
     * maxResults : 20
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

    public static class ListBean implements Parcelable {

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
         * poh : {"id":"2016111515191863","isNewRecord":false,"tMysupplierName":"小飞哥农产品生产企业","tmysupplierId":"f4b31e3acf784b718b771e222fff0d2a"}
         * pesticide : {"id":"82943343a2b4499db4975c348a8f2e88","isNewRecord":false,"vcpesticidename":"代森锰锌"}
         * owner : {"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]}
         * tpesticideId : 82943343a2b4499db4975c348a8f2e88
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
        private String dtpodate;
        private PohBean poh;
        private PesticideBean pesticide;
        private OwnerBean owner;
        private String tpesticideId;
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

        public String getDtpodate() {
            return dtpodate;
        }

        public void setDtpodate(String dtpodate) {
            this.dtpodate = dtpodate;
        }

        public PohBean getPoh() {
            return poh;
        }

        public void setPoh(PohBean poh) {
            this.poh = poh;
        }

        public PesticideBean getPesticide() {
            return pesticide;
        }

        public void setPesticide(PesticideBean pesticide) {
            this.pesticide = pesticide;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public String getTpesticideId() {
            return tpesticideId;
        }

        public void setTpesticideId(String tpesticideId) {
            this.tpesticideId = tpesticideId;
        }

        public String getTpohId() {
            return tpohId;
        }

        public void setTpohId(String tpohId) {
            this.tpohId = tpohId;
        }

        public static class CreateByBean implements Parcelable {

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.loginFlag);
                dest.writeString(this.roleNames);
                dest.writeByte(this.admin ? (byte) 1 : (byte) 0);
            }

            public CreateByBean() {
            }

            protected CreateByBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.loginFlag = in.readString();
                this.roleNames = in.readString();
                this.admin = in.readByte() != 0;
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.loginFlag);
                dest.writeString(this.roleNames);
                dest.writeByte(this.admin ? (byte) 1 : (byte) 0);
            }

            public UpdateByBean() {
            }

            protected UpdateByBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.loginFlag = in.readString();
                this.roleNames = in.readString();
                this.admin = in.readByte() != 0;
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

        public static class PohBean implements Parcelable {

            /**
             * id : 2016111515191863
             * isNewRecord : false
             * tMysupplierName : 小飞哥农产品生产企业
             * tmysupplierId : f4b31e3acf784b718b771e222fff0d2a
             */

            private String id;
            private boolean isNewRecord;
            private String tMysupplierName;
            private String tmysupplierId;

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

            public String getTMysupplierName() {
                return tMysupplierName;
            }

            public void setTMysupplierName(String tMysupplierName) {
                this.tMysupplierName = tMysupplierName;
            }

            public String getTmysupplierId() {
                return tmysupplierId;
            }

            public void setTmysupplierId(String tmysupplierId) {
                this.tmysupplierId = tmysupplierId;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.tMysupplierName);
                dest.writeString(this.tmysupplierId);
            }

            public PohBean() {
            }

            protected PohBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.tMysupplierName = in.readString();
                this.tmysupplierId = in.readString();
            }

            public static final Creator<PohBean> CREATOR = new Creator<PohBean>() {
                @Override
                public PohBean createFromParcel(Parcel source) {
                    return new PohBean(source);
                }

                @Override
                public PohBean[] newArray(int size) {
                    return new PohBean[size];
                }
            };
        }

        public static class PesticideBean implements Parcelable {

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.vcpesticidename);
            }

            public PesticideBean() {
            }

            protected PesticideBean(Parcel in) {
                this.id = in.readString();
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
            dest.writeString(this.remarks);
            dest.writeParcelable(this.createBy, flags);
            dest.writeString(this.createDate);
            dest.writeParcelable(this.updateBy, flags);
            dest.writeString(this.updateDate);
            dest.writeString(this.fponumber);
            dest.writeString(this.fprice);
            dest.writeString(this.vcunit);
            dest.writeString(this.dtpodate);
            dest.writeParcelable(this.poh, flags);
            dest.writeParcelable(this.pesticide, flags);
            dest.writeParcelable(this.owner, flags);
            dest.writeString(this.tpesticideId);
            dest.writeString(this.tpohId);
        }

        public ListBean() {
        }

        protected ListBean(Parcel in) {
            this.id = in.readString();
            this.isNewRecord = in.readByte() != 0;
            this.remarks = in.readString();
            this.createBy = in.readParcelable(CreateByBean.class.getClassLoader());
            this.createDate = in.readString();
            this.updateBy = in.readParcelable(UpdateByBean.class.getClassLoader());
            this.updateDate = in.readString();
            this.fponumber = in.readString();
            this.fprice = in.readString();
            this.vcunit = in.readString();
            this.dtpodate = in.readString();
            this.poh = in.readParcelable(PohBean.class.getClassLoader());
            this.pesticide = in.readParcelable(PesticideBean.class.getClassLoader());
            this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
            this.tpesticideId = in.readString();
            this.tpohId = in.readString();
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
