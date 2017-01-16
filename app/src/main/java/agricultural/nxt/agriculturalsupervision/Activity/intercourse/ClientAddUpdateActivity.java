package agricultural.nxt.agriculturalsupervision.Activity.intercourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Client;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class ClientAddUpdateActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.vcmycustomername)
    EditText vcmycustomername;
    @BindView(R.id.vccorporation)
    EditText vccorporation;
    @BindView(R.id.vcidnumber)
    EditText vcidnumber;
    @BindView(R.id.vcphone)
    EditText vcphone;
    @BindView(R.id.vcaddress)
    EditText vcaddress;
    @BindView(R.id.vcemail)
    EditText vcemail;
    @BindView(R.id.btnUpdateAdd)
    Button btnUpdateAdd;
    private boolean isUpdate = false;
    private Client.ListBean client;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        Intent intent =getIntent();
        String type = intent.getStringExtra("type");
        client = intent.getParcelableExtra("client");
        if ("update".equals(type)){
            toolBar.setTitle("往来客户管理修改");
            isUpdate = true;
        }else {
            toolBar.setTitle("往来客户管理添加");
        }
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());

        if (isUpdate){
            vcmycustomername.setText(client.getVcmycustomername());
            vccorporation.setText(client.getVccorporation());
            vcidnumber.setText(client.getVcidnumber());
            vcphone.setText(client.getVcphone());
            vcaddress.setText(client.getVcaddress());
            vcemail.setText(client.getVcemail());
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_client_add_update;
    }

    @OnClick(R.id.btnUpdateAdd) void updateAdd(){
        Map<String,String> map = new HashMap<>();
        if (isUpdate){
            map.put("id",client.getId());
        }
        map.put("vcmycustomername",vcmycustomername.getText().toString().trim());
        map.put("vccorporation",vccorporation.getText().toString().trim());
        map.put("vcidnumber",vcidnumber.getText().toString().trim());
        map.put("vcphone",vcphone.getText().toString().trim());
        map.put("vcaddress",vcaddress.getText().toString().trim());
        map.put("vcemail",vcemail.getText().toString().trim());
        showLoadingDialog(R.string.LOADING);
        OkhttpHelper.Post(Constants.CLIENT_SAVE, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))) {
                    if (isUpdate) {
                        new SweetAlertDialog(ClientAddUpdateActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("修改成功")
                                .show();
                    } else {
                        new SweetAlertDialog(ClientAddUpdateActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("添加成功")
                                .show();
                    }

                } else {
                    if (isUpdate) {
                        new SweetAlertDialog(ClientAddUpdateActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("修改失败," + JsonUtil.ParseMsg(response))
                                .show();
                    } else {
                        new SweetAlertDialog(ClientAddUpdateActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("添加失败," + JsonUtil.ParseMsg(response))
                                .show();
                    }

                }
            }

            @Override
            public void onFailed(String error, int tag) {

            }

            @Override
            public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

            }
        },1);
    }
}
