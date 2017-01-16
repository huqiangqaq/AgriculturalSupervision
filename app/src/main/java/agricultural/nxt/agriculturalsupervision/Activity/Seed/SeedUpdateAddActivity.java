package agricultural.nxt.agriculturalsupervision.Activity.Seed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

import static agricultural.nxt.agriculturalsupervision.R.id.vcvarietyname;

public class SeedUpdateAddActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(vcvarietyname)
    EditText tv_vcvarietyname;
    @BindView(R.id.vccategory)
    EditText tv_vccategory;
    @BindView(R.id.vcproductionunit)
    EditText tv_vcproductionunit;
    @BindView(R.id.vcbusinesslicense)
    EditText tv_vcbusinesslicense;
    @BindView(R.id.vcquarantineno)
    EditText tv_vcquarantineno;
    @BindView(R.id.sp_isTransgenic)
    NiceSpinner sp_btransgene;
    @BindView(R.id.vcuniquecode)
    EditText tv_vcuniquecode;
    @BindView(R.id.vcappraisal)
    EditText tv_vcappraisal;
    @BindView(R.id.btnUpdateAdd)
    Button btnUpdateAdd;
    private String spbtransgene = null;
    private String id = null;
    private boolean isUpdate = false;
    private List<String> dataset = new LinkedList<>(Arrays.asList("非转基因", "转基因"));
    private String url = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());

        sp_btransgene.attachDataSource(dataset);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        if ("update".equalsIgnoreCase(type)){
            isUpdate = true;
        }
        toolBar.setTitle("update".equalsIgnoreCase(type)?"种子备案修改":"种子备案添加");
        if (isUpdate){
            btnUpdateAdd.setText("修改");
            id = intent.getStringExtra("id");
            String vcvarietyname = intent.getStringExtra("vcvarietyname");
            String vccategory = intent.getStringExtra("vccategory");
            String vcproductionunit = intent.getStringExtra("vcproductionunit");
            String vcbusinesslicense = intent.getStringExtra("vcbusinesslicense");
            String vcquarantineno = intent.getStringExtra("vcquarantineno");
            String btransgene = intent.getStringExtra("btransgene");
            String vcuniquecode = intent.getStringExtra("vcuniquecode");
            String vcappraisal = intent.getStringExtra("vcappraisal");
            if ("0".equalsIgnoreCase(btransgene)){
                sp_btransgene.setSelectedIndex(0);
            }else {
                sp_btransgene.setSelectedIndex(1);
            }
            tv_vcvarietyname.setText(vcvarietyname);
            tv_vccategory.setText(vccategory);
            tv_vcproductionunit.setText(vcproductionunit);
            tv_vcbusinesslicense.setText(vcbusinesslicense);
            tv_vcquarantineno.setText(vcquarantineno);
            tv_vcuniquecode.setText(vcuniquecode);
            tv_vcappraisal.setText(vcappraisal);
        }

        sp_btransgene.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spbtransgene = dataset.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.btnUpdateAdd) void updateAdd(){
        String vcvarietyname = tv_vcvarietyname.getText().toString().trim();
        String vccategory = tv_vccategory.getText().toString().trim();
        String vcproductionunit = tv_vcproductionunit.getText().toString().trim();
        String vcbusinesslicense = tv_vcbusinesslicense.getText().toString().trim();
        String vcquarantineno = tv_vcquarantineno.getText().toString().trim();
        String vcuniquecode = tv_vcuniquecode.getText().toString().trim();
        String vcappraisal = tv_vcappraisal.getText().toString().trim();
        Map<String,String> map = new HashMap<>();
        if (isUpdate){
            map.put("id",id);
        }
        map.put("vcvarietyname",vcvarietyname);
        map.put("vccategory",vccategory);
        map.put("vcproductionunit",vcproductionunit);
        map.put("vcbusinesslicense",vcbusinesslicense);
        map.put("vcquarantineno",vcquarantineno);
        map.put("btransgene","非转基因".equalsIgnoreCase(spbtransgene)?"0":"1");
        map.put("vcuniquecode",vcuniquecode);
        map.put("vcappraisal",vcappraisal);
        showLoadingDialog(R.string.LOADING);
        if (isUpdate){
            url = Constants.SEED_RECODE_UPDATE;
        }else {
            url = Constants.SEED_RECODE_ADD;
        }
        OkhttpHelper.Post(url, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))){
                    if (isUpdate){
                        new SweetAlertDialog(SeedUpdateAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("修改成功")
                                .show();
                    }else {
                        new SweetAlertDialog(SeedUpdateAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("添加成功")
                                .show();
                    }

                }else {
                    if (isUpdate){
                        new SweetAlertDialog(SeedUpdateAddActivity.this,SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("修改失败,"+JsonUtil.ParseMsg(response))
                                .show();
                    }else {
                        new SweetAlertDialog(SeedUpdateAddActivity.this,SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("添加失败,"+JsonUtil.ParseMsg(response))
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

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recode_add;
    }
}
