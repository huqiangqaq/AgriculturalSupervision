package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.nxt.zyl.util.ZToastUtils;

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
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class IntegrityAddActivity extends BaseActivity implements OnDateSetListener {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.btn_save)
    Button btn_save;
    @BindView(R.id.dtarosedate)
    TextView tv_dtarosedate;
    @BindView(R.id.vcillegalcomp)
    EditText et_vcillegalcomp;
    @BindView(R.id.iproducttype)
    NiceSpinner sp_iproducttype;
    @BindView(R.id.vcillegalprod)
    EditText et_vcillegalprod;
    @BindView(R.id.vcdesc)
    EditText et_vcdesc;
    private String dtarosedate,vcillegalcomp,vcillegalprod,vcdesc,iproducttype;
    private List<String> dataset = new LinkedList<>(Arrays.asList("农药", "化肥", "种子"));
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("我要举报");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sp_iproducttype.attachDataSource(dataset);
        tv_dtarosedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickDialog();
            }
        });
        sp_iproducttype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String staus = dataset.get(position);
                if ("种子".equalsIgnoreCase(staus)){
                    iproducttype = "0";
                }else if ("化肥".equalsIgnoreCase(staus)){
                    iproducttype = "1";
                }else if ("农药".equalsIgnoreCase(staus)){
                    iproducttype = "2";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void showTimePickDialog() {
        TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(IntegrityAddActivity.this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("选择时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis()-tenYears/2)
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(18)
                .build();
        mDialogAll.show(getSupportFragmentManager(),"all");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_integrity_add;
    }

    //跳转
    public static void actionStart(Context context){
        Intent intent = new Intent(context,IntegrityAddActivity.class);
        context.startActivity(intent);
    }

    @OnClick(R.id.btn_save) void Save(){
        vcillegalcomp  = et_vcillegalcomp.getText().toString().trim();
        vcillegalprod = et_vcillegalprod.getText().toString().trim();
        vcdesc = et_vcdesc.getText().toString().trim();
        if (TextUtils.isEmpty(dtarosedate) || TextUtils.isEmpty(vcillegalcomp) ||TextUtils.isEmpty(vcillegalprod) ||TextUtils.isEmpty(vcdesc)
                || TextUtils.isEmpty(iproducttype)) {
            ZToastUtils.showShort(IntegrityAddActivity.this,"请先填写信息!");
            return;
        }
        Map<String,String> map = new HashMap<>();
        map.put("dtarosedate",dtarosedate);
        map.put("vcillegalcomp",vcillegalcomp);
        map.put("vcillegalprod",vcillegalprod);
        map.put("vcdesc",vcdesc);
        map.put("iproducttype",iproducttype);
        showLoadingDialog(R.string.loading);
        OkhttpHelper.Post(Constants.INTEGRITY_ADD, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))){
                    new SweetAlertDialog(IntegrityAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setConfirmText("添加成功")
                            .show();
                }else {
                    new SweetAlertDialog(IntegrityAddActivity.this,SweetAlertDialog.ERROR_TYPE)
                            .setConfirmText("添加失败,"+JsonUtil.ParseMsg(response))
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

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        dtarosedate= getDateToString(millseconds);
        tv_dtarosedate.setText(dtarosedate);
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }
}
