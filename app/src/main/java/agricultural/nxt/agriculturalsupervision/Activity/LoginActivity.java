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

import com.nxt.zyl.util.CommonUtils;
import com.nxt.zyl.util.ZSnackBarUtils;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.DoubleClickExitHelper;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {
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
    private String UserName,PassWord;
    private DoubleClickExitHelper doubleClickExitHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //setcontentview之前使用，告诉Window页面切换需要动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        doubleClickExitHelper = new DoubleClickExitHelper(this);
        tv_resgister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    private void login(){
        UserName = etUserName.getText().toString().trim();
        PassWord = etPassWord.getText().toString().trim();
        Intent intent = new Intent(this,MainActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else {
            startActivity(intent);
        }

        if (TextUtils.isEmpty(UserName)||TextUtils.isEmpty(PassWord)){
            ZSnackBarUtils.showShort(ll_content,"账号或密码不能为空!");
            return;
        }
        if (!CommonUtils.isNetWorkConnected(this)){
            ZSnackBarUtils.showShort(ll_content,"网络连接错误!");
            return;
        }
    }

    /**
     * 登陆
     */
    @OnClick(R.id.btn_login) void GetLogin(){
        login();
    }
    /**
     * 注册
     */
    @OnClick(R.id.tv_resgister) void Resgister(){
        startActivity(new Intent(this,RegisterActivity.class));
    }

    /**
     * 忘记密码
     */
    @OnClick(R.id.tv_forget_pwd) void ForgetPwd(){

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
           return doubleClickExitHelper.onKeyDown(keyCode,ll_content);
        }
        return super.onKeyDown(keyCode, event);
    }
}

