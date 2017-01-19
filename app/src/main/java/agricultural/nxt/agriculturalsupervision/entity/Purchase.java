package agricultural.nxt.agriculturalsupervision.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by huqiang on 2017/1/18 10:48.
 */

public class Purchase {


    /**
     * pageNo : 1
     * pageSize : 20
     * count : 5
     * list : [{"id":"8548d6f72b23420ca1cda843cfc42b24","isNewRecord":false,"createBy":{"id":"江夏舒安分水蔬菜服务公司","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-11-18 16:47:09","updateBy":{"id":"系统管理员","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2017-01-17 11:18:42","fponumber":"50","fprice":"20","vcunit":"包","dtpodate":1476349269000,"pohdId":{"id":"2016111817056627","isNewRecord":false,"tMysupplierName":"刘璋","tmysupplierId":"4c4441bec19243aaaa7ba99910284109"},"seedId":{"id":"a87031cd03c744f4be5555773de2510d","isNewRecord":false,"vcvarietyname":"水稻种子"},"owner":{"isNewRecord":true,"vcorgname":"1","ownerscopes":"","ownerscopeTypes":[""]},"tpohId":"2016111817056627"},{"id":"d08bbe5b6e094db0990a1b78b8947360","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-11-17 08:15:31","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2016-11-17 14:49:10","fponumber":"11","fprice":"11","vcunit":"袋","dtpodate":1479083309000,"pohdId":{"id":"2016111782943181","isNewRecord":false,"tMysupplierName":"小飞哥农产品生产企业","tmysupplierId":"f4b31e3acf784b718b771e222fff0d2a"},"seedId":{"id":"0f571f05aebe46ae80edc656e6748ec4","isNewRecord":false,"vcvarietyname":"二季水稻"},"owner":{"isNewRecord":true,"vcorgname":"省建设公司","ownerscopes":"","ownerscopeTypes":[""]},"tpohId":"2016111782943181"},{"id":"e7b3ae7e7eaa45e6b23e58d1e713f4e3","isNewRecord":false,"remarks":"种子很好","createBy":{"id":"芦中华","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-11-15 09:06:39","updateBy":{"id":"芦中华","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2016-11-15 09:06:39","fponumber":"2","fprice":"100","vcunit":"袋","dtpodate":1479172834000,"pohdId":{"id":"2016111592047460","isNewRecord":false,"tMysupplierName":"李四","tmysupplierId":"235cb945a02c477bba6628dc9965a96f"},"seedId":{"id":"a10b10364e1647f4abe88d1bd86c857e","isNewRecord":false,"vcvarietyname":"农信通小麦一号"},"owner":{"isNewRecord":true,"vcorgname":"农信通","ownerscopes":"","ownerscopeTypes":[""]},"tpohId":"2016111592047460"},{"id":"4fe0f64d16b04a6a96a48227d857cb4e","isNewRecord":false,"remarks":"这批种子品种很好","createBy":{"id":"系统管理员","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-11-12 14:05:16","updateBy":{"id":"系统管理员","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2016-11-12 14:05:16","fponumber":"3","fprice":"100","vcunit":"袋","dtpodate":1478931337000,"pohdId":{"id":"20161112141857413","isNewRecord":false,"tMysupplierName":"刘璋","tmysupplierId":"4c4441bec19243aaaa7ba99910284109"},"seedId":{"id":"a87031cd03c744f4be5555773de2510d","isNewRecord":false,"vcvarietyname":"水稻种子"},"owner":{"isNewRecord":true,"vcorgname":"1","ownerscopes":"","ownerscopeTypes":[""]},"tpohId":"20161112141857413"},{"id":"92cf6873905349ec8ea4dc02d58a0282","isNewRecord":false,"remarks":"21","createBy":{"id":"系统管理员","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"createDate":"2016-10-31 09:29:22","updateBy":{"id":"系统管理员","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false},"updateDate":"2016-10-31 09:29:22","fponumber":"21","fprice":"21","vcunit":"21","dtpodate":1477878357000,"pohdId":{"id":"20161031420","isNewRecord":false,"tMysupplierName":"江西德华企业有限公司","tmysupplierId":"7bc2d94d3031461a8d8124da80f5a4e6"},"seedId":{"id":"2901743ab3924ff0a1f7218de87b335e","isNewRecord":false,"vcvarietyname":"土豆种子"},"owner":{"isNewRecord":true,"vcorgname":"1","ownerscopes":"","ownerscopeTypes":[""]},"tpohId":"20161031420"}]
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');" onclick="this.select();"/> / <input type="text" value="20" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 5 条</a></li>
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
         * id : 8548d6f72b23420ca1cda843cfc42b24
         * isNewRecord : false
         * createBy : {"id":"江夏舒安分水蔬菜服务公司","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false}
         * createDate : 2016-11-18 16:47:09
         * updateBy : {"id":"系统管理员","isNewRecord":false,"loginFlag":"1","roleNames":"","admin":false}
         * updateDate : 2017-01-17 11:18:42
         * fponumber : 50
         * fprice : 20
         * vcunit : 包
         * dtpodate : 1476349269000
         * pohdId : {"id":"2016111817056627","isNewRecord":false,"tMysupplierName":"刘璋","tmysupplierId":"4c4441bec19243aaaa7ba99910284109"}
         * seedId : {"id":"a87031cd03c744f4be5555773de2510d","isNewRecord":false,"vcvarietyname":"水稻种子"}
         * owner : {"isNewRecord":true,"vcorgname":"1","ownerscopes":"","ownerscopeTypes":[""]}
         * tpohId : 2016111817056627
         * remarks : 种子很好
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private UpdateByBean updateBy;
        private String updateDate;
        private String fponumber;
        private String fprice;
        private String vcunit;
        private long dtpodate;
        private PohdIdBean pohdId;
        private SeedIdBean seedId;
        private OwnerBean owner;
        private String tpohId;
        private String remarks;

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

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public String getTpohId() {
            return tpohId;
        }

        public void setTpohId(String tpohId) {
            this.tpohId = tpohId;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public static class CreateByBean implements Parcelable {

            /**
             * id : 江夏舒安分水蔬菜服务公司
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
             * id : 系统管理员
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

        public static class PohdIdBean implements Parcelable {
            /**
             * id : 2016111817056627
             * isNewRecord : false
             * tMysupplierName : 刘璋
             * tmysupplierId : 4c4441bec19243aaaa7ba99910284109
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

            public PohdIdBean() {
            }

            protected PohdIdBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.tMysupplierName = in.readString();
                this.tmysupplierId = in.readString();
            }

            public static final Creator<PohdIdBean> CREATOR = new Creator<PohdIdBean>() {
                @Override
                public PohdIdBean createFromParcel(Parcel source) {
                    return new PohdIdBean(source);
                }

                @Override
                public PohdIdBean[] newArray(int size) {
                    return new PohdIdBean[size];
                }
            };
        }

        public static class SeedIdBean implements Parcelable {

            /**
             * id : a87031cd03c744f4be5555773de2510d
             * isNewRecord : false
             * vcvarietyname : 水稻种子
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.vcvarietyname);
            }

            public SeedIdBean() {
            }

            protected SeedIdBean(Parcel in) {
                this.id = in.readString();
                this.isNewRecord = in.readByte() != 0;
                this.vcvarietyname = in.readString();
            }

            public static final Creator<SeedIdBean> CREATOR = new Creator<SeedIdBean>() {
                @Override
                public SeedIdBean createFromParcel(Parcel source) {
                    return new SeedIdBean(source);
                }

                @Override
                public SeedIdBean[] newArray(int size) {
                    return new SeedIdBean[size];
                }
            };
        }

        public static class OwnerBean implements Parcelable {

            /**
             * isNewRecord : true
             * vcorgname : 1
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
            dest.writeString(this.fponumber);
            dest.writeString(this.fprice);
            dest.writeString(this.vcunit);
            dest.writeLong(this.dtpodate);
            dest.writeParcelable(this.pohdId, flags);
            dest.writeParcelable(this.seedId, flags);
            dest.writeParcelable(this.owner, flags);
            dest.writeString(this.tpohId);
            dest.writeString(this.remarks);
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
            this.fponumber = in.readString();
            this.fprice = in.readString();
            this.vcunit = in.readString();
            this.dtpodate = in.readLong();
            this.pohdId = in.readParcelable(PohdIdBean.class.getClassLoader());
            this.seedId = in.readParcelable(SeedIdBean.class.getClassLoader());
            this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
            this.tpohId = in.readString();
            this.remarks = in.readString();
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
