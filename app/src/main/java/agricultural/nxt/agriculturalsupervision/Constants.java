package agricultural.nxt.agriculturalsupervision;

/**
 * Created by huqiang on 2016/11/14 10:21.
 */

public class Constants {
    public static final String BASE_URL = "http://192.168.10.26:8080/jeesite/a";
    public static final String URL = "http://192.168.10.26:8080";
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
    public static final String INTEGRITY = BASE_URL+"";
    //种子备案
    public static final String SEED_RECODE = URL+"/nzgl/product/appSeed/list?";
}
