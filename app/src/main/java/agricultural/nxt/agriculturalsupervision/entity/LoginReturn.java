package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2016/12/20 8:55.
 */

public class LoginReturn {


    /**
     * checkstatus : true
     * menuList : [{"id":"27","isNewRecord":false,"createDate":"2013-05-27 08:00:00","updateDate":"2013-05-27 08:00:00","parentIds":"0,1,","name":"我的面板","sort":100,"isShow":"1","parentId":"1"},{"id":"ecb9c32f55ae49f6ab4cffdc88db8eea","isNewRecord":false,"remarks":"","createDate":"2016-10-24 14:53:18","updateDate":"2016-10-24 14:53:18","parentIds":"0,1,","name":"通知通告","href":"","target":"","icon":"","sort":4000,"isShow":"1","permission":"","parentId":"1"},{"id":"53bffd86f471415e89390b4050209000","isNewRecord":false,"remarks":"","createDate":"2016-10-17 17:31:34","updateDate":"2016-10-17 17:31:34","parentIds":"0,1,","name":"产品备案","href":"","target":"","icon":"","sort":5030,"isShow":"1","permission":"","parentId":"1"},{"id":"bd7038eea280476ab4051706929c2da3","isNewRecord":false,"remarks":"","createDate":"2016-10-18 16:56:04","updateDate":"2016-10-18 16:56:04","parentIds":"0,1,","name":"企业管理","href":"","target":"","icon":"","sort":5060,"isShow":"1","permission":"","parentId":"1"},{"id":"6c968da773ef44e68532e1c81bcc5dab","isNewRecord":false,"remarks":"","createDate":"2016-10-19 17:09:54","updateDate":"2016-10-19 17:09:54","parentIds":"0,1,","name":"往来管理","href":"","target":"","icon":"","sort":5090,"isShow":"1","permission":"","parentId":"1"},{"id":"be79eb6f33ba4c438c37a8f5ebf34b88","isNewRecord":false,"remarks":"农资产品购进","createDate":"2016-10-20 15:12:45","updateDate":"2016-10-20 15:12:45","parentIds":"0,1,","name":"农资产品购进","href":"","target":"","icon":"","sort":5120,"isShow":"1","permission":"","parentId":"1"},{"id":"1f8bc0de65c04cff890de246881f7351","isNewRecord":false,"remarks":"农资产品销售","createDate":"2016-10-27 14:57:35","updateDate":"2016-10-27 14:57:35","parentIds":"0,1,","name":"农资产品销售","href":"","target":"","icon":"","sort":5150,"isShow":"1","permission":"","parentId":"1"},{"id":"382d6934317b40eeb818489248105852","isNewRecord":false,"remarks":"","createDate":"2016-10-27 15:00:37","updateDate":"2016-10-27 15:00:37","parentIds":"0,1,","name":"诚信经营","href":"","target":"","icon":"","sort":5150,"isShow":"1","permission":"","parentId":"1"},{"id":"3e222d5a98c84dfa9923e333339f3321","isNewRecord":false,"remarks":"农药库管理","createDate":"2016-11-03 08:05:09","updateDate":"2016-11-03 08:05:09","parentIds":"0,1,","name":"农药库管理","href":"","target":"","icon":"","sort":5180,"isShow":"1","permission":"","parentId":"1"},{"id":"31142861b127425d8bddbe89bf623a19","isNewRecord":false,"remarks":"","createDate":"2016-12-01 14:57:32","updateDate":"2016-12-01 14:57:32","parentIds":"0,1,","name":"电子处方","href":"","target":"","icon":"","sort":5210,"isShow":"1","permission":"","parentId":"1"}]
     * userInfo : {"id":"124342ec97ae400ab942ecafca20547a","loginName":"刘建设","name":"刘建设","mobileLogin":true,"sessionid":"89ac6c41401645b196d6c42748429b65"}
     * msg : 当前账号已登陆!
     * success : true
     */

    private String checkstatus;
    private UserInfoBean userInfo;
    private String msg;
    private String success;
    private List<MenuListBean> menuList;

    public String getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(String checkstatus) {
        this.checkstatus = checkstatus;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

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

    public List<MenuListBean> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuListBean> menuList) {
        this.menuList = menuList;
    }

    public static class UserInfoBean {
        /**
         * id : 124342ec97ae400ab942ecafca20547a
         * loginName : 刘建设
         * name : 刘建设
         * mobileLogin : true
         * sessionid : 89ac6c41401645b196d6c42748429b65
         */

        private String id;
        private String loginName;
        private String name;
        private boolean mobileLogin;
        private String sessionid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isMobileLogin() {
            return mobileLogin;
        }

        public void setMobileLogin(boolean mobileLogin) {
            this.mobileLogin = mobileLogin;
        }

        public String getSessionid() {
            return sessionid;
        }

        public void setSessionid(String sessionid) {
            this.sessionid = sessionid;
        }
    }

    public static class MenuListBean {
        /**
         * id : 27
         * isNewRecord : false
         * createDate : 2013-05-27 08:00:00
         * updateDate : 2013-05-27 08:00:00
         * parentIds : 0,1,
         * name : 我的面板
         * sort : 100
         * isShow : 1
         * parentId : 1
         * remarks :
         * href :
         * target :
         * icon :
         * permission :
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String parentIds;
        private String name;
        private int sort;
        private String isShow;
        private String parentId;
        private String remarks;
        private String href;
        private String target;
        private String icon;
        private String permission;

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

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getParentIds() {
            return parentIds;
        }

        public void setParentIds(String parentIds) {
            this.parentIds = parentIds;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getIsShow() {
            return isShow;
        }

        public void setIsShow(String isShow) {
            this.isShow = isShow;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getPermission() {
            return permission;
        }

        public void setPermission(String permission) {
            this.permission = permission;
        }
    }
}
