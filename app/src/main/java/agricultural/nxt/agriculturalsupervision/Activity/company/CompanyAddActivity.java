package agricultural.nxt.agriculturalsupervision.Activity.company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.google.gson.Gson;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.nxt.zyl.util.ZToastUtils;

import java.io.File;
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
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.adapter.PhotoAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Company;
import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import me.iwf.photopicker.PhotoPicker;
import okhttp3.Call;
import okhttp3.Response;

import static agricultural.nxt.agriculturalsupervision.R.id.cbizlicedate;
import static agricultural.nxt.agriculturalsupervision.R.id.fertilizer;
import static agricultural.nxt.agriculturalsupervision.R.id.seed;

public class CompanyAddActivity extends BaseActivity implements BaiduMap.OnMapTouchListener, View.OnClickListener {
    @BindView(R.id.sl)
    ScrollView sl;
    @BindView(R.id.areaname)
    TextView tv_areaname;
    @BindView(R.id.vcorgname)
    TextView tv_vcorgname;
    @BindView(R.id.sp_ikind)
    NiceSpinner sp_ikind;
    @BindView(R.id.pesticide)
    CheckBox cb_pesticide;
    @BindView(fertilizer)
    CheckBox cb_fertilizer;
    @BindView(seed)
    CheckBox cb_seed;
    @BindView(R.id.vccorporation)
    EditText et_vccorporation;
    @BindView(R.id.vcidnumber)
    EditText et_vcidnumber;
    @BindView(R.id.vcphone)
    EditText et_vcphone;
    @BindView(R.id.vcemail)
    EditText et_vcemail;
    @BindView(R.id.vcaddress)
    EditText et_vcaddress;
    @BindView(R.id.mapview)
    MapView mapview;
    @BindView(R.id.vcgpsx)
    TextView tv_vcgpsx;
    @BindView(R.id.fgpsy)
    TextView tv_fgpsy;
    @BindView(R.id.vcbizlicense)
    EditText et_vcbizlicense;
    @BindView(cbizlicedate)
    TextView tv_cbizlicedate;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.recycler_view2)
    RecyclerView recycler_view2;
    @BindView(R.id.vcproductlicense)
    EditText et_vcproductlicense;
    @BindView(R.id.dtprodlicendate)
    TextView tv_dtprodlicendate;
    @BindView(R.id.sp_icheckstatus)
    NiceSpinner sp_icheckstatus;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.btnselect1)
    Button btnselect1;
    @BindView(R.id.btnselect2)
    Button btnselect2;
    private static final String TAG= "CompanyAddActivity";
    private String id;
    private String url = null;
    private double mGpsX;
    private double mGpsY;
    private String areaname,vcorgname,kind,type,vccorporation,vcidnumber,vcphone,vcemail,
            vcaddress,vcgpsx,fgpsy,vcbizlicense,vcbizlicedate,vcproductlicense,dtprodlicendate;

    private StringBuilder sb = new StringBuilder();
    /**
     * 地图实例
     */
    private BaiduMap mBaiduMap;
    private BitmapDescriptor bitmap;
    //图片地址
    private ArrayList<String> selectedPhotos1 = new ArrayList<>();
    private ArrayList<String> selectedPhotos2 = new ArrayList<>();
    private String[] mSpData = {"生产企业","经销商","种植大户"};
    private String[] mSpCheck = {"待提交审核"};
    private PhotoAdapter photoAdapter1,photoAdapter2;
    /**
     * 定位的客户端
     */
    private LocationClient mLocationClient;
    /**
     * 定位的监听器
     */
    private MyLocationListener mMyLocationListener;
    /**
     * 当前定位的模式
     */
    private MyLocationConfiguration.LocationMode mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
    /***
     * 是否是第一次定位
     */
    private volatile boolean isFristLocation = true;
    private String companyId = null;  //企业ID
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private String bizlicepic,prodlicenpic;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // 注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        // 第一次定位
        isFristLocation = true;
        toolBar.setTitle("企业备案");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        sp_ikind.attachDataSource(Arrays.asList(mSpData));
        sp_ikind.setSelectedIndex(0);
        sp_icheckstatus.attachDataSource(Arrays.asList(mSpCheck));
        sp_icheckstatus.setSelectedIndex(0);
        photoAdapter1 = new PhotoAdapter(this, selectedPhotos1);
        photoAdapter2 = new PhotoAdapter(this,selectedPhotos2);
        recycler_view.setLayoutManager(new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL));
        recycler_view.setAdapter(photoAdapter1);
        recycler_view2.setLayoutManager(new StaggeredGridLayoutManager(4,OrientationHelper.VERTICAL));
        recycler_view2.setAdapter(photoAdapter2);
        mBaiduMap = mapview.getMap();
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);
        mBaiduMap.setOnMapTouchListener(this);
        btnselect1.setOnClickListener(this);
        btnselect2.setOnClickListener(this);
        sp_ikind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    kind = position+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cb_seed.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                sb.append("0"+",");
            }
        });
        cb_pesticide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                sb.append("1"+",");
            }
        });
        cb_fertilizer.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                sb.append("2"+",");
            }
        });
        //给地图添加监听
        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //获取经纬度
                double latitude= latLng.latitude;
                double longitude = latLng.longitude;
                Log.i(TAG,"latitude="+latitude+","+"longitude="+longitude);
                tv_vcgpsx.setText(longitude+"");
                tv_fgpsy.setText(latitude+"");
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
                        et_vcaddress.setText(reverseGeoCodeResult.getAddress());
                    }
                });
            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });
        // 初始化定位
        initMyLocation();
        OkGo.get(Constants.COMPANY_MANAGER)
                .tag(this)
                .execute(new StringCallback(){
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        if (s!=null){
                            Company add = new Gson().fromJson(s,Company.class);
                            tv_areaname.setText(add.getData().getArea().getName());
                            tv_vcorgname.setText(add.getData().getVcorgname());
                            companyId = add.getData().getId();
                            String type = add.getData().getIkind();
                            if ("0".equalsIgnoreCase(type)) {
                                sp_ikind.setSelectedIndex(0);
                            } else if ("1".equalsIgnoreCase(type)) {
                                sp_ikind.setSelectedIndex(1);
                            } else if ("2".equalsIgnoreCase(type)) {
                                sp_ikind.setSelectedIndex(2);
                            }
                            List<String> onwntype = add.getData().getOwnerscopeTypes();
                            for (int i = 0; i < onwntype.size(); i++) {
                                if (onwntype.get(i).equalsIgnoreCase("0")) {
                                    cb_seed.setChecked(true);
                                } else if (onwntype.get(i).equalsIgnoreCase("1")) {
                                    cb_pesticide.setChecked(true);
                                } else if (onwntype.get(i).equalsIgnoreCase("2")) {
                                    cb_fertilizer.setChecked(true);
                                }
                            }
                            et_vccorporation.setText(add.getData().getVccorporation());
                            et_vcidnumber.setText(add.getData().getVcidnumber());
                            et_vcphone.setText(add.getData().getVcphone());
                            et_vcemail.setText(add.getData().getVcemail());
                            et_vcaddress.setText(add.getData().getVcaddress());
                            tv_vcgpsx.setText(add.getData().getVcgpsx());
                            tv_fgpsy.setText(add.getData().getFgpsy());
                            //营业执照
                            et_vcbizlicense.setText(add.getData().getVcbizlicense());
                            tv_cbizlicedate.setText(add.getData().getVcbizlicedate());
                            //生产许可证
                            et_vcproductlicense.setText(add.getData().getVcproductlicense());
                            tv_dtprodlicendate.setText(add.getData().getDtprodlicendate());
                            String ss = add.getData().getVcbizlicepic();
                            if (ss!=null&!"".equals(ss)){
                                selectedPhotos1.add(Constants.IMG_HEAD+add.getData().getVcbizlicepic());
                                photoAdapter1.notifyDataSetChanged();
                            }
                            if (ss!=null&!"".equals(ss)){
                                selectedPhotos2.add(Constants.IMG_HEAD+add.getData().getVcprodlicenpic());
                                photoAdapter2.notifyDataSetChanged();
                            }

                        }
                    }
                });


        //日期选择
        tv_cbizlicedate.setOnClickListener(v -> showTimePickDialog(tv_cbizlicedate));
        tv_dtprodlicendate.setOnClickListener(v -> showTimePickDialog(tv_dtprodlicendate));

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

    private void initMyLocation() {
        // 定位初始化
        mLocationClient = new LocationClient(this);
        mMyLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mMyLocationListener);
        // 设置定位的相关配置
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);// 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(0); //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);
        option.setIsNeedLocationDescribe(true);
        option.setIsNeedLocationPoiList(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_company_add;
    }

    @Override
    public void onTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        switch (action){
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
        List<String> photos = null;
        switch (requestCode){
            case 1:
                if (data!=null){
                    photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                }
                selectedPhotos1.clear();
                if (photos!=null){
                    selectedPhotos1.addAll(photos);
                }
                photoAdapter1.notifyDataSetChanged();
                break;
            case 2:
                if (data!=null){
                    photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                }
                selectedPhotos2.clear();
                if (photos!=null){
                    selectedPhotos2.addAll(photos);
                }
                photoAdapter2.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnselect1:
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .setShowCamera(true)
                        .setPreviewEnabled(true)
                        .setSelected(selectedPhotos1)
                        .start(this,1);
                break;
            case R.id.btnselect2:
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .setShowCamera(true)
                        .setPreviewEnabled(true)
                        .setSelected(selectedPhotos2)
                        .start(this,2);
                break;
        }
    }

    @OnClick(R.id.btnSave) void CompanySave(){

        //经营范围
        if (sb.length()>0){
            type = sb.toString().substring(0,sb.toString().length()-1);
        }else {
            type = "";
        }
        vccorporation = et_vccorporation.getText().toString().trim();
        vcphone = et_vcphone.getText().toString().trim();
        vcaddress = et_vcaddress.getText().toString().trim();
        vcbizlicense = et_vcbizlicense.getText().toString().trim();
        vcbizlicedate = tv_cbizlicedate.getText().toString().trim();
        //两张图片地址
        if (selectedPhotos1.size()>0){
            bizlicepic = selectedPhotos1.get(0);
        }else {
            bizlicepic = "";
        }
        if (selectedPhotos2.size()>0){
            prodlicenpic = selectedPhotos2.get(0);
        }else {
            prodlicenpic = "";
        }
        vcproductlicense = et_vcproductlicense.getText().toString().trim();
        dtprodlicendate = tv_dtprodlicendate.getText().toString().trim();
        vcemail = et_vcemail.getText().toString().trim();
        vcgpsx = tv_vcgpsx.getText().toString().trim();
        fgpsy = tv_fgpsy.getText().toString().trim();
        vcidnumber =et_vcidnumber.getText().toString().trim();
        Map<String,String> map =new HashMap<>();
        if ("".equals(bizlicepic)){
            ZToastUtils.showShort(CompanyAddActivity.this,"请选择图片");
            return;
        }
        if ("".equals(prodlicenpic)){
            ZToastUtils.showShort(CompanyAddActivity.this,"请选择图片");
            return;
        }
        map.put("id",companyId);
        map.put("vccorporation",vccorporation);
        map.put("vcphone",vcphone);
        map.put("vcaddress",vcaddress);
        map.put("vcbizlicense",vcbizlicense);
        map.put("vcbizlicedate",vcbizlicedate);
        map.put("vcproductlicense",vcproductlicense);
        map.put("dtprodlicendate",dtprodlicendate);
        map.put("vcemail",vcemail);
        map.put("vcgpsx",vcgpsx);
        map.put("fgpsy",fgpsy);
        map.put("ikind",kind);
        map.put("vcidnumber",vcidnumber);
        map.put("ownerscopeTypes",type);
        showLoadingDialog(R.string.LOADING);
        OkGo.post(Constants.COMPANY_UPTOCHECK)
                .tag(this)
                .params(map)
                .params("bizlicepic",new File(bizlicepic))
                .params("prodlicenpic",new File(prodlicenpic))
                .execute(new StringCallback(){
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        dismissLoadingDialog();
                        if (s != null) {
                            if ("true".equalsIgnoreCase(JsonUtil.PareJson(s))) {
                                new SweetAlertDialog(CompanyAddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                        .setConfirmText("保存成功")
                                        .show();
                            } else {
                                new SweetAlertDialog(CompanyAddActivity.this, SweetAlertDialog.ERROR_TYPE)
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



    /**
     * 实现实位回调监听
     */
    public class MyLocationListener implements BDLocationListener
    {
        @Override
        public void onReceiveLocation(BDLocation location)
        {

            // map view 销毁后不在处理新接收的位置
            if (location == null || mapview == null)
                return;
            // 构造定位数据
            String add = location.getAddrStr();
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            // 设置定位数据
            mBaiduMap.setMyLocationData(locData);
            mGpsX = location.getLatitude();
            mGpsY = location.getLongitude();
            tv_vcgpsx.setText(mGpsY+"");
            tv_fgpsy.setText(mGpsX+"");
            et_vcaddress.setText(add);
            // 设置自定义图标
            bitmap  = BitmapDescriptorFactory
                    .fromResource(R.mipmap.maker);
            MyLocationConfiguration config = new MyLocationConfiguration(
                    mCurrentMode, true, bitmap);
            mBaiduMap.setMyLocationConfigeration(config);
            mBaiduMap.setMyLocationConfigeration(config);
            // 第一次定位时，将地图位置移动到当前位置
            if (isFristLocation){
                isFristLocation= false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MarkerOptions options = new MarkerOptions().position(ll)
                        .icon(bitmap);
                // 在地图上添加Marker，并显示
                mBaiduMap.addOverlay(options);
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
                mBaiduMap.animateMapStatus(u);
            }
        }

    }

    @Override
    protected void onStart() {
        //开启图层定位
//        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()){
            mLocationClient.start();
        }
        super.onStart();
    }

    @Override
    protected void onStop() {
        //关闭图层定位
//        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        super.onStop();
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
    protected void onPause()
    {
        super.onPause();
        // 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapview.onPause();
    }

}
