package agricultural.nxt.agriculturalsupervision;

/**
 * Created by huqiang on 2016/11/14 10:21.
 */

public interface Constants {
    String BASE_URL = "http://zs.yxag.gov.cn:8081/nzgl/a";
    String URL = "http://zs.yxag.gov.cn:8081/nzgl";
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
    //删除
    String SEED_RECODE_DEL = URL+"/product/appSeed/delete?id=";
    //详情
    String SEED_RECODE_DETAIL = URL+"/product/appSeed/form?id=";
    //修改
    String SEED_RECODE_UPDATE = URL+"/product/appSeed/save";
    //添加
    String SEED_RECODE_ADD = URL+"/product/appSeed/save";
    //审核
    String SEED_RECODE_CHECK = URL+"/product/appSeed/checkOK?id=";

    //农药备案
    String PESTICIDE_RECODE = URL+ "/product/appPesticide/list?pageNo=1&pageSize=";
    //查看农药备案
    String PESTIIDE_RECODE_VIEW = URL+"/product/appPesticide/selectList?pageNo=1&pageSize=";
    //删除
    String PESTICIDE_DEL = URL +"/product/appPesticide/delete?id=";
    //详情
    String PESTICIDE_DETAIL = URL+"/product/appPesticide/form?id=";
    //修改
    String PESTICIDE_UPDATE = URL+"/product/appPesticide/save";
    //添加
    String PESTICIDE_ADD = URL+"/product/appPesticide/save";
    //审核
    String PESTICIDE_CHECK = URL+"/product/appPesticide/checkOK?id=";

    //化肥备案
    String FERTILIZER_RECODE = URL+"/product/appFertilizer/list?pageNo=1&pageSize=";
    //查看化肥备案
    String FERTILIZER_RECODE_VIEW = URL+"/product/appPesticide/selectList?pageNo=1&pageSize=";
    //删除
    String FERTILIZER_DEL = URL+"/product/appFertilizer/delete?id=";
    //详情
    String FERTILIZER_DETAIL = URL+"/product/appFertilizer/form?id=";
    //审核
    String FERTILIZER_CHECK = URL+"/product/appFertilizer/checkOK?id=";
    //修改
    String FERTILIZER_UPDATE = URL+"/product/appFertilizer/save";
    //添加
    String FERTILIZER_ADD = URL+"/product/appFertilizer/save";
}
