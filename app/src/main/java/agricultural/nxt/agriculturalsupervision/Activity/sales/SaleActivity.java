package agricultural.nxt.agriculturalsupervision.Activity.sales;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.nxt.zyl.util.ZPreferenceUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Activity.purchase.PurchaseAddActivity;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.SaleAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Sale;
import butterknife.BindView;

public class SaleActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    /**
     * 服务器端一共多少条数据
     */
    private static int TOTAL_COUNTER = 20;

    /**
     * 每一页展示多少条数据
     */
    private static int REQUEST_COUNT = 20;

    /**
     * 已经获取到多少条数据了
     */
    private int page=1;
    private static int mCurrentCounter = 0;
    private List<Sale.ListBean> dataList;
    private SaleAdapter adapter;
    private Map<String,String> map = new HashMap<>();
    private XRecyclerView xRecyclerView;
    private static final int REQUESTCODE = 1;
    private String url = null;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        if (ZPreferenceUtils.getPrefBoolean("isCheck",false)){
            url = Constants.SALE_VIEW;
        }else {
            url = Constants.SALE;
        }
        toolBar.setTitle("种子销售");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        xRecyclerView = (XRecyclerView) findViewById(R.id.xrecyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(manager);

        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        xRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        xRecyclerView.setHasFixedSize(true);
        xRecyclerView.setLoadingMoreEnabled(true);
        fab.setOnClickListener(v -> startActivity(new Intent(this,PurchaseAddActivity.class).putExtra("type","Add")));
//        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        initData();
    }

    private void initData() {
        refresh();
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                OkhttpHelper.Post(url + page, map, new OkhttpHelper.PostCallBack() {
                    @Override
                    public void onSuccess(String response, int tag) {
                        if (response!=null){
                            Sale lib = new Gson().fromJson(response, Sale.class);
                            dataList.clear();
                            dataList.addAll(lib.getList());
                            adapter.notifyDataSetChanged();
                            xRecyclerView.refreshComplete();
                        }
                    }

                    @Override
                    public void onFailed(String error, int tag) {

                    }

                    @Override
                    public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                    }
                },2);
            }

            @Override
            public void onLoadMore() {
                page++;
                if (mCurrentCounter+20<TOTAL_COUNTER){
                    OkhttpHelper.Post(url + page, map, new OkhttpHelper.PostCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            if (response!=null){
                                Sale lib = new Gson().fromJson(response, Sale.class);
                                dataList.addAll(lib.getList());
                                adapter.notifyItemInserted(dataList.size());
                                xRecyclerView.loadMoreComplete();
                                mCurrentCounter = dataList.size();
                            }
                        }

                        @Override
                        public void onFailed(String error, int tag) {

                        }

                        @Override
                        public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

                        }
                    },3);
                }else {
                    xRecyclerView.loadMoreComplete();
                    xRecyclerView.setNoMore(true);
                }
            }
        });

    }
    private void refresh() {
        page=1;
        OkhttpHelper.Post(url + page, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                Sale sale = new Gson().fromJson(response, Sale.class);
                dataList = new ArrayList<>();
                dataList = sale.getList();
                TOTAL_COUNTER = sale.getCount();
                adapter = new SaleAdapter(dataList,SaleActivity.this);
                xRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailed(String error, int tag) {

            }

            @Override
            public void onProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

            }
        }, 1);
    }
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SaleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_sale;
    }
}
