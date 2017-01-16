package agricultural.nxt.agriculturalsupervision.Activity.pesticide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.nxt.zyl.util.ZToastUtils;

import java.util.HashMap;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.PesticideLib;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;
import okhttp3.Response;

public class PesticideUpdateAddActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.vcgrantno)
    EditText vcgrantno;
    @BindView(R.id.vcpesticidename)
    EditText vcpesticidename;
    @BindView(R.id.vcnetcontent)
    EditText vcnetcontent;
    @BindView(R.id.vcproductunit)
    EditText vcproductunit;
    @BindView(R.id.vcdescription)
    EditText vcdescription;
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
    private String grantNo = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        if ("update".equalsIgnoreCase(type)) {
            isUpdate = true;
        }
        toolBar.setTitle("update".equalsIgnoreCase(type) ? "农药备案修改" : "农药备案添加");
        if (isUpdate) {
            btnUpdateAdd.setText("修改");
            id = intent.getStringExtra("id");
            vcgrantno.setText(intent.getStringExtra("vcgrantno"));
            vcpesticidename.setText(intent.getStringExtra("vcpesticidename"));
            vcnetcontent.setText(intent.getStringExtra("vcnetcontent"));
            vcproductunit.setText(intent.getStringExtra("vcproductunit"));
            vcdescription.setText(intent.getStringExtra("vcdescription"));
            vcplaceoforigin.setText(intent.getStringExtra("vcplaceoforigin"));
            vcinstructions.setText(intent.getStringExtra("vcinstructions"));
            vcstandards.setText(intent.getStringExtra("vcstandards"));
            vcbrand.setText(intent.getStringExtra("vcbrand"));
            vcspec.setText(intent.getStringExtra("vcspec"));
            vcuniquecode.setText(intent.getStringExtra("vcuniquecode"));
        } else {
            grantNo = vcgrantno.getText().toString().trim();
            vcgrantno.setOnFocusChangeListener((v, hasFocus) -> {
                if (!hasFocus){ //失去焦点
                    search();
                }
            });
            //点击键盘完成
            vcgrantno.setOnEditorActionListener((v, actionId, event) -> {
                if (actionId== EditorInfo.IME_ACTION_DONE){
                    search();
                }
                return false;
            });

        }
    }

    private void search() {
        grantNo = vcgrantno.getText().toString().trim();
        if (grantNo != null) {
                OkGo.get(Constants.APPPESTICIDELIB + grantNo)
                        .tag(this)
                        .cacheMode(CacheMode.DEFAULT)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                if (s != null) {
                                    PesticideLib lib = new Gson().fromJson(s, PesticideLib.class);
                                    if (lib.getName()!=null){
                                        if (!btnUpdateAdd.isEnabled()){
                                           btnUpdateAdd.setEnabled(true);
                                        }
                                        vcpesticidename.setText(lib.getName());
                                        vcproductunit.setText(lib.getCompanyName());
                                        vcdescription.setText(lib.getCompositionAndContent());
                                        vcinstructions.setText(lib.getApplicationMethod());
                                        vcstandards.setText(lib.getDosage());
                                    }else {
                                        ZToastUtils.showShort(PesticideUpdateAddActivity.this,"该产品不存在,请重新填写正确的登记证号");
                                        btnUpdateAdd.setEnabled(false);
                                    }
                                }
                            }
                        });
            }
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pesticide_update_add;
    }

    @OnClick(R.id.btnUpdateAdd)
    void updataAdd() {
        if (TextUtils.isEmpty(vcgrantno.getText().toString().trim())) {
            ZToastUtils.showShort(PesticideUpdateAddActivity.this, "登记证号不能为空!");
            return;
        }
        Map<String, String> map = new HashMap<>();
        if (isUpdate) {
            map.put("id", id);
        }
        map.put("vcgrantno", vcgrantno.getText().toString().trim());
        map.put("vcpesticidename", vcpesticidename.getText().toString().trim());
        map.put("vcnetcontent", vcnetcontent.getText().toString().trim());
        map.put("vcproductunit", vcproductunit.getText().toString().trim());
        map.put("vcdescription", vcdescription.getText().toString().trim());
        map.put("vcplaceoforigin", vcplaceoforigin.getText().toString().trim());
        map.put("vcinstructions", vcinstructions.getText().toString().trim());
        map.put("vcstandards", vcstandards.getText().toString().trim());
        map.put("vcbrand", vcbrand.getText().toString().trim());
        map.put("vcspec", vcspec.getText().toString().trim());
        map.put("vcuniquecode", vcuniquecode.getText().toString().trim());
        showLoadingDialog(R.string.LOADING);
        if (isUpdate) {
            url = Constants.PESTICIDE_UPDATE;
        } else {
            url = Constants.PESTICIDE_ADD;
        }
        OkhttpHelper.Post(url, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))) {
                    if (isUpdate) {
                        new SweetAlertDialog(PesticideUpdateAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("修改成功")
                                .show();
                    } else {
                        new SweetAlertDialog(PesticideUpdateAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("添加成功")
                                .show();
                    }

                } else {
                    if (isUpdate) {
                        new SweetAlertDialog(PesticideUpdateAddActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("修改失败," + JsonUtil.ParseMsg(response))
                                .show();
                    } else {
                        new SweetAlertDialog(PesticideUpdateAddActivity.this, SweetAlertDialog.ERROR_TYPE)
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
        }, 1);
    }

//    private TextWatcher textWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            String text = s.toString();
//            if (text != null) {
//                OkGo.get(Constants.APPPESTICIDELIB + text)
//                        .tag(this)
//                        .cacheMode(CacheMode.DEFAULT)
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onSuccess(String s, Call call, Response response) {
//                                if (s != null) {
//                                    PesticideLib lib = new Gson().fromJson(s, PesticideLib.class);
//                                    vcpesticidename.setText(lib.getName());
//                                    vcproductunit.setText(lib.getCompanyName());
////                                    vcdescription.setText(lib.getde);
//                                }
//                            }
//                        });
//            }
//        }
//    };
}
