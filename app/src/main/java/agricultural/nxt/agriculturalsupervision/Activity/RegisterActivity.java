package agricultural.nxt.agriculturalsupervision.Activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nxt.zyl.util.ZSnackBarUtils;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.et_account)
    EditText et_account;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_confirm_pwd)
    EditText et_confirm_pwd;
    @BindView(R.id.btn_register)
    Button btn_register;
    @BindView(R.id.tv_login)
    TextView tv_login;
    @BindView(R.id.tv_forget_pwd)
    TextView tv_froget_pwd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("注册");
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_login.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @OnClick(R.id.btn_register) void register(){
        String userName = et_account.getText().toString().trim();
        String passWord = et_password.getText().toString().trim();
        String confirm_pwd = et_confirm_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(userName)|TextUtils.isEmpty(passWord)|TextUtils.isEmpty(confirm_pwd)){
            ZSnackBarUtils.showShort(toolBar,"账号或密码不能为空!");
            return;
        }
        if (!TextUtils.equals(passWord,confirm_pwd)){
            ZSnackBarUtils.showShort(toolBar,"两次输入的密码不相同!");
            return;
        }



    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;
    }


}
