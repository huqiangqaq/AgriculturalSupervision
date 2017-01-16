package agricultural.nxt.agriculturalsupervision.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by huqiang on 2017/1/16 16:42.
 */

public class Supplier {

    /**
     * pageNo : 1
     * pageSize : 20
     * count : 2
     * list : [{"id":"557f825c12db4437bf75f38db0cf5aca","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-16 16:10:54","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-16 16:10:54","vcmycustomername":"新的一年","vccorporation":"沐浴液","vcidnumber":"360121199302233513","vcphone":"13131","vcaddress":"南昌市","vcemail":"51323","townerId":"71d53e9e3ec94472a1dd427c01c0a2b1"},{"id":"6a30f387f21c46e6ac2290f54f750997","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-16 16:06:59","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-16 16:06:59","vcmycustomername":"胡强01","vccorporation":"胡强","vcidnumber":"360121199302233513","vcphone":"13131","vcaddress":"南昌市","vcemail":"51323","townerId":"71d53e9e3ec94472a1dd427c01c0a2b1"}]
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');" onclick="this.select();"/> / <input type="text" value="20" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 2 条</a></li>
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
         * id : 557f825c12db4437bf75f38db0cf5aca
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2017-01-16 16:10:54
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2017-01-16 16:10:54
         * vcmycustomername : 新的一年
         * vccorporation : 沐浴液
         * vcidnumber : 360121199302233513
         * vcphone : 13131
         * vcaddress : 南昌市
         * vcemail : 51323
         * townerId : 71d53e9e3ec94472a1dd427c01c0a2b1
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private UpdateByBean updateBy;
        private String updateDate;
        private String vcmycustomername;
        private String vccorporation;
        private String vcidnumber;
        private String vcphone;
        private String vcaddress;
        private String vcemail;
        private String townerId;

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

        public String getVcmycustomername() {
            return vcmycustomername;
        }

        public void setVcmycustomername(String vcmycustomername) {
            this.vcmycustomername = vcmycustomername;
        }

        public String getVccorporation() {
            return vccorporation;
        }

        public void setVccorporation(String vccorporation) {
            this.vccorporation = vccorporation;
        }

        public String getVcidnumber() {
            return vcidnumber;
        }

        public void setVcidnumber(String vcidnumber) {
            this.vcidnumber = vcidnumber;
        }

        public String getVcphone() {
            return vcphone;
        }

        public void setVcphone(String vcphone) {
            this.vcphone = vcphone;
        }

        public String getVcaddress() {
            return vcaddress;
        }

        public void setVcaddress(String vcaddress) {
            this.vcaddress = vcaddress;
        }

        public String getVcemail() {
            return vcemail;
        }

        public void setVcemail(String vcemail) {
            this.vcemail = vcemail;
        }

        public String getTownerId() {
            return townerId;
        }

        public void setTownerId(String townerId) {
            this.townerId = townerId;
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
            dest.writeString(this.vcmycustomername);
            dest.writeString(this.vccorporation);
            dest.writeString(this.vcidnumber);
            dest.writeString(this.vcphone);
            dest.writeString(this.vcaddress);
            dest.writeString(this.vcemail);
            dest.writeString(this.townerId);
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
            this.vcmycustomername = in.readString();
            this.vccorporation = in.readString();
            this.vcidnumber = in.readString();
            this.vcphone = in.readString();
            this.vcaddress = in.readString();
            this.vcemail = in.readString();
            this.townerId = in.readString();
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
