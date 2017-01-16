package agricultural.nxt.agriculturalsupervision.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by huqiang on 2017/1/16 9:43.
 */

public class Lib {

        /**
         * pageNo : 1
         * pageSize : 10
         * count : 8804
         * list : [{"isNewRecord":true,"remarks":"","createDate":"2016-10-31 15:42:42","updateBy":{"id":"系统管理员","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"updateDate":"2016-11-09 15:36:23","registrationNo":"PD20110064","name":"滴丁·乙草胺","companyName":"辽宁三征化学有限公司","toxicity":"低毒","compositionAndContent":"2,4-滴丁酯 28%、乙草胺 50%","validity":"2016.01.11-2021.01.11","formulation":"乳油","registrationCropName":"春玉米田","preventObjectName":"一年生杂草","dosage":"2372.6-2565克/公顷","applicationMethod":"播后苗前土壤喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:41","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110001","name":"2甲4氯钠","companyName":"山东省济南绿邦化工有限公司","toxicity":"低毒","compositionAndContent":"2甲4氯钠 56%","validity":"2016.01.04-2021.01.04","formulation":"可溶粉剂","registrationCropName":"小麦田","preventObjectName":"一年生阔叶杂草","dosage":"1008-1260克/公顷","applicationMethod":"茎叶喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110002","name":"毒死蜱","companyName":"天津市施普乐农药技术发展有限公司","toxicity":"中等毒","compositionAndContent":"毒死蜱 480克/升","validity":"2016.01.04-2021.01.04","formulation":"乳油","registrationCropName":"水稻","preventObjectName":"稻纵卷叶螟","dosage":"450-600克/公顷","applicationMethod":"喷雾"},{"isNewRecord":true,"remarks":"甲氨基阿维菌素苯甲酸盐含量：3.4%。","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110003","name":"甲氨基阿维菌素苯甲酸盐","companyName":"陕西标正作物科学有限公司","toxicity":"低毒","compositionAndContent":"甲氨基阿维菌素 3%","validity":"2016.01.04-2021.01.04","formulation":"微乳剂","registrationCropName":"甘蓝","preventObjectName":"甜菜夜蛾","dosage":"2.25-45克/公顷","applicationMethod":"喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110004","name":"丙酰芸苔素内酯","companyName":"江苏龙灯化学有限公司","toxicity":"低毒","compositionAndContent":"丙酰芸苔素内酯 0.003%","validity":"2016.01.04-2021.01.04","formulation":"水剂","registrationCropName":"葡萄","preventObjectName":"促进生长","dosage":"3000-5000倍液","applicationMethod":"喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110005","name":"灭幼脲","companyName":"陕西喷得绿生物科技有限公司","toxicity":"低毒","compositionAndContent":"灭幼脲 25%","validity":"2016.01.04-2021.01.04","formulation":"悬浮剂","registrationCropName":"甘蓝","preventObjectName":"菜青虫","dosage":"56.25-75克/公顷","applicationMethod":"喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110006","name":"烟嘧磺隆","companyName":"海南博士威农用化学有限公司","toxicity":"低毒","compositionAndContent":"烟嘧磺隆 40克/升","validity":"2016.01.04-2021.01.04","formulation":"可分散油悬浮剂","registrationCropName":"玉米田","preventObjectName":"一年生杂草","dosage":"40-60克/升","applicationMethod":"茎叶喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110007","name":"乙草胺","companyName":"郑州豫珠恒力生物科技有限责任公司","toxicity":"低毒","compositionAndContent":"乙草胺 40%","validity":"2016.01.04-2021.01.04","formulation":"水乳剂","registrationCropName":"花生田","preventObjectName":"一年生禾本科杂草及阔叶杂草","dosage":"1260-1440克/公顷","applicationMethod":"土壤喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110008","name":"阿维菌素","companyName":"河北金德伦生化科技有限公司","toxicity":"中等毒(原药高毒)","compositionAndContent":"阿维菌素 5%","validity":"2016.01.04-2021.01.04","formulation":"乳油","registrationCropName":"甘蓝","preventObjectName":"菜青虫","dosage":"8.1-10.5毫升/公顷","applicationMethod":"喷雾"},{"isNewRecord":true,"remarks":"null","createDate":"2016-10-31 15:42:42","updateDate":"0001-01-01 00:00:00","registrationNo":"PD20110009","name":"阿维菌素","companyName":"山东兴禾作物科学技术有限公司","toxicity":"中等毒(原药高毒)","compositionAndContent":"阿维菌素 1.8%","validity":"2016.01.04-2021.01.04","formulation":"乳油","registrationCropName":"甘蓝","preventObjectName":"小菜蛾","dosage":"6-9克/公顷","applicationMethod":"喷雾"}]
         * html : <ul>
         <li class="disabled"><a href="javascript:">« 上一页</a></li>
         <li class="active"><a href="javascript:">1</a></li>
         <li><a href="javascript:" onclick="page(2,10,'');">2</a></li>
         <li><a href="javascript:" onclick="page(3,10,'');">3</a></li>
         <li><a href="javascript:" onclick="page(4,10,'');">4</a></li>
         <li><a href="javascript:" onclick="page(5,10,'');">5</a></li>
         <li><a href="javascript:" onclick="page(6,10,'');">6</a></li>
         <li><a href="javascript:" onclick="page(7,10,'');">7</a></li>
         <li><a href="javascript:" onclick="page(8,10,'');">8</a></li>
         <li class="disabled"><a href="javascript:">...</a></li>
         <li><a href="javascript:" onclick="page(881,10,'');">881</a></li>
         <li><a href="javascript:" onclick="page(2,10,'');">下一页 »</a></li>
         <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,10,'');" onclick="this.select();"/> / <input type="text" value="10" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 8804 条</a></li>
         </ul>
         <div style="clear:both;"></div>
         * firstResult : 0
         * maxResults : 10
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
             * isNewRecord : true
             * remarks :
             * createDate : 2016-10-31 15:42:42
             * updateBy : {"id":"系统管理员","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
             * updateDate : 2016-11-09 15:36:23
             * registrationNo : PD20110064
             * name : 滴丁·乙草胺
             * companyName : 辽宁三征化学有限公司
             * toxicity : 低毒
             * compositionAndContent : 2,4-滴丁酯 28%、乙草胺 50%
             * validity : 2016.01.11-2021.01.11
             * formulation : 乳油
             * registrationCropName : 春玉米田
             * preventObjectName : 一年生杂草
             * dosage : 2372.6-2565克/公顷
             * applicationMethod : 播后苗前土壤喷雾
             */

            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private UpdateByBean updateBy;
            private String updateDate;
            private String registrationNo;
            private String name;
            private String companyName;
            private String toxicity;
            private String compositionAndContent;
            private String validity;
            private String formulation;
            private String registrationCropName;
            private String preventObjectName;
            private String dosage;
            private String applicationMethod;

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

            public String getRegistrationNo() {
                return registrationNo;
            }

            public void setRegistrationNo(String registrationNo) {
                this.registrationNo = registrationNo;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getToxicity() {
                return toxicity;
            }

            public void setToxicity(String toxicity) {
                this.toxicity = toxicity;
            }

            public String getCompositionAndContent() {
                return compositionAndContent;
            }

            public void setCompositionAndContent(String compositionAndContent) {
                this.compositionAndContent = compositionAndContent;
            }

            public String getValidity() {
                return validity;
            }

            public void setValidity(String validity) {
                this.validity = validity;
            }

            public String getFormulation() {
                return formulation;
            }

            public void setFormulation(String formulation) {
                this.formulation = formulation;
            }

            public String getRegistrationCropName() {
                return registrationCropName;
            }

            public void setRegistrationCropName(String registrationCropName) {
                this.registrationCropName = registrationCropName;
            }

            public String getPreventObjectName() {
                return preventObjectName;
            }

            public void setPreventObjectName(String preventObjectName) {
                this.preventObjectName = preventObjectName;
            }

            public String getDosage() {
                return dosage;
            }

            public void setDosage(String dosage) {
                this.dosage = dosage;
            }

            public String getApplicationMethod() {
                return applicationMethod;
            }

            public void setApplicationMethod(String applicationMethod) {
                this.applicationMethod = applicationMethod;
            }

            public static class UpdateByBean implements Parcelable {

                /**
                 * id : 系统管理员
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
                dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
                dest.writeString(this.remarks);
                dest.writeString(this.createDate);
                dest.writeParcelable(this.updateBy, flags);
                dest.writeString(this.updateDate);
                dest.writeString(this.registrationNo);
                dest.writeString(this.name);
                dest.writeString(this.companyName);
                dest.writeString(this.toxicity);
                dest.writeString(this.compositionAndContent);
                dest.writeString(this.validity);
                dest.writeString(this.formulation);
                dest.writeString(this.registrationCropName);
                dest.writeString(this.preventObjectName);
                dest.writeString(this.dosage);
                dest.writeString(this.applicationMethod);
            }

            public ListBean() {
            }

            protected ListBean(Parcel in) {
                this.isNewRecord = in.readByte() != 0;
                this.remarks = in.readString();
                this.createDate = in.readString();
                this.updateBy = in.readParcelable(UpdateByBean.class.getClassLoader());
                this.updateDate = in.readString();
                this.registrationNo = in.readString();
                this.name = in.readString();
                this.companyName = in.readString();
                this.toxicity = in.readString();
                this.compositionAndContent = in.readString();
                this.validity = in.readString();
                this.formulation = in.readString();
                this.registrationCropName = in.readString();
                this.preventObjectName = in.readString();
                this.dosage = in.readString();
                this.applicationMethod = in.readString();
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


