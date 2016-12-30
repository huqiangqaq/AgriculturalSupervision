package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.google.gson.Gson;
import com.nxt.zyl.util.ZPreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.SeedAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Seed;
import butterknife.BindView;

public class RecodeActivity extends BaseActivity {
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
    private List<Seed.ListBean> dataList = new ArrayList<>();
    private static SeedAdapter adapter = null;
    private PtrClassicFrameLayout ptrClassicFrameLayout = null;
    private String url = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("种子备案");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ptrClassicFrameLayout = (PtrClassicFrameLayout) this.findViewById(R.id.test_list_view_frame);
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        if (ZPreferenceUtils.getPrefBoolean("查看", false)) {
            url = Constants.SEED_RECODE_VIEW;
        } else {
            url = Constants.SEED_RECODE;
        }
        initData();
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
                            Seed seed = new Gson().fromJson(response, Seed.class);
                            dataList = seed.getList();
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
                    OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            if (response != null) {
                                Seed seed = new Gson().fromJson(response, Seed.class);
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
        OkhttpHelper.Get(url + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                Seed seed = new Gson().fromJson(response, Seed.class);
                dataList = seed.getList();
                TOTAL_COUNTER = seed.getCount();
                adapter = new SeedAdapter(RecodeActivity.this, dataList);
                lv_integrity.setAdapter(adapter);
                ptrClassicFrameLayout.autoRefresh(true);
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        }, 1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recode;
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RecodeActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }
}
