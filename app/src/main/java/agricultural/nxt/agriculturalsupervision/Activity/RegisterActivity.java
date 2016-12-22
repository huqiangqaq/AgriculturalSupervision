package agricultural.nxt.agriculturalsupervision.Activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.nxt.zyl.util.ZSnackBarUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

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
    //地区
    @BindView(R.id.et_dit)
    EditText et_dit;
    //公司全称
    @BindView(R.id.et_company)
    EditText et_company;
    //姓名
    @BindView(R.id.et_name)
    EditText et_name;
    //手机号
    @BindView(R.id.et_phone)
    EditText et_phone;

    private CityPicker cityPicker;
    private String province;//省份
    private String city;//城市
    private String district; //区县（如果设定了两级联动，那么该项返回空）
    private String code;//邮编
    private static final int REGISTER = 1;

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

    @OnClick(R.id.btn_register) void register() {
        String company = et_company.getText().toString().trim();
        String name = et_name.getText().toString().trim();
        String userName = et_account.getText().toString().trim();
        String passWord = et_password.getText().toString().trim();
        String confirm_pwd = et_confirm_pwd.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();
        if (TextUtils.isEmpty(userName) | TextUtils.isEmpty(passWord) | TextUtils.isEmpty(confirm_pwd)) {
            ZSnackBarUtils.showShort(toolBar, "内容不能为空");
            return;
        }
        if (!TextUtils.equals(passWord, confirm_pwd)) {
            ZSnackBarUtils.showShort(toolBar, "两次输入的密码不相同!");
            return;
        }
        Map<String,String> map = new HashMap<>();
        map.put("province",province);
        map.put("city",city);
        map.put("district",district);
        map.put("companyName",company);
        map.put("name",name);
        map.put("loginName",userName);
        map.put("newPassword",passWord);
        map.put("confirmNewPassword",confirm_pwd);
        map.put("mobile",phone);
        showLoadingDialog(R.string.register);
        OkhttpHelper.Post(Constants.REGISTER_URL, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                try {
                    JSONObject object = new JSONObject(response);
                    String msg = object.getString("msg");
                    String success = object.getString("success");
                    if ("true".equalsIgnoreCase(success)){
                        new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Good job!")
                                .setContentText("注册成功")
                                .show();
                    }else {
                        new SweetAlertDialog(RegisterActivity.this,SweetAlertDialog.ERROR_TYPE)
                                .setTitleText(msg)
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailed(String error, int tag) {

            }

            @Override
            public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

            }
        },REGISTER);

    }

    @OnClick(R.id.et_dit) void chooseDit() {
        cityPicker = new CityPicker.Builder(RegisterActivity.this).textSize(16)//滚轮文字的大小
                .title("地区选择")
                .titleBackgroundColor("#234Dfa") //标题背景
                .confirTextColor("#000000")
                .cancelTextColor("#000000")
                .province("江西省")
                .city("南昌市")
                .district("青山湖区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(false)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(5)
                .itemPadding(10)
                .build();
        cityPicker.show();
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                province = citySelected[0];
                city = citySelected[1];
                district = citySelected[2];
                code = citySelected[3];
                et_dit.setText(province + city  + district);
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;
    }


}
