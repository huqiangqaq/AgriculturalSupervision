package agricultural.nxt.agriculturalsupervision;

/**
 * Created by huqiang on 2016/11/14 10:21.
 */

public class Constants {
    public static final String BASE_URL = "http://192.168.10.11:8080/jeesite/a";
    public static final String URL = "http://192.168.10.11:8080/jeesite";
    //登陆http://zs.yxag.gov.cn:8081/nzgl
    public static final String LOGIN_URL = BASE_URL+"/login";
    //退出登陆
    public static final String LOGOUT = BASE_URL+"/mobileLogout";
    //注册
    public static final String REGISTER_URL = BASE_URL+"/sys/appUser/register";
    //获取用户菜单列表
    public static final String GETMENULIST = BASE_URL+"/sys/menu/getMenuList";
    //公告
    public static final String ANNOUNCEMENT = BASE_URL+"/login?username=%s&password=%s";
    //诚信
    public static final String INTEGRITY = URL+"/credit/appIllegalinfo/list?pageNo=%s&pageSize=";
    public static final String INTEGRITY_DEL = URL+"/credit/appIllegalinfo/delete?id=";
    public static final String INTEGRITY_DETAIL = URL+"/credit/appIllegalinfo/form?id=";
    public static final String INTEGRITY_ADD = URL+"/credit/appIllegalinfo/save";
    public static final String INTEGRITY_CHECK = URL+"/credit/appIllegalinfo/check";
    public static final String INTEGRITY_SEARCH = URL+"/credit/appIllegalinfo/list";
    //种子备案
    public static final String SEED_RECODE = URL+"/product/appSeed/list?";
}
