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
    @BindView(R.id.tv_01)
    TextView tv_01;
    @BindView(R.id.tv_02)
    TextView tv_02;
    @BindView(R.id.tv_03)
    TextView tv_03;
    @BindView(R.id.tv_04)
    TextView tv_04;
    @BindView(R.id.tv_05)
    TextView tv_05;
    @BindView(R.id.tv_06)
    TextView tv_06;
    @BindView(R.id.tv_07)
    TextView tv_07;

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
        list.add("农资产品销售");
        list.add("往来管理");
        list.add("企业管理");
        list.add("农资产品购进");
        list.add("农药库管理");
        list.add("电子处方");
        views.add(tv_01);
        views.add(tv_02);
        views.add(tv_03);
        views.add(tv_04);
        views.add(tv_05);
        views.add(tv_06);
        views.add(tv_07);
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
            if (i<3){
                Drawable drawable = getResources().getDrawable(resId.get(i));
                drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                tv.get(i).setCompoundDrawables(null,drawable,null,null);
                tv.get(i).setText(list.get(i));
            }else {
                tv.get(i).setBackgroundResource(resId.get(i));
            }

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
    @OnClick(R.id.tv_01) void recode(){

        StartAction(tv_01.getText().toString());

    }
    /**
     * 产品售出
     */
    @OnClick(R.id.tv_02) void sold(){
        StartAction(tv_02.getText().toString());
    }
    /**
     * 往来客户
     */
    @OnClick(R.id.tv_03) void customer(){
        StartAction(tv_03.getText().toString());
    }
    @OnClick(R.id.tv_04) void botttom4(){
        StartAction(list.get(3));
    }
    @OnClick(R.id.tv_05) void bottom5(){
        StartAction(list.get(4));
    }
    @OnClick(R.id.tv_06) void recodeSearch(){
        RecodeSearchActivity.actionStart(this);
    }
    @OnClick(R.id.tv_07) void bottom6(){
        StartAction(list.get(6));
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

    @OnClick(R.id.tv_report) void report(){
        IntegrityAddActivity.actionStart(this);
    }
    @OnClick(R.id.tv_view_more) void viewMore(){
        IntegrityMoreActivity.actionStart(this);
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
                if (i<3){
                    ids.add(R.mipmap.recode);
                }else {
                    ids.add(R.mipmap.recode_bg);
                }
            }else if ("农资产品销售".equalsIgnoreCase(newList.get(i))){
                if (i<3){
                    ids.add(R.mipmap.sold);
                }else {
                    ids.add(R.mipmap.sold_bg);
                }
            }else if ("往来管理".equalsIgnoreCase(newList.get(i))){
                if (i<3){
                    ids.add(R.mipmap.contract);
                }else {
                    ids.add(R.mipmap.contract_bg);
                }
            }else if ("农资产品购进".equalsIgnoreCase(newList.get(i))){
                if (i<3){
                    ids.add(R.mipmap.buy_bg);
                }else {
                    ids.add(R.mipmap.buy);
                }
            }else if ("企业管理".equalsIgnoreCase(newList.get(i))){
                if (i<3){
                    ids.add(R.mipmap.entrprise);
                }else {
                    ids.add(R.mipmap.entrprise_bg);
                }
            }else if ("农药库管理".equalsIgnoreCase(newList.get(i))){
                if (i<3){
                    ids.add(R.mipmap.pesticide);
                }else {
                    ids.add(R.mipmap.pesticide_bg);
                }
            }else if ("电子处方".equalsIgnoreCase(newList.get(i))){
                if (i<3){
                    ids.add(R.mipmap.electronic_bg);
                }else {
                    ids.add(R.mipmap.electronic);
                }
            }else if ("销售员管理".equalsIgnoreCase(newList.get(i))){
                if (i<3){
                    ids.add(R.mipmap.saleman);
                }else {
                    ids.add(R.mipmap.saleman_bg);
                }
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
        } else if ("农资产品销售".equalsIgnoreCase(content)){
            ProductSoldActivity.actionStart(this);
        } else if ("往来管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("农资产品购进".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("企业管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("农药库管理".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("电子处方".equalsIgnoreCase(content)){
            ZToastUtils.showShort(this,content);
        }else if ("销售员管理".equalsIgnoreCase(content)){
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
