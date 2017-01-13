package agricultural.nxt.agriculturalsupervision.Activity.company;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.google.gson.Gson;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.CompanyAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.CompanyView;
import butterknife.BindView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class CompanyViewActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.lv_integrity)
    ListView lv_integrity;
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
    private List<CompanyView.ListBean> dataList = new ArrayList<>();
    private static CompanyAdapter adapter = null;
    private PtrClassicFrameLayout ptrClassicFrameLayout = null;
    private static boolean canCheck = false;
    private static String CheckOrViewurl = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("企业备案列表");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        ptrClassicFrameLayout = (PtrClassicFrameLayout) this.findViewById(R.id.test_list_view_frame);
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);

        initData();
    }

    private void initData() {
        refresh();
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                OkhttpHelper.Get(CheckOrViewurl + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
                    @Override
                    public void onSuccess(String response, int tag) {
                        if (response != null) {
                            CompanyView view = new Gson().fromJson(response, CompanyView.class);
                            dataList = view.getList();
                            adapter.notifyDataSetChanged();
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
                    OkhttpHelper.Get(CheckOrViewurl + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            if (response != null) {
                                CompanyView seed = new Gson().fromJson(response, CompanyView.class);
                                dataList.clear();
                                dataList.addAll(seed.getList());
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
        OkhttpHelper.Get(CheckOrViewurl + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                CompanyView view = new Gson().fromJson(response, CompanyView.class);
                dataList = view.getList();
               adapter = new CompanyAdapter(CompanyViewActivity.this,dataList,canCheck);
                lv_integrity.setAdapter(adapter);
                TOTAL_COUNTER = view.getCount();
                adapter.setSwipeCheck((postion, finalConvertView, status) -> {
                    check(postion,finalConvertView,status);
                });
                ptrClassicFrameLayout.autoRefresh(true);
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        }, 1);
    }

    public static void actionStart(Context context,boolean ischeck,String url) {
        Intent intent = new Intent(context, CompanyViewActivity.class);
        context.startActivity(intent);
        canCheck = ischeck;
        CheckOrViewurl = url;
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_company_view;
    }

    private void check(int postion, SwipeMenuLayout finalConvertView,String status) {
        new AlertDialog.Builder(CompanyViewActivity.this)
                .setTitle("系统提示")
                .setMessage("确定审批该企业备案吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String companyId = dataList.get(postion).getId();
                        showLoadingDialog(R.string.checking);
                        String url = Constants.COMPANY_CHECK+companyId+"&icheckstatus="+status;
                        OkhttpHelper.Get(url, new OkhttpHelper.GetCallBack() {
                            @Override
                            public void onSuccess(String response, int tag) {
                                dismissLoadingDialog();
                                if (TextUtils.equals(JsonUtil.PareJson(response), "true")) {
                                    new SweetAlertDialog(CompanyViewActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                            .setConfirmText("操作成功")
                                            .show();
                                    finalConvertView.quickClose();
                                    refresh();
                                } else {
                                    new SweetAlertDialog(CompanyViewActivity.this, SweetAlertDialog.ERROR_TYPE)
                                            .setConfirmText("操作失败," + JsonUtil.ParseMsg(response))
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
}
