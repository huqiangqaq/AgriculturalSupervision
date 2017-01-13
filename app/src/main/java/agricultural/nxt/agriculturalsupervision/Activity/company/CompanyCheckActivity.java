package agricultural.nxt.agriculturalsupervision.Activity.company;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.ListView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.Activity.RecodeActivity;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.SeedAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Seed;
import butterknife.BindView;

public class CompanyCheckActivity extends BaseActivity {
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
    private List<Seed.ListBean> dataList = new ArrayList<>();
    private static SeedAdapter adapter = null;
    private PtrClassicFrameLayout ptrClassicFrameLayout = null;
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
//        initData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_company_check;
    }
//    private void initData() {
//        refresh();
//        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//                OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
//                    @Override
//                    public void onSuccess(String response, int tag) {
//                        if (response != null) {
//                            Seed seed = new Gson().fromJson(response, Seed.class);
//                            dataList = seed.getList();
//                            adapter.notifyDataSetChanged();
//                            ptrClassicFrameLayout.refreshComplete();
//                            ptrClassicFrameLayout.setLoadMoreEnable(true);
//                        }
//                    }
//
//                    @Override
//                    public void onFailed(String error, int tag) {
//
//                    }
//                }, 1);
//            }
//        });
//
//        ptrClassicFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void loadMore() {
//                REQUEST_COUNT += 10;
//                if (mCurrentCounter + 10 < TOTAL_COUNTER) {
//                    OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
//                        @Override
//                        public void onSuccess(String response, int tag) {
//                            if (response != null) {
//                                Seed seed = new Gson().fromJson(response, Seed.class);
//                                dataList.clear();
//                                dataList.addAll(seed.getList());
//                                adapter.notifyDataSetChanged();
//                                ptrClassicFrameLayout.loadMoreComplete(true);
//                                mCurrentCounter = dataList.size();
//                            }
//                        }
//
//                        @Override
//                        public void onFailed(String error, int tag) {
//
//                        }
//                    }, 2);
//                } else {
//                    ptrClassicFrameLayout.loadMoreComplete(true);
//                    ptrClassicFrameLayout.setNoMoreData();
//                }
//            }
//        });
//    }
//
//    private void refresh() {
//        OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
//            @Override
//            public void onSuccess(String response, int tag) {
//                Seed seed = new Gson().fromJson(response, Seed.class);
//                dataList = seed.getList();
//                TOTAL_COUNTER = seed.getCount();
//                adapter = new SeedAdapter(RecodeActivity.this, dataList);
//                adapter.setSwipeCheck(new SeedAdapter.onSwipeCheck() {
//                    @Override
//                    public void onCheck(int postion, SwipeMenuLayout finalConvertView) {
//                        check(postion, finalConvertView);
//                    }
//                });
//                lv_integrity.setAdapter(adapter);
//                ptrClassicFrameLayout.autoRefresh(true);
//            }
//
//            @Override
//            public void onFailed(String error, int tag) {
//
//            }
//        }, 1);
//    }
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RecodeActivity.class);
        context.startActivity(intent);

    }
    @Override
    protected void onResume() {
        super.onResume();
//        refresh();
    }
}
