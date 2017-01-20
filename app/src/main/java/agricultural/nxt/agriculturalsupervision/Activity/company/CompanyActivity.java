package agricultural.nxt.agriculturalsupervision.Activity.company;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Application.MyApplication;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Company;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class CompanyActivity extends BaseActivity implements BaiduMap.OnMapTouchListener {
    @BindView(R.id.sl)
    ScrollView sl;
    @BindView(R.id.areaname)
    EditText areaname;
    @BindView(R.id.vcorgname)
    EditText vcorgname;
    @BindView(R.id.ikind)
    EditText ikind;
    @BindView(R.id.pesticide)
    CheckBox pesticide;
    @BindView(R.id.fertilizer)
    CheckBox fertilizer;
    @BindView(R.id.seed)
    CheckBox seed;
    @BindView(R.id.vccorporation)
    TextView vccorporation;
    @BindView(R.id.vcidnumber)
    EditText vcidnumber;
    @BindView(R.id.vcphone)
    EditText vcphone;
    @BindView(R.id.vcemail)
    EditText vcemail;
    @BindView(R.id.vcaddress)
    EditText vcaddress;
    @BindView(R.id.mapview)
    MapView mapview;
    @BindView(R.id.vcgpsx)
    TextView vcgpsx;
    @BindView(R.id.fgpsy)
    TextView fgpsy;
    @BindView(R.id.vcbizlicense)
    EditText vcbizlicense;
    @BindView(R.id.cbizlicedate)
    TextView cbizlicedate;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    //    @BindView(R.id.recycler_view)
//    MultiPickResultView recycler_view;
//    @BindView(R.id.recycler_view2)
//    MultiPickResultView recycler_view2;
    @BindView(R.id.vcproductlicense)
    EditText vcproductlicense;
    @BindView(R.id.dtprodlicendate)
    TextView dtprodlicendate;
    @BindView(R.id.icheckstatus)
    TextView icheckstatus;
    @BindView(R.id.sp_icheckstatus)
    NiceSpinner sp_icheckstatus;
    @BindView(R.id.vccheckerName)
    TextView vccheckerName;
    @BindView(R.id.tcheckdate)
    TextView tcheckdate;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    private static final String TAG = "CompanyActivity";
    private String id;
    private String url = null;
    private double mGpsX;
    private double mGpsY;
    /**
     * 地图实例
     */
    private BaiduMap mBaiduMap;
    private BitmapDescriptor bitmap;
    //图片地址
    private ArrayList<String> imgpath = new ArrayList<>();
    private ArrayList<String> imgpath2 = new ArrayList<>();
    private MyApplication application;
    private String CompanyId = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // 注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        application = MyApplication.getInstance();
        toolBar.setTitle("企业备案");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        mBaiduMap = mapview.getMap();
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);
        mBaiduMap.setOnMapTouchListener(this);
        //给地图添加监听
        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //获取经纬度
                double latitude = latLng.latitude;
                double longitude = latLng.longitude;
                Log.i(TAG, "latitude=" + latitude + "," + "longitude=" + longitude);
                vcgpsx.setText(longitude + "");
                fgpsy.setText(latitude + "");
                //先清除图层
                mBaiduMap.clear();
                // 定义Maker坐标点
                LatLng point = new LatLng(latitude, longitude);
                // 构建MarkerOption，用于在地图上添加Marker
                MarkerOptions options = new MarkerOptions().position(point)
                        .icon(bitmap);
                // 在地图上添加Marker，并显示
                mBaiduMap.addOverlay(options);
                //实例化一个地理编码查询对象
                GeoCoder geoCoder = GeoCoder.newInstance();
                //设置反地理编码位置坐标
                ReverseGeoCodeOption op = new ReverseGeoCodeOption();
                op.location(point);
                //发起反地理编码请求(经纬度->地址信息)
                geoCoder.reverseGeoCode(op);
                geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
                    @Override
                    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

                    }

                    @Override
                    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                        String ss = reverseGeoCodeResult.getAddress();
                        vcaddress.setText(reverseGeoCodeResult.getAddress());
                    }
                });
            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });


        url = Constants.COMPANY_MANAGER;

        OkhttpHelper.Get(url, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                if (null != response) {
                    Company company = new Gson().fromJson(response, Company.class);
                    CompanyId = company.getData().getId();
                    areaname.setText(company.getData().getArea().getName());
                    areaname.setKeyListener(null);
                    vcorgname.setText(company.getData().getVcorgname());
                    vcorgname.setKeyListener(null);
                    ikind.setKeyListener(null);
                    String type = company.getData().getIkind();
                    if ("0".equalsIgnoreCase(type)) {
                        ikind.setText("生产企业");
                    } else if ("1".equalsIgnoreCase(type)) {
                        ikind.setText("经销商");
                    } else if ("2".equalsIgnoreCase(type)) {
                        ikind.setText("种植大户");
                    }
                    List<String> onwntype = company.getData().getOwnerscopeTypes();
                    for (int i = 0; i < onwntype.size(); i++) {
                        if (onwntype.get(i).equalsIgnoreCase("0")) {
                            seed.setChecked(true);
                            seed.setClickable(false);
                        } else if (onwntype.get(i).equalsIgnoreCase("1")) {
                            pesticide.setChecked(true);
                            pesticide.setClickable(false);
                        } else if (onwntype.get(i).equalsIgnoreCase("2")) {
                            fertilizer.setChecked(true);
                            fertilizer.setClickable(false);
                        }
                    }
                    vccorporation.setText(company.getData().getVccorporation());
                    vccorporation.setKeyListener(null);
                    vcidnumber.setText(company.getData().getVcidnumber());
                    vcphone.setText(company.getData().getVcphone());
                    vcemail.setText(company.getData().getVcemail());
                    mGpsX = Double.parseDouble(company.getData().getVcgpsx());
                    mGpsY = Double.parseDouble(company.getData().getFgpsy());
                    vcaddress.setText(company.getData().getVcaddress());
                    vcgpsx.setText(company.getData().getVcgpsx());
                    fgpsy.setText(company.getData().getFgpsy());
                    if (!TextUtils.isEmpty(company.getData().getVcgpsx()) & !TextUtils.isEmpty(company.getData().getFgpsy())) {
                        getMapByLatLng();
                    }
                    //营业执照
                    vcbizlicense.setText(company.getData().getVcbizlicense());
                    vcbizlicense.setKeyListener(null);
                    cbizlicedate.setText(company.getData().getVcbizlicedate());
                    //生产许可证
                    vcproductlicense.setText(company.getData().getVcproductlicense());
                    vcproductlicense.setKeyListener(null);
                    dtprodlicendate.setText(company.getData().getDtprodlicendate());
                    String status = company.getData().getIcheckstatus();
                    if ("-2".equalsIgnoreCase(status)) {
                        icheckstatus.setText("未提交审核");
                    } else if ("-1".equalsIgnoreCase(status)) {
                        icheckstatus.setText("待审核");
                    } else if ("0".equalsIgnoreCase(status)) {
                        icheckstatus.setText("未审核通过");
                    } else if ("1".equalsIgnoreCase(status)) {
                        icheckstatus.setText("审核通过");
                    }
                    vccheckerName.setText(company.getData().getVccheckerName());
                    tcheckdate.setText(company.getData().getDtcheckdate());
                    Glide.with(CompanyActivity.this)
                            .load(Constants.IMG_HEAD+company.getData().getVcbizlicepic())
                            .crossFade()
                            .into(img1);
                    Glide.with(CompanyActivity.this)
                            .load(Constants.IMG_HEAD+company.getData().getVcprodlicenpic())
                            .crossFade()
                            .into(img2);
                }
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        }, 1);

        //图片选择

//        recycler_view.init(this,MultiPickResultView.ACTION_ONLY_SHOW,imgpath);
//        recycler_view2.init(this,MultiPickResultView.ACTION_ONLY_SHOW,imgpath2);

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_company;
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, CompanyActivity.class);
        context.startActivity(intent);
    }

    private void getMapByLatLng() {
        LatLng ll = new LatLng(mGpsY, mGpsX);
        //构建marker图标
        bitmap = BitmapDescriptorFactory
                .fromResource(R.mipmap.maker);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(ll)
                .icon(bitmap);
        //在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);
        MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
        mBaiduMap.animateMapStatus(u);
    }

    @Override
    public void onTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                sl.requestDisallowInterceptTouchEvent(false);
                break;
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                sl.requestDisallowInterceptTouchEvent(true);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        recycler_view.onActivityResult(requestCode,resultCode,data);
//        List<String> list;
//        list = recycler_view.getPhotos();
    }

    @OnClick(R.id.btnSave)
    void CompanySave() {
        showLoadingDialog(R.string.loading);
        Map<String, String> map = new HashMap<>();
        map.put("id", CompanyId);
        map.put("vcphone", vcphone.getText().toString().trim());
        map.put("vcemail", vcemail.getText().toString().trim());
        map.put("vcaddress", vcaddress.getText().toString().trim());
        OkhttpHelper.Post(Constants.COMPANY_SAVE, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                dismissLoadingDialog();
                if (response != null) {
                    if ("true".equalsIgnoreCase(JsonUtil.PareJson(response))) {
                        new SweetAlertDialog(CompanyActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setConfirmText("保存成功")
                                .show();
                    } else {
                        new SweetAlertDialog(CompanyActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setConfirmText("修改失败," + JsonUtil.ParseMsg(response))
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
        }, 2);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapview.onDestroy();
        mapview = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapview.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapview.onPause();
    }

    @OnClick(R.id.btnSave)
    void onButtonClick() {

    }
}
