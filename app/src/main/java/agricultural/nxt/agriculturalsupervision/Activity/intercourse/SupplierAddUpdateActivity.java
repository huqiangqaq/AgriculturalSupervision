package agricultural.nxt.agriculturalsupervision.Activity.intercourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.nxt.zyl.util.ZToastUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Supplier;
import butterknife.BindView;
import cn.pedant.SweetAlert.SweetAlertDialog;
import me.iwf.photopicker.PhotoPicker;
import okhttp3.Call;
import okhttp3.Response;

import static agricultural.nxt.agriculturalsupervision.R.id.vcaddress;
import static agricultural.nxt.agriculturalsupervision.R.id.vccorporation;
import static agricultural.nxt.agriculturalsupervision.R.id.vcemail;
import static agricultural.nxt.agriculturalsupervision.R.id.vcmysuppliername;
import static agricultural.nxt.agriculturalsupervision.R.id.vcphone;

public class SupplierAddUpdateActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(vcmysuppliername)
    EditText et_vcmysuppliername;
    @BindView(vccorporation)
    EditText et_vccorporation;
    @BindView(vcphone)
    EditText et_vcphone;
    @BindView(vcaddress)
    EditText et_vcaddress;
    @BindView(vcemail)
    EditText et_vcemail;
    @BindView(R.id.vcbizlicense)
    EditText et_vcbizlicense;
    @BindView(R.id.cbizlicedate)
    TextView tv_cbizlicedate;
    @BindView(R.id.btnselect1)
    Button btnselect1;
    @BindView(R.id.vcproductlicense)
    EditText et_vcproductlicense;
    @BindView(R.id.dtprodlicendate)
    TextView tv_dtprodlicendate;
    @BindView(R.id.btnselect2)
    Button btnselect2;
    @BindView(R.id.btnUpdateAdd)
    Button btnUpdateAdd;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    private boolean isUpdate = false;
    private Supplier.ListBean supplier;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    //图片地址
    private ArrayList<String> selectedPhotos1 = new ArrayList<>();
    private ArrayList<String> selectedPhotos2 = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        Intent intent =getIntent();
        String type = intent.getStringExtra("type");
        supplier = intent.getParcelableExtra("supplier");
        if ("update".equals(type)){
            toolBar.setTitle("往来供应商修改");
            isUpdate = true;
        }else {
            toolBar.setTitle("往来供应商添加");
        }
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        if (isUpdate){
            et_vcmysuppliername.setText(supplier.getVcmysuppliername());
            et_vccorporation.setText(supplier.getVccorporation());
            et_vcphone.setText(supplier.getVcphone());
            et_vcaddress.setText(supplier.getVcaddress());
            et_vcemail.setText(supplier.getVcemail());
            et_vcbizlicense.setText(supplier.getVcbizlicense());
            tv_cbizlicedate.setText(supplier.getVcbizlicedate());
            et_vcproductlicense.setText(supplier.getVcproductlicense());
            tv_dtprodlicendate.setText(supplier.getDtprodlicendate());
            if (null!=supplier.getVcbizlicepic()){
                String imgPath1 = supplier.getVcbizlicepic().substring(1,supplier.getVcbizlicepic().length());
                img1.setVisibility(View.VISIBLE);
                Glide.with(this)
                        .load(Constants.IMG_HEAD+imgPath1)
                        .crossFade()
                        .into(img1);
            }
            if (null!=supplier.getVcprodlicenpic()){
                String imgpath2 = supplier.getVcprodlicenpic().substring(1,supplier.getVcprodlicenpic().length());
                img2.setVisibility(View.VISIBLE);
                Glide.with(this)
                        .load(Constants.IMG_HEAD+imgpath2)
                        .crossFade()
                        .into(img2);
            }

        }
        //日期选择
        tv_cbizlicedate.setOnClickListener(v -> showTimePickDialog(tv_cbizlicedate));
        tv_dtprodlicendate.setOnClickListener(v -> showTimePickDialog(tv_dtprodlicendate));
        btnselect1.setOnClickListener(this);
        btnselect2.setOnClickListener(this);
        btnUpdateAdd.setOnClickListener(this);
    }

    private void showTimePickDialog(TextView tv) {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("选择时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis() - tenYears / 2)
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(ContextCompat.getColor(this,R.color.timepicker_toolbar_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(ContextCompat.getColor(this,R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(ContextCompat.getColor(this,R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(18)
                .setCallBack((timePickerView, millseconds) -> tv.setText(getDateToString(millseconds)))
                .build();
        mDialogAll.show(getSupportFragmentManager(), "all");
    }
    private String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_supplier_add_update;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<String> photos = null;
        switch (requestCode){
            case 1:
                if (data!=null){
                    photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                }
                selectedPhotos1.clear();
                if (photos!=null){
                    selectedPhotos1.addAll(photos);
                    img1.setVisibility(View.VISIBLE);
                    Glide.with(this)
                            .load(selectedPhotos1.get(0))
                            .crossFade()
                            .into(img1);
                }
                break;
            case 2:
                if (data!=null){
                    photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                }
                selectedPhotos2.clear();
                if (photos!=null){
                    selectedPhotos2.addAll(photos);
                    img2.setVisibility(View.VISIBLE);
                    Glide.with(this)
                            .load(selectedPhotos2.get(0))
                            .crossFade()
                            .into(img2);
                }
                break;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnselect1:
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .setShowCamera(true)
                        .setPreviewEnabled(true)
                        .setSelected(selectedPhotos1)
                        .start(this, 1);
                break;
            case R.id.btnselect2:
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .setShowCamera(true)
                        .setPreviewEnabled(true)
                        .setSelected(selectedPhotos2)
                        .start(this, 2);
                break;
            case R.id.btnUpdateAdd:
                supplierSave();
        }
    }

    private void supplierSave() {

        String vcbizlicepic,vcprodlicenpic;
        String vcmysuppliername = et_vcmysuppliername.getText().toString().trim();
        String vccorporation = et_vccorporation.getText().toString().trim();
        String vcphone = et_vcphone.getText().toString().trim();
        String vcaddress = et_vcaddress.getText().toString().trim();
        String vcemail = et_vcemail.getText().toString().trim();
        String vcbizlicense = et_vcbizlicense.getText().toString().trim();
        String vcbizlicedate = tv_cbizlicedate.getText().toString().trim();
        String vcproductlicense = et_vcproductlicense.getText().toString().trim();
        String dtprodlicendate = tv_dtprodlicendate.getText().toString().trim();
        if (selectedPhotos1.size()>0){
             vcbizlicepic = selectedPhotos1.get(0);
        }else {
            vcbizlicepic = "";
        }
        if (selectedPhotos2.size()>0){
            vcprodlicenpic = selectedPhotos2.get(0);
        }else{
            vcprodlicenpic = "";
        }
        if ("".equals(vcbizlicepic)){
            ZToastUtils.showShort(SupplierAddUpdateActivity.this,"请先选择图片");
            return;
        }
        if ("".equals(vcprodlicenpic)){
            ZToastUtils.showShort(SupplierAddUpdateActivity.this,"请先选择图片");
            return;
        }
        Map<String,String> map = new HashMap<>();
        if (isUpdate){
            map.put("id",supplier.getId());
        }
        map.put("vcmysuppliername",vcmysuppliername);
        map.put("vccorporation",vccorporation);
        map.put("vcphone",vcphone);
        map.put("vcaddress",vcaddress);
        map.put("vcemail",vcemail);
        map.put("vcbizlicense",vcbizlicense);
        map.put("vcbizlicedate",vcbizlicedate);
        map.put("vcproductlicense",vcproductlicense);
        map.put("dtprodlicendate",dtprodlicendate);
        showLoadingDialog(R.string.LOADING);
        OkGo.post(Constants.SUPPLIER_SAVE)
                .tag(this)
                .params(map)
                .params("bizlicepic",new File(vcbizlicepic))
                .params("prodlicenpic",new File(vcprodlicenpic))
                .execute(new StringCallback(){
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        dismissLoadingDialog();
                        if (s != null) {
                            if ("true".equalsIgnoreCase(JsonUtil.PareJson(s))) {
                                new SweetAlertDialog(SupplierAddUpdateActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                        .setConfirmText("保存成功")
                                        .show();
                            } else {
                                new SweetAlertDialog(SupplierAddUpdateActivity.this, SweetAlertDialog.ERROR_TYPE)
                                        .setConfirmText("修改失败," + JsonUtil.ParseMsg(s))
                                        .show();
                            }
                        }
                    }

                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        super.upProgress(currentSize, totalSize, progress, networkSpeed);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                    }
                });
    }
}
