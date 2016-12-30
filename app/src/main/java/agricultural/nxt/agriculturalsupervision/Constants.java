package agricultural.nxt.agriculturalsupervision;

/**
 * Created by huqiang on 2016/11/14 10:21.
 */

public interface Constants {
    String BASE_URL = "http://192.168.10.11:8080/jeesite/a";
    String URL = "http://192.168.10.11:8080/jeesite";
    //登陆http://zs.yxag.gov.cn:8081/nzgl
    String LOGIN_URL = BASE_URL + "/login";
    //退出登陆
    String LOGOUT = BASE_URL + "/mobileLogout";
    //注册
    String REGISTER_URL = BASE_URL + "/sys/appUser/register";
    //获取用户菜单列表
    String GETMENULIST = BASE_URL + "/sys/menu/getMenuList";
    //公告
    String ANNOUNCEMENT = BASE_URL + "/login?username=%s&password=%s";
    //诚信
    String INTEGRITY = URL + "/credit/appIllegalinfo/list?pageNo=1&pageSize=";
    String INTEGRITY_DEL = URL + "/credit/appIllegalinfo/delete?id=";
    String INTEGRITY_DETAIL = URL + "/credit/appIllegalinfo/form?id=";
    String INTEGRITY_ADD = URL + "/credit/appIllegalinfo/save";
    String INTEGRITY_CHECK = URL + "/credit/appIllegalinfo/check";
    String INTEGRITY_SEARCH = URL + "/credit/appIllegalinfo/list";
    //种子备案
    String SEED_RECODE = URL + "/product/appSeed/list?pageNo=1&pageSize=";
    //查看种子备案
    String SEED_RECODE_VIEW = URL + "/product/appSeed/selectList?pageNo=1&pageSize=";
}
