package agricultural.nxt.agriculturalsupervision.Activity.Integrity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class IntegrityCheckActivity extends BaseActivity {
    @BindView(R.id.dtarosedate)
    TextView tv_dtarosedate;
    @BindView(R.id.vcillegalcomp)
    TextView tv_vcillegalcomp;
    @BindView(R.id.iproducttype)
    TextView tv_iproducttype;
    @BindView(R.id.vcillegalprod)
    TextView tv_vcillegalprod;
    @BindView(R.id.vcdesc)
    TextView tv_vcdesc;
    @BindView(R.id.icheckstatus)
    NiceSpinner sp_icheckstatus;
    @BindView(R.id.vcpunishment)
    EditText et_vcpunishment;
    @BindView(R.id.dtcheckdate)
    TextView tv_dtcheckdate;
    @BindView(R.id.btn_save)
    Button btn_save;
    private List<String> dataset = new LinkedList<>(Arrays.asList("审核未通过", "审核通过"));
    private String icheckstatus,vcpunishment,id;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        tv_dtarosedate.setText(intent.getStringExtra("dtarosedate"));
        tv_vcillegalcomp.setText(intent.getStringExtra("vcillegalcomp"));
        tv_iproducttype.setText(intent.getStringExtra("iproducttype"));
        tv_vcillegalprod.setText(intent.getStringExtra("vcillegalprod"));
        tv_vcdesc.setText(intent.getStringExtra("vcdesc"));
        sp_icheckstatus.attachDataSource(dataset);
        sp_icheckstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String status = dataset.get(position);
                if ("审核未通过".equalsIgnoreCase(status)){
                    icheckstatus = "0";
                }else if ("审核通过".equalsIgnoreCase(status)){
                    icheckstatus = "1";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tv_dtcheckdate.setText(getCurrentTime());
    }

    private String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return  df.format(new Date());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_integrity_check;
    }
    @OnClick(R.id.btn_save) void  Save(){
        vcpunishment = et_vcpunishment.getText().toString().trim();
        Map map =new HashMap();
        map.put("id",id);
        map.put("icheckstatus",icheckstatus);
        map.put("vcpunishment",vcpunishment);
        showLoadingDialog(R.string.loading);
        OkhttpHelper.Post(Constants.INTEGRITY_CHECK, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))){
                    new SweetAlertDialog(IntegrityCheckActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setConfirmText("审核成功")
                            .show();
                }else {
                    new SweetAlertDialog(IntegrityCheckActivity.this,SweetAlertDialog.ERROR_TYPE)
                            .setConfirmText("审核失败,"+JsonUtil.ParseMsg(response))
                            .show();
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
