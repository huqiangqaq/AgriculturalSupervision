package agricultural.nxt.agriculturalsupervision;

/**
 * Created by huqiang on 2016/11/14 10:21.
 */

public interface Constants {
    String BASE_URL = "http://zs.yxag.gov.cn:8081/nzgl/a";
    String URL = "http://zs.yxag.gov.cn:8081/nzgl";
    String IMG_HEAD = "http://zs.yxag.gov.cn:8081";
    //登陆http://zs.yxag.gov.cn:8081/nzgl
    String LOGIN_URL = BASE_URL + "/login";
    //退出登陆
    String LOGOUT = BASE_URL + "/mobileLogout";
    //注册
    String REGISTER_URL = BASE_URL + "/sys/appUser/register";
    String CheckCompanyName = BASE_URL+"/sys/appUser/checkCompanyName";
    //获取用户菜单列表
    String GETMENULIST = BASE_URL + "/sys/menu/getMenuList";
    //公告
    String ANNOUNCEMENT = URL + "/appNotify/notice/selfData";
    String ANNOUNCEMENT_DETAIL =URL+"/appNotify/notice/form?id=";
    //诚信
    String INTEGRITY = URL + "/credit/appIllegalinfo/list?pageNo=1&pageSize=3";
    String INTEGRITY_DEL = URL + "/credit/appIllegalinfo/delete?id=";
    String INTEGRITY_DETAIL = URL + "/credit/appIllegalinfo/form?id=";
    String INTEGRITY_ADD = URL + "/credit/appIllegalinfo/save";
    String INTEGRITY_CHECK = URL + "/credit/appIllegalinfo/check";
    String INTEGRITY_SEARCH = URL + "/credit/appIllegalinfo/list";

    /**
     * 种子
     */
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

    /**
     * 农药
     */
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

    /**
     * 化肥
     */
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



    //企业管理
    String COMPANY_MANAGER = URL+"/company/appOwner/ownerdetail";
    String COMPANY_SAVE = URL+"/company/appOwner/save";
    String COMPANY_UPTOCHECK = URL+"/company/appOwner/upTocheck";
    String COMPANY_VIEW = URL+"/company/appOwner/list?pageNo=1&pageSize=";
    String COMPANY_VIEWFORCHECK = URL+"/company/appOwner/listForCheck?pageNo=1&pageSize=";
    String COMPANY_DEL = URL+"/company/appOwner/delete?id=";
    String COMPANY_CHECK   = URL+"/company/appOwner/checkOwner?id=";
    //农药库
    String APPPESTICIDELIB = URL+"/product/appPesticidelib/form?id=";
    //查询
    String PESTICIDELIB_LIST = URL+"/product/appPesticidelib/list?pageSize=20&pageNo=";
    //查看标签
    String LABEL = "http://www.chinapesticide.gov.cn/myquery/tagdetail?pdno=";



    //往来管理
    String CLIENT = URL+"/contact/appMyCustomer/list?pageSize=20&pageNo=";
    String CLIENT_DEL = URL+"/contact/appMyCustomer/delete?id=";
    String CLIENT_SAVE = URL+"/contact/appMyCustomer/save";
    String SUPPLIER = URL+"/contact/appMySupplier/list?pageSize=20&pageNo=";
    String SUPPLIER_DEL = URL+"/contact/appMySupplier/delete?id=";
    String SUPPLIER_SAVE = URL+"/contact/appMySupplier/save";
    //个人信息
    String MYINFO = BASE_URL+"/sys/appUser/infoData";


    //农资产品购进
    String PURCHASE = URL+"/purchase/appPoseedd/list?pageSize=20&pageNo=";
    String PURCHASE_VIEW = URL+"/purchase/appPoseedd/selectList?pageSize=20&pageNo=";
    String PURCHASE_DEL = URL+"/purchase/appPoseedd/delete?id=";
    String PURCHASE_GETSUPPLIER = URL+"/purchase/appPoseedd/selectMysupplier";
    String PURCHASE_GETSEED = URL+"/purchase/appPoseedd/selectSeedList";
    String PURCHASE_DETAIL = URL+"/purchase/appPoseedd/form?id=";
    String PURCHASE_SAVE = URL+"/purchase/appPoseedd/save";
    //农药
    String PUR_PESTICIDE = URL+"/purchase/appPopesticided/list?pageSize=20&pageNo=";
    String PUR_PESTICIDE_VIEW = URL+"/purchase/appPopesticided/selectList?pageSize=20&pageNo=";
    String PUR_PESTICIDE_DEL = URL+"/purchase/appPopesticided/delete?id=";
    String PUR_PESTICIDE_GETPEST = URL+"/purchase/appPopesticided/selectPesticideList";
    String PUR_PESTICIDE_SAVE = URL+"/purchase/appPopesticided/save";
    String PUR_PESTICIDE_DETAIL = URL+"/purchase/appPopesticided/form?id=";
    //化肥
    String PUR_FERTILIZER = URL+"/purchase/appPofertilizerd/list?pageSize=20&pageNo=";
    String PUR_FERTILIZER_VIEW = URL+"/purchase/appPofertilizerd/selectList?pageSize=20&pageNo=";
    String PUR_FER_DEL = URL+"/purchase/appPofertilizerd/delete?id=";
    String PUR_FER_GETFERT = URL+"/purchase/appPofertilizerd/selectFertilizerList";
    String PUR_FERT_DETAIL = URL+"/purchase/appPofertilizerd/form?id=";
    String PUR_FERT_SAVE = URL+"/purchase/appPofertilizerd/save";

    //农资产品销售
    String SALE = URL+"/market/appSoseedd/list?pageSize=20&pageNo=";
    String SALE_VIEW = URL+"/market/appSoseedd/selectList?pageSize=20&pageNo=";
    String SALE_DEL = URL+"/market/appSoseedd/delete?id=";
    String SALE_GETSUPPLIER = URL+"/market/appSoseedd/selectCustomerList";
    String SALE_GETSEED = URL+"/market/appSoseedd/selectSeedbatchList";
    String SALE_DETAIL = URL+"/market/appSoseedd/form?id=";
    String SALE_SAVE = URL+"/market/appSoseedd/save";

    //农药
    String SALE_PESTICIDE = URL+"/market/appSopesticided/list?pageSize=20&pageNo=";
    String SALE_PESTICIDE_VIEW = URL+"/market/appSopesticided/selectList?pageSize=20&pageNo=";
    String SALE_PESTICIDE_DEL = URL+"/market/appSopesticided/delete?id=";
    String SALE_PESTICIDE_GETPEST = URL+"/market/appSopesticided/selectPesticidedbatchList";
    String SALE_PESTICIDE_SAVE = URL+"/market/appSopesticided/save";
    String SALE_PESTICIDE_DETAIL = URL+"/market/appSopesticided/form?id=";

    //化肥
    String SALE_FER = URL+"/market/appSofertilizerd/list?pageSize=20&pageNo=";
    String SALE_FER_VIEW = URL+"/market/appSofertilizerd/selectList?pageSize=20&pageNo=";
    String SALE_FER_DEL = URL+"/market/appSofertilizerd/delete?id=";
    String SALE_FER_GETPEST = URL+"/market/appSofertilizerd/selectFertilizerdList";
    String SALE_FER_SAVE = URL+"/market/appSofertilizerd/save";
    String SALE_FER_DETAIL = URL+"/market/appSopesticided/form?id=";
}
