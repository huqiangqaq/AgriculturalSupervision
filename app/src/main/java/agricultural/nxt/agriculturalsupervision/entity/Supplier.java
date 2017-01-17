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
     * count : 12
     * list : [{"id":"9ceef6d6a8b94607a6ca90dc04176a69","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-17 13:06:31","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-17 13:06:31","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"谢许鑫","vccorporation":"谢许鑫","vcphone":"123","vcbizlicedate":"2017-01-17 00:00:00","vcproductlicense":"81414","dtprodlicendate":"2019-01-17 00:00:00"},{"id":"2b0cdc07a6114b3f83d61af7cae255bf","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-16 16:32:03","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-16 16:32:03","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"我","vccorporation":"你","vcphone":"15846464","vcbizlicedate":"2017-01-09 00:00:00","vcbizlicepic":"|/nzgl/userfiles/124342ec97ae400ab942ecafca20547a/files/contact/mySupplier/2017/01/logo.png","dtprodlicendate":"2017-05-05 00:00:00"},{"id":"5e968a7c6fd94f438cec1f2a8fb2eca6","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-09 15:18:24","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-09 15:18:24","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"我","vccorporation":"你","vcphone":"15846464","vcbizlicedate":"2017-01-09 00:00:00","dtprodlicendate":"2017-05-05 00:00:00"},{"id":"2432ecad962e4fbfa0a50447a1f50c0c","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-09 15:18:06","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-09 15:18:06","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"我","vccorporation":"你","vcphone":"15846464","vcbizlicedate":"2017-01-09 00:00:00","dtprodlicendate":"2017-05-05 00:00:00"},{"id":"73623d7fd90c471db31604adc1eb79a3","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-09 15:09:34","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-09 15:09:34","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"水稻种子公司0002","vcbizlicedate":"2016-12-09 00:00:00"},{"id":"3e7c0db0981543b4a28e0fb6a94a15e5","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-09 15:01:18","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-09 15:01:18","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"水稻种子公司","vcbizlicedate":"2016-12-09 00:00:00"},{"id":"09b70df0102b4a8fb6f8ded5875782c5","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-03 21:28:15","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-03 21:28:15","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"bbb","vcbizlicedate":"2020-11-20 05:14:41"},{"id":"b0c56c1eea084b32ad82c64009ca0353","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-03 17:13:40","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-03 17:13:40","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"梁咏琪","vcaddress":"13344445555","vcbizlicedate":"2017-07-08 17:26:51","dtprodlicendate":"2017-02-11 17:27:00"},{"id":"7a2bffe975ff447689a3ce240b31828a","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-03 17:08:22","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-03 17:08:22","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"刘某某","vcphone":"13366668888","dtprodlicendate":"2017-01-03 17:21:17"},{"id":"1e506fd809624e6d952a5a750c40aa30","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-03 15:08:55","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-03 15:08:55","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"江西制药","vccorporation":"刘明","vcphone":"123","vcaddress":"江西","vcemail":"111","vcbizlicense":"111111","vcproductlicense":"1111"},{"id":"d463db91e9c242cca726071914d5ae71","isNewRecord":false,"createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-03 15:08:43","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-03 15:08:43","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"江西制药","vccorporation":"刘明","vcphone":"123","vcaddress":"江西","vcemail":"111"},{"id":"f4b31e3acf784b718b771e222fff0d2a","isNewRecord":false,"remarks":"小飞","createBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"createDate":"2017-01-03 10:37:02","updateBy":{"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2017-01-03 10:37:02","vcmyorgno":"71d53e9e3ec94472a1dd427c01c0a2b1","vcmysuppliername":"小飞哥农产品生产企业","vccorporation":"曾小贤","vcphone":"1234567890234","vcaddress":"湖南长沙","vcemail":"zhengxx@163.com","vcbizlicense":"zz-3878585863","vcbizlicedate":"2020-11-25 15:14:15","vcproductlicense":"sc-75687236587","dtprodlicendate":"2020-11-19 15:14:41"}]
     * html : <ul>
     <li class="disabled"><a href="javascript:">« 上一页</a></li>
     <li class="active"><a href="javascript:">1</a></li>
     <li class="disabled"><a href="javascript:">下一页 »</a></li>
     <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,20,'');" onclick="this.select();"/> / <input type="text" value="20" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 12 条</a></li>
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
         * id : 9ceef6d6a8b94607a6ca90dc04176a69
         * isNewRecord : false
         * createBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * createDate : 2017-01-17 13:06:31
         * updateBy : {"id":"刘建设","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * updateDate : 2017-01-17 13:06:31
         * vcmyorgno : 71d53e9e3ec94472a1dd427c01c0a2b1
         * vcmysuppliername : 谢许鑫
         * vccorporation : 谢许鑫
         * vcphone : 123
         * vcbizlicedate : 2017-01-17 00:00:00
         * vcproductlicense : 81414
         * dtprodlicendate : 2019-01-17 00:00:00
         * vcbizlicepic : |/nzgl/userfiles/124342ec97ae400ab942ecafca20547a/files/contact/mySupplier/2017/01/logo.png
         * vcaddress : 13344445555
         * vcemail : 111
         * vcbizlicense : 111111
         * remarks : 小飞
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private UpdateByBean updateBy;
        private String updateDate;
        private String vcmyorgno;
        private String vcmysuppliername;
        private String vccorporation;
        private String vcphone;
        private String vcbizlicedate;
        private String vcproductlicense;
        private String dtprodlicendate;
        private String vcbizlicepic;
        private String vcaddress;
        private String vcemail;
        private String vcbizlicense;
        private String remarks;
        private String vcprodlicenpic;

        public String getVcprodlicenpic() {
            return vcprodlicenpic;
        }

        public void setVcprodlicenpic(String vcprodlicenpic) {
            this.vcprodlicenpic = vcprodlicenpic;
        }

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

        public String getVcmyorgno() {
            return vcmyorgno;
        }

        public void setVcmyorgno(String vcmyorgno) {
            this.vcmyorgno = vcmyorgno;
        }

        public String getVcmysuppliername() {
            return vcmysuppliername;
        }

        public void setVcmysuppliername(String vcmysuppliername) {
            this.vcmysuppliername = vcmysuppliername;
        }

        public String getVccorporation() {
            return vccorporation;
        }

        public void setVccorporation(String vccorporation) {
            this.vccorporation = vccorporation;
        }

        public String getVcphone() {
            return vcphone;
        }

        public void setVcphone(String vcphone) {
            this.vcphone = vcphone;
        }

        public String getVcbizlicedate() {
            return vcbizlicedate;
        }

        public void setVcbizlicedate(String vcbizlicedate) {
            this.vcbizlicedate = vcbizlicedate;
        }

        public String getVcproductlicense() {
            return vcproductlicense;
        }

        public void setVcproductlicense(String vcproductlicense) {
            this.vcproductlicense = vcproductlicense;
        }

        public String getDtprodlicendate() {
            return dtprodlicendate;
        }

        public void setDtprodlicendate(String dtprodlicendate) {
            this.dtprodlicendate = dtprodlicendate;
        }

        public String getVcbizlicepic() {
            return vcbizlicepic;
        }

        public void setVcbizlicepic(String vcbizlicepic) {
            this.vcbizlicepic = vcbizlicepic;
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

        public String getVcbizlicense() {
            return vcbizlicense;
        }

        public void setVcbizlicense(String vcbizlicense) {
            this.vcbizlicense = vcbizlicense;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
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
            dest.writeString(this.vcmyorgno);
            dest.writeString(this.vcmysuppliername);
            dest.writeString(this.vccorporation);
            dest.writeString(this.vcphone);
            dest.writeString(this.vcbizlicedate);
            dest.writeString(this.vcproductlicense);
            dest.writeString(this.dtprodlicendate);
            dest.writeString(this.vcbizlicepic);
            dest.writeString(this.vcaddress);
            dest.writeString(this.vcemail);
            dest.writeString(this.vcbizlicense);
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
            this.vcmyorgno = in.readString();
            this.vcmysuppliername = in.readString();
            this.vccorporation = in.readString();
            this.vcphone = in.readString();
            this.vcbizlicedate = in.readString();
            this.vcproductlicense = in.readString();
            this.dtprodlicendate = in.readString();
            this.vcbizlicepic = in.readString();
            this.vcaddress = in.readString();
            this.vcemail = in.readString();
            this.vcbizlicense = in.readString();
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
