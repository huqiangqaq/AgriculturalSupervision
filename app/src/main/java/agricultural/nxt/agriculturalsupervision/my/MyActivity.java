package agricultural.nxt.agriculturalsupervision.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.User;
import butterknife.BindView;

public class MyActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar lettoolbar;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.mobilephone)
    EditText mobilephone;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.rolename)
    TextView roleNames;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.remark)
    TextView remark;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        lettoolbar.setLeftButtonIcon(ContextCompat.getDrawable(this, R.mipmap.icon_arrow_02));
        lettoolbar.setLeftButtonOnClickLinster(v -> finish());
        lettoolbar.setTitle("个人信息");
        OkhttpHelper.Get(Constants.MYINFO, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                if (response!=null){
                    User user = new Gson().fromJson(response,User.class);
                    name.setText(user.getName());
                    email.setText(user.getEmail());
                    email.setKeyListener(null);
                    phone.setText(user.getPhone());
                    phone.setKeyListener(null);
                    mobilephone.setText(user.getMobile());
                    mobilephone.setKeyListener(null);
                    type.setText(user.getUserType());
                    roleNames.setText(user.getRoleNames());
                    time.setText(user.getOldLoginDate());
                    remark.setText(user.getRemarks());
                }
            }
            @Override
            public void onFailed(String error, int tag) {
            }
        },1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_my;
    }

    public static void actionStart(Context mcontext){
        Intent intent =new Intent(mcontext,MyActivity.class);
        mcontext.startActivity(intent);
    }
}
