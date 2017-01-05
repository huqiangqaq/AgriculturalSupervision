package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.IntegrityMoreAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Integrity;
import butterknife.BindView;

public class IntegrityMoreActivity extends BaseActivity {
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
    private List<Integrity.ListBean> dataList = new ArrayList<>();
    private static IntegrityMoreAdapter adapter = null;
    private PtrClassicFrameLayout ptrClassicFrameLayout = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initData() {
        refresh();
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                OkhttpHelper.Get(Constants.INTEGRITY + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
                    @Override
                    public void onSuccess(String response, int tag) {
                        if (response != null) {
                            Integrity integrity = new Gson().fromJson(response, Integrity.class);
                            dataList = integrity.getList();
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
                if (mCurrentCounter < TOTAL_COUNTER) {
                    OkhttpHelper.Get(Constants.INTEGRITY + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            if (response != null) {
                                Integrity integrity = new Gson().fromJson(response, Integrity.class);
                                dataList.clear();
                                dataList.addAll(integrity.getList());
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
        OkhttpHelper.Get(Constants.INTEGRITY + REQUEST_COUNT, new OkhttpHelper.GetCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                Integrity integrity = new Gson().fromJson(response, Integrity.class);
                dataList = integrity.getList();
                TOTAL_COUNTER = integrity.getCount();
                adapter = new IntegrityMoreAdapter(IntegrityMoreActivity.this, dataList);
                lv_integrity.setAdapter(adapter);
                ptrClassicFrameLayout.autoRefresh(true);
            }

            @Override
            public void onFailed(String error, int tag) {

            }
        }, 1);
    }


    @Override
    protected void initView() {
        toolBar.setTitle("诚信列表");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        ptrClassicFrameLayout = (PtrClassicFrameLayout) this.findViewById(R.id.test_list_view_frame);
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        initData();

    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, IntegrityMoreActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_integrity_more;
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }
}
