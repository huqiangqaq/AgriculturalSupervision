package agricultural.nxt.agriculturalsupervision.entity;

import java.util.List;

/**
 * Created by huqiang on 2016/12/22 13:51.
 */

public class Menu {

    /**
     * count : 12
     * menuList : [{"id":"06a8ec6b76744ae7906c39eb193e267d","parentId":"6fc3fb884a8a44a2abccf4ca35d912c9","name":"查看种子备案","href":"/product/seed/selectList","isShow":"1"},{"id":"0c49ccd4701f41fdbd42e1c81875e8fa","parentId":"15c0b30e79aa494082120b65498e57db","name":"种子备案","href":"/product/seed/list","isShow":"1"},{"id":"64766766d4ce4dc6ad02d1121038ffd2","parentId":"fcbc987b00bb4e31b5a69c70f40fa770","name":"种子备案审核","href":"/product/seed/list","isShow":"1"},{"id":"118e58a41244432b924b0ef7cb569ce5","parentId":"fcbc987b00bb4e31b5a69c70f40fa770","name":"农药备案审核","href":"/product/pesticide/list","isShow":"1"},{"id":"ac546c0da3b74874b1276af7fbf699ca","parentId":"6fc3fb884a8a44a2abccf4ca35d912c9","name":"查看农药备案","href":"/product/pesticide/selectList","isShow":"1"},{"id":"c0d5b459fd0d4e51835a9498c4e638a8","parentId":"15c0b30e79aa494082120b65498e57db","name":"农药备案","href":"/product/pesticide/list","isShow":"1"},{"id":"2d981dcae21840729a7e95e593ee12db","parentId":"fcbc987b00bb4e31b5a69c70f40fa770","name":"化肥备案审核","href":"/product/fertilizer/list","isShow":"1"},{"id":"5a7aa25119cd4b459d14e354b55761db","parentId":"15c0b30e79aa494082120b65498e57db","name":"化肥备案","href":"/product/fertilizer/list","isShow":"1"},{"id":"7d916e2de4814396beb8f8900058472a","parentId":"6fc3fb884a8a44a2abccf4ca35d912c9","name":"查看化肥备案","href":"/product/fertilizer/selectList","isShow":"1"},{"id":"15c0b30e79aa494082120b65498e57db","parentId":"53bffd86f471415e89390b4050209000","name":"产品备案","href":"","isShow":"1"},{"id":"fcbc987b00bb4e31b5a69c70f40fa770","parentId":"53bffd86f471415e89390b4050209000","name":"产品备案审核","href":"","isShow":"1"},{"id":"6fc3fb884a8a44a2abccf4ca35d912c9","parentId":"53bffd86f471415e89390b4050209000","name":"查看产品备案","href":"","isShow":"1"}]
     */

    private int count;
    private List<MenuListBean> menuList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MenuListBean> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuListBean> menuList) {
        this.menuList = menuList;
    }

    public static class MenuListBean {
        /**
         * id : 06a8ec6b76744ae7906c39eb193e267d
         * parentId : 6fc3fb884a8a44a2abccf4ca35d912c9
         * name : 查看种子备案
         * href : /product/seed/selectList
         * isShow : 1
         */

        private String id;
        private String parentId;
        private String name;
        private String href;
        private String isShow;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getIsShow() {
            return isShow;
        }

        public void setIsShow(String isShow) {
            this.isShow = isShow;
        }
    }
}
