package agricultural.nxt.agriculturalsupervision.Activity.purchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.PurFertilizer;
import agricultural.nxt.agriculturalsupervision.entity.PurfertDeatil;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class PurFerAddActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.tMysupplierId)
    NiceSpinner tMysupplierId;
    @BindView(R.id.tSeedId)
    NiceSpinner tSeedId;
    @BindView(R.id.dtpodate)
    TextView dtpodate;
    @BindView(R.id.pohremarks)
    EditText pohremarks;
    @BindView(R.id.fponumber)
    EditText fponumber;
    @BindView(R.id.fprice)
    EditText fprice;
    @BindView(R.id.ftotalmoney)
    TextView ftotalmoney;
    @BindView(R.id.vcunit)
    NiceSpinner vcunit;
    @BindView(R.id.remarks)
    EditText remarks;
    @BindView(R.id.btnUpdateAdd)
    Button btnUpdateAdd;
    private boolean isUpdate = false;
    private List<String> supplierList = new ArrayList<>();
    private List<String> seedList = new ArrayList<>();
    private List<String> supplierId = new ArrayList<>();
    private List<String> seedId = new ArrayList<>();
    private int supplierPos=0, seedPos=0;
    private PurFertilizer.ListBean purchase;
    private double ponumber=0, price=0;
    private double mtotalPrice;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private String[] dataSet = new String[]{"包","瓶","袋"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this, R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        if ("update".equalsIgnoreCase(type)) {
            isUpdate = true;
            purchase = intent.getParcelableExtra("purFert");
        }
        //获取供应商列表
        OkhttpHelper.Get(Constants.PURCHASE_GETSUPPLIER, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        String vcmysuppliername = array.getJSONObject(i).getString("vcmysuppliername");
                        String id = array.getJSONObject(i).getString("id");
                        supplierList.add(vcmysuppliername);
                        supplierId.add(id);
                        if (isUpdate) {
                            if (vcmysuppliername.equals(purchase.getPoh().getTMysupplierName())){
                                supplierPos = i;
                            }
                        }
                    }
                    tMysupplierId.attachDataSource(supplierList);
                    tMysupplierId.setSelectedIndex(supplierPos);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        }, 1);
        //获取化肥列表
        OkhttpHelper.Get(Constants.PUR_FER_GETFERT, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        String vcvarietyname = array.getJSONObject(i).getString("vcfertilizename");
                        String id = array.getJSONObject(i).getString("id");
                        seedList.add(vcvarietyname);
                        seedId.add(id);
                        if (isUpdate ) {
                            if (vcvarietyname.equals(purchase.getFertilizer().getVcfertilizename())){
                                seedPos = i;
                            }
                        }
                    }
                    tSeedId.attachDataSource(seedList);
                    tSeedId.setSelectedIndex(seedPos);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailed(String error, int tag) {
            }
        }, 2);
        vcunit.attachDataSource(Arrays.asList(dataSet));
        vcunit.setSelectedIndex(0);
        if (isUpdate){
            OkhttpHelper.Get(Constants.PUR_FERT_DETAIL + purchase.getPoh().getId(), new OkhttpHelper.GetCallBack() {
                @Override
                public void onSuccess(String response, int tag) {
                    PurfertDeatil detail = new Gson().fromJson(response, PurfertDeatil.class);
                    remarks.setText(detail.getPofertilizerd().get(0).getRemarks());
                    pohremarks.setText(detail.getPoh().getRemarks());
                }
                @Override
                public void onFailed(String error, int tag) {

                }
            }, 3);
        }
        toolBar.setTitle("update".equalsIgnoreCase(type) ? "化肥购进修改" : "化肥购进添加");
        if (isUpdate) {
            btnUpdateAdd.setText("修改");
            dtpodate.setText(purchase.getDtpodate());
            fponumber.setText(purchase.getFponumber());
            fprice.setText(purchase.getFprice());
            ftotalmoney.setText(Double.valueOf(purchase.getFponumber()) * Double.valueOf(purchase.getFprice()) + "元");
        }
        fponumber.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus){
                ponumber = Double.valueOf(fponumber.getText().toString().trim());
                if (!TextUtils.isEmpty(fprice.getText().toString())){
                    price = Double.valueOf(fprice.getText().toString().trim());
                }
                mtotalPrice = ponumber * price;
                ftotalmoney.setText(mtotalPrice + "元");
            }
        });

        fprice.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus){
                price = Double.valueOf(fprice.getText().toString().trim());
                if (!TextUtils.isEmpty(fponumber.getText().toString())){
                    ponumber = Double.valueOf(fponumber.getText().toString().trim());
                }
                mtotalPrice = ponumber * price;
                ftotalmoney.setText(mtotalPrice + "元");
            }
        });
        dtpodate.setOnClickListener(v -> showTimePickDialog(dtpodate));
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
    @OnClick(R.id.btnUpdateAdd) void updataAdd(){
        Map<String, String> map = new HashMap<>();
        if (isUpdate) {
            map.put("id", purchase.getId());
            map.put("tPohId",purchase.getTpohId());
        }else {
            map.put("id","");
        }
        map.put("tMysupplierId",supplierId.get(tMysupplierId.getSelectedIndex()));
        map.put("dtpodate",dtpodate.getText().toString().trim());
        map.put("ftotalmoney",Double.valueOf(fponumber.getText().toString().trim())*Double.valueOf(fprice.getText().toString().trim())+"");
        map.put("pohremarks",pohremarks.getText().toString().trim());
        map.put("tPesticideId",seedId.get(tSeedId.getSelectedIndex()));
        map.put("fponumber",fponumber.getText().toString().trim());
        map.put("fprice",fprice.getText().toString().trim());
        map.put("vcunit",dataSet[vcunit.getSelectedIndex()]);
        map.put("remarks",remarks.getText().toString().trim());

        showLoadingDialog(R.string.loading);
        OkhttpHelper.Post(Constants.PUR_FERT_SAVE, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))) {
                    if (isUpdate) {
                        new SweetAlertDialog(PurFerAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("修改成功")
                                .show();
                    } else {
                        new SweetAlertDialog(PurFerAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("添加成功")
                                .show();
                    }
                } else {
                    if (isUpdate) {
                        new SweetAlertDialog(PurFerAddActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("修改失败," + JsonUtil.ParseMsg(response))
                                .show();
                    } else {
                        new SweetAlertDialog(PurFerAddActivity.this, SweetAlertDialog.ERROR_TYPE)
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
        },5);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pur_fer_add;
    }
}
