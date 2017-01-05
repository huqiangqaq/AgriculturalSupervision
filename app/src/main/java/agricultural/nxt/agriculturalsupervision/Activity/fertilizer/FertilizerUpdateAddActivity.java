package agricultural.nxt.agriculturalsupervision.Activity.fertilizer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.nxt.zyl.util.ZToastUtils;

import java.util.HashMap;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class FertilizerUpdateAddActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.vcfertilizename)
    EditText vcfertilizename;
    @BindView(R.id.vcnetcontent)
    EditText vcnetcontent;
    @BindView(R.id.vcproductunit)
    EditText vcproductunit;
    @BindView(R.id.vcdescription)
    EditText vcdescription;
    @BindView(R.id.vcgrantno)
    EditText vcgrantno;
    @BindView(R.id.vcplaceoforigin)
    EditText vcplaceoforigin;
    @BindView(R.id.vcinstructions)
    EditText vcinstructions;
    @BindView(R.id.vcstandards)
    EditText vcstandards;
    @BindView(R.id.vcbrand)
    EditText vcbrand;
    @BindView(R.id.vcspec)
    EditText vcspec;
    @BindView(R.id.vcuniquecode)
    EditText vcuniquecode;
    @BindView(R.id.btnUpdateAdd)
    Button btnUpdateAdd;
    private String id = null;
    private boolean isUpdate = false;
    private String url = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        if ("update".equalsIgnoreCase(type)) {
            isUpdate = true;
        }
        toolBar.setTitle("update".equalsIgnoreCase(type) ? "化肥备案修改" : "化肥备案添加");
        if (isUpdate) {
            btnUpdateAdd.setText("修改");
            id = intent.getStringExtra("id");
            vcfertilizename.setText(intent.getStringExtra("vcfertilizename"));
            vcnetcontent.setText(intent.getStringExtra("vcnetcontent"));
            vcproductunit.setText(intent.getStringExtra("vcproductunit"));
            vcdescription.setText(intent.getStringExtra("vcdescription"));
            vcgrantno.setText(intent.getStringExtra("vcgrantno"));
            vcplaceoforigin.setText(intent.getStringExtra("vcplaceoforigin"));
            vcinstructions.setText(intent.getStringExtra("vcinstructions"));
            vcstandards.setText(intent.getStringExtra("vcstandards"));
            vcbrand.setText(intent.getStringExtra("vcbrand"));
            vcspec.setText(intent.getStringExtra("vcspec"));
            vcuniquecode.setText(intent.getStringExtra("vcuniquecode"));
        }
        btnUpdateAdd.setOnClickListener(v -> updataAdd());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_fertilizer_update_add;
    }
    void updataAdd() {
        if (TextUtils.isEmpty(vcgrantno.getText().toString().trim())) {
            ZToastUtils.showShort(FertilizerUpdateAddActivity.this, "登记证号不能为空!");
            return;
        }
        Map<String, String> map = new HashMap<>();
        if (isUpdate) {
            map.put("id", id);
        }
        map.put("vcfertilizename", vcfertilizename.getText().toString().trim());
        map.put("vcnetcontent", vcnetcontent.getText().toString().trim());
        map.put("vcproductunit", vcproductunit.getText().toString().trim());
        map.put("vcdescription", vcdescription.getText().toString().trim());
        map.put("vcgrantno", vcgrantno.getText().toString().trim());
        map.put("vcplaceoforigin", vcplaceoforigin.getText().toString().trim());
        map.put("vcinstructions", vcinstructions.getText().toString().trim());
        map.put("vcstandards", vcstandards.getText().toString().trim());
        map.put("vcbrand", vcbrand.getText().toString().trim());
        map.put("vcspec", vcspec.getText().toString().trim());
        map.put("vcuniquecode", vcuniquecode.getText().toString().trim());
        showLoadingDialog(R.string.LOADING);
        if (isUpdate) {
            url = Constants.FERTILIZER_UPDATE;
        } else {
            url = Constants.FERTILIZER_ADD;
        }
        OkhttpHelper.Post(url, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))) {
                    if (isUpdate) {
                        new SweetAlertDialog(FertilizerUpdateAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("修改成功")
                                .show();
                    } else {
                        new SweetAlertDialog(FertilizerUpdateAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("添加成功")
                                .show();
                    }

                } else {
                    if (isUpdate) {
                        new SweetAlertDialog(FertilizerUpdateAddActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("修改失败," + JsonUtil.ParseMsg(response))
                                .show();
                    } else {
                        new SweetAlertDialog(FertilizerUpdateAddActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("添加失败," + JsonUtil.ParseMsg(response))
                                .show();
                    }

                }
            }
            @Override
            public void onFailed(String error, int tag) {
                String ss = error;
            }

            @Override
            public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

            }
        }, 1);
    }
}
