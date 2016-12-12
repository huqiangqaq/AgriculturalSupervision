package agricultural.nxt.agriculturalsupervision.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nxt.zyl.util.ZToastUtils;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.DoubleClickExitHelper;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Zxing.activity.CaptureActivity;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements OkhttpHelper.GetCallBack {
    @BindView(R.id.layout_left) RelativeLayout rl_left;
    @BindView(R.id.tv_title) TextView tvTopBarText;
    @BindView(R.id.iv_all) ImageView iv_all;
    @BindView(R.id.userinfo) ImageView iv_userinfo;

    /**
     *
     * 通知专栏
     */
    @BindView(R.id.tv_more) TextView tv_more;

    /**
     *
     * 诚信经营
     */
    @BindView(R.id.tv_LatestNews_1) TextView tv_LatestNews_1;
    @BindView(R.id.tv_LatestNews_2) TextView tv_LatestNews_2;
    @BindView(R.id.tv_LatestNews_3) TextView tv_LatestNews_3;
    @BindView(R.id.tv_check_integrity) TextView tv_check_integrity;
    @BindView(R.id.tv_report) TextView tv_report;
    @BindView(R.id.tv_view_more) TextView tv_view_more;
    @BindView(R.id.activity_main)
    LinearLayout ll_main;
    @BindView(R.id.tv_product_recode)
    TextView tv_product_recode;

    @BindView(R.id.tv_product_sold)
    TextView tv_product_sold;

    @BindView(R.id.tv_Customers)
    TextView tv_customers;
    //备案信息查询
    @BindView(R.id.tv_recode_search)
    TextView tv_recode_search;
    private DoubleClickExitHelper doubleClickExitHelper;
    private List<String> list = new ArrayList<>();
    private  List<Integer> ids = new ArrayList<>();
    private List<TextView> views = new ArrayList<>();
    private static final int ANNOUNCEMENT = 1;
    private static final int INTEGRITY = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //setcontentview之前使用，告诉Window页面切换需要动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.slide);
            //退出时使用
            getWindow().setExitTransition(explode);
            //第一次进入时使用
            getWindow().setEnterTransition(explode);
//            //再次进入时使用
//            getWindow().setReenterTransition(explode);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        initTopbar(this,"农资电子监管系统");
        doubleClickExitHelper = new DoubleClickExitHelper(this);
        list.add("产品备案");
        list.add("产品售出");
        list.add("往来客户");
        views.add(tv_product_recode);
        views.add(tv_product_sold);
        views.add(tv_customers);
        //添加对应的模块
        addImgResource(list);
        initRes(list,views,ids);
//        /**
//         * 通知专栏
//         */
//        OkhttpHelper.Get(Constants.ANNOUNCEMENT,this,ANNOUNCEMENT);
//        /**
//         * 诚信经营
//         */
//        OkhttpHelper.Get(Constants.INTEGRITY,this,INTEGRITY);
//        Drawable drawable = getResources().getDrawable(R.mipmap.icon_sc);
//        drawable.setBounds(0,0,drawable.getMinimumHeight(),drawable.getMinimumHeight());
//        tv_product_recode.setCompoundDrawables(null,drawable,null,null);
    }

    private void initRes(List<String> list,List<TextView> tv,List<Integer> resId){
        for (int i= 0;i<list.size();i++){
            Drawable drawable = getResources().getDrawable(resId.get(i));
            drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
            tv.get(i).setCompoundDrawables(null,drawable,null,null);
            tv.get(i).setText(list.get(i));
        }

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化Topbar
     *
     * @param activity {@link android.app.Activity} 使用Topbar的Activity
     */
    protected void initTopbar(Activity activity, String titlename) {
        rl_left = (RelativeLayout) activity.findViewById(R.id.layout_left);
        tvTopBarText = (TextView) activity.findViewById(R.id.tv_title);
        tvTopBarText.setText(titlename);
    }
    /**
     * 产品备案
     */
    @OnClick(R.id.tv_product_recode) void recode(){

        StartAction(tv_product_recode.getText().toString());

    }
    /**
     * 产品售出
     */
    @OnClick(R.id.tv_product_sold) void sold(){
        StartAction(tv_product_sold.getText().toString());
    }
    /**
     * 往来客户
     */
    @OnClick(R.id.tv_Customers) void customer(){
        StartAction(tv_customers.getText().toString());
    }

    /**
     * 左侧扫描二维码
     */
    @OnClick(R.id.layout_left) void Scan(){
        //打开扫描界面扫描条形码或二维码
        Intent openCameraIntent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(openCameraIntent, 0);
    }

    /**
     * 全部板块
     */
    @OnClick(R.id.iv_all) void All(){
        ZToastUtils.showShort(this,"全部板块");
    }

    /**
     * 用户信息
     */
    @OnClick(R.id.userinfo) void UserInfo(){
        ZToastUtils.showShort(this,"用户信息");

    }


    /**
     * 通知专栏more
     */
    @OnClick(R.id.tv_more) void More(){
        AnnounceActivity.actionStart(this);
    }

    /**
     * 诚信经营
     */
    @OnClick(R.id.tv_check_integrity) void checkIntegrity(){
        IntegritySearchActivity.actionStart(this);

    }
    @OnClick(R.id.tv_recode_search) void recodeSearch(){
        RecodeSearchActivity.actionStart(this);
    }
    @OnClick(R.id.tv_report) void report(){
        ZToastUtils.showShort(this,"我要举报");
    }
    @OnClick(R.id.tv_view_more) void viewMore(){
        ZToastUtils.showShort(this,"查看更多");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");

        }
    }

    private void addImgResource(List<String> newList) {
        //添加全部模块图标资源
        for (int i=0;i<newList.size();i++){
            if ("产品备案".equalsIgnoreCase(newList.get(i))){
                ids.add(R.mipmap.icon_cp);
            }else if ("产品售出".equalsIgnoreCase(newList.get(i))){
                ids.add(R.mipmap.icon_sc);
            }else if ("往来客户".equalsIgnoreCase(newList.get(i))){
                ids.add(R.mipmap.icon_lw);
            }
        }
    }

    /**
     * 双击退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            return doubleClickExitHelper.onKeyDown(keyCode,ll_main);
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 根据模块进行跳转
     * @param content
     */
    private void StartAction(String content) {

        if ("产品备案".equalsIgnoreCase(content)) {
            ProductRecodeActivity.actionStart(this);
        } else if ("产品售出".equalsIgnoreCase(content)){
            ProductSoldActivity.actionStart(this);
        } else if ("生产区管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }
    }

    @Override
    public void onSuccess(String response, int tag) {
        switch (tag){
            case ANNOUNCEMENT:
                break;
            case INTEGRITY:
                break;
        }
    }

    @Override
    public void onFailed(String error, int tag) {

    }
}
