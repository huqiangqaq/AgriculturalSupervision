package agricultural.nxt.agriculturalsupervision.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nxt.zyl.util.CommonUtils;
import com.nxt.zyl.util.ZPreferenceUtils;
import com.nxt.zyl.util.ZSnackBarUtils;
import com.nxt.zyl.util.ZToastUtils;

import agricultural.nxt.agriculturalsupervision.Application.MyApplication;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.DoubleClickExitHelper;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.LoginReturn;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements OkhttpHelper.GetCallBack {
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPassWord)
    EditText etPassWord;
    @BindView(R.id.tv_resgister)
    TextView tv_resgister;
    @BindView(R.id.tv_forget_pwd)
    TextView tv_forget_pwd;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.ll_content)
    LinearLayout ll_content;
    private String UserName, PassWord;
    private DoubleClickExitHelper doubleClickExitHelper;
    private static final int LOGIN = 0;
    private MyApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //setcontentview之前使用，告诉Window页面切换需要动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        application = MyApplication.getInstance();
        doubleClickExitHelper = new DoubleClickExitHelper(this);
        tv_resgister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    private void login() {
        UserName = etUserName.getText().toString().trim();
        PassWord = etPassWord.getText().toString().trim();
        Intent intent = new Intent(this, MainActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }
        if (TextUtils.isEmpty(UserName) || TextUtils.isEmpty(PassWord)) {
            ZSnackBarUtils.showShort(ll_content, "账号或密码不能为空!");
            return;
        }
        if (!CommonUtils.isNetWorkConnected(this)) {
            ZSnackBarUtils.showShort(ll_content, "网络连接错误!");
            return;
        }
//        showLoadingDialog(R.string.loginprogressmsg);
//        String loginUrl = String.format(Constants.LOGIN_URL, UserName, PassWord);
//        OkhttpHelper.Get(loginUrl, this, LOGIN);

    }

    /**
     * 登陆
     */
    @OnClick(R.id.btn_login)
    void GetLogin() {
        login();
    }

    /**
     * 注册
     */
    @OnClick(R.id.tv_resgister)
    void Resgister() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    /**
     * 忘记密码
     */
    @OnClick(R.id.tv_forget_pwd)
    void ForgetPwd() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return doubleClickExitHelper.onKeyDown(keyCode, ll_content);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onSuccess(String response, int tag) {
        LoginReturn loginReturn = new Gson().fromJson(response, LoginReturn.class);
        application.setUserInfo(loginReturn.getUserInfo());
        application.setMenuList(loginReturn.getMenuList());
        //保存id信息
        for (int i = 0;i<application.getMenuList().size();i++){
            if (TextUtils.equals(application.getMenuList().get(i).getName(),"产品备案")){
                ZPreferenceUtils.setPrefString("产品备案",application.getMenuList().get(i).getId());
            }else if (TextUtils.equals(application.getMenuList().get(i).getName(),"农资产品购进")){
                ZPreferenceUtils.setPrefString("农资产品购进",application.getMenuList().get(i).getId());
            }else if (TextUtils.equals(application.getMenuList().get(i).getName(),"农资产品销售")){
                ZPreferenceUtils.setPrefString("农资产品销售",application.getMenuList().get(i).getId());
            }
        }
        String id = ZPreferenceUtils.getPrefString("农资产品购进","");
        if ("true".equalsIgnoreCase(loginReturn.getSuccess())) {
            dismissLoadingDialog();
            ZToastUtils.showShort(LoginActivity.this, "登陆成功");
            Intent intent = new Intent(this, MainActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            } else {
                startActivity(intent);
            }
        } else {
            ZSnackBarUtils.showShort(ll_content,"登陆失败，请检查用户名或密码!");
        }
    }

    @Override
    public void onFailed(String error, int tag) {
        dismissLoadingDialog();
        ZSnackBarUtils.showShort(ll_content,"登陆失败...");
    }
}

