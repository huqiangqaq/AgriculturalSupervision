package agricultural.nxt.agriculturalsupervision.Activity.fertilizer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.widget.ListView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.google.gson.Gson;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.nxt.zyl.util.ZPreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.CircularAnimUtil;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.FertilizerAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Fertilizer;
import butterknife.BindView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class FertilizerActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.lv_integrity)
    ListView lv_integrity;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private static final String TAG = "lzx";
    /**
     * 服务器端一共多少条数据
     */
    private static int TOTAL_COUNTER = 20;

    /**
     * 每一页展示多少条数据
     */
    private static int REQUEST_COUNT = 10;

    /**
     * 已经获取到多少条数据了
     */
    private static int mCurrentCounter = 0;
    private List<Fertilizer.ListBean> dataList = new ArrayList<>();
    private static FertilizerAdapter adapter = null;
    private PtrClassicFrameLayout ptrClassicFrameLayout = null;
    private String url = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("化肥备案");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        ptrClassicFrameLayout = (PtrClassicFrameLayout) this.findViewById(R.id.test_list_view_frame);
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        if (ZPreferenceUtils.getPrefBoolean("查看", false)) {
            url = Constants.FERTILIZER_RECODE_VIEW;
        } else {
            url = Constants.FERTILIZER_RECODE;
        }
        fab.setOnClickListener(v -> fabAction());
        initData();
    }
    private void fabAction() {
        Intent intent = new Intent(FertilizerActivity.this, FertilizerUpdateAddActivity.class);
        intent.putExtra("type", "add");
        CircularAnimUtil.startActivity(FertilizerActivity.this, intent, fab,
                R.color.common_color);
    }

    private void initData() {
        refresh();
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
                    @Override
                    public void onSuccess(String response, int tag) {
                        if (response != null) {
                            Fertilizer pesticide = new Gson().fromJson(response, Fertilizer.class);
                            dataList = pesticide.getList();
                            if (dataList!=null){
                                adapter.notifyDataSetChanged();
                            }
                            ptrClassicFrameLayout.refreshComplete();
                            ptrClassicFrameLayout.setLoadMoreEnable(true);
                        }
                    }

                    @Override
                    public void onFailed(String error, int tag) {

                    }
                }, 1);
            }
        });

        ptrClassicFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                REQUEST_COUNT += 10;
                if (mCurrentCounter + 10 < TOTAL_COUNTER) {
                    OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            if (response != null) {
                                Fertilizer fertilizer = new Gson().fromJson(response, Fertilizer.class);
                                dataList.clear();
                                dataList.addAll(fertilizer.getList());
                                adapter.notifyDataSetChanged();
                                ptrClassicFrameLayout.loadMoreComplete(true);
                                mCurrentCounter = dataList.size();
                            }
                        }

                        @Override
                        public void onFailed(String error, int tag) {

                        }
                    }, 2);
                } else {
                    ptrClassicFrameLayout.loadMoreComplete(true);
                    ptrClassicFrameLayout.setNoMoreData();
                }
            }
        });
    }

    private void refresh() {
        OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                Fertilizer fertilizer = new Gson().fromJson(response, Fertilizer.class);
                dataList = fertilizer.getList();
                if (dataList!=null){
                    TOTAL_COUNTER = fertilizer.getCount();
                    adapter = new FertilizerAdapter(FertilizerActivity.this, dataList);
                    adapter.setSwipeCheck(new FertilizerAdapter.onSwipeCheck() {
                        @Override
                        public void onCheck(int postion, SwipeMenuLayout finalConvertView) {
                            check(postion,finalConvertView);
                        }
                    });

                    lv_integrity.setAdapter(adapter);
                }

                ptrClassicFrameLayout.autoRefresh(true);
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        }, 1);
    }

    private void check(int postion, SwipeMenuLayout finalConvertView) {
        new AlertDialog.Builder(FertilizerActivity.this)
                .setTitle("系统提示")
                .setMessage("确定审批该化肥备案吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String id = dataList.get(postion).getId();
                        showLoadingDialog(R.string.checking);
                        OkhttpHelper.Get(Constants.FERTILIZER_CHECK + id, new OkhttpHelper.GetCallBack() {
                            @Override
                            public void onSuccess(String response, int tag) {
                                dismissLoadingDialog();
                                if (TextUtils.equals(JsonUtil.PareJson(response), "true")) {
                                    new SweetAlertDialog(FertilizerActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                            .setConfirmText("审核成功")
                                            .show();
                                    finalConvertView.quickClose();
                                    refresh();
                                } else {
                                    new SweetAlertDialog(FertilizerActivity.this, SweetAlertDialog.ERROR_TYPE)
                                            .setConfirmText("审核失败," + JsonUtil.ParseMsg(response))
                                            .show();
                                }
                            }

                            @Override
                            public void onFailed(String error, int tag) {

                            }
                        }, 2);
                    }
                }).setNegativeButton("取消", (dialog, which) -> dialog.dismiss()).show();

    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, FertilizerActivity.class);
        context.startActivity(intent);

    }
    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_fertilizer;
    }
}
