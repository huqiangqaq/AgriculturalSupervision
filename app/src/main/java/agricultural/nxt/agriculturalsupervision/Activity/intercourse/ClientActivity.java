package agricultural.nxt.agriculturalsupervision.Activity.intercourse;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.CircularAnimUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.ClientAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Client;
import butterknife.BindView;

public class ClientActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
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
    private static int REQUEST_COUNT = 20;

    /**
     * 已经获取到多少条数据了
     */
    private int page=1;
    private static int mCurrentCounter = 0;
    private List<Client.ListBean> dataList;
    private ClientAdapter adapter;
    private Map<String,String> map = new HashMap<>();
    private XRecyclerView xRecyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("往来客户管理");
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
        fab.setOnClickListener(v -> fabAction());
        initData();
    }
    private void fabAction() {
        Intent intent = new Intent(this, ClientAddUpdateActivity.class);
        intent.putExtra("type", "add");
        CircularAnimUtil.startActivity(this, intent, fab,
                R.color.common_color);
    }
    private void initData() {
        refresh();
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                OkhttpHelper.Post(Constants.CLIENT + page, map, new OkhttpHelper.PostCallBack() {
                    @Override
                    public void onSuccess(String response, int tag) {
                        if (response!=null){
                            Client client = new Gson().fromJson(response, Client.class);
                            dataList.clear();
                            dataList.addAll(client.getList());
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
                if (mCurrentCounter<TOTAL_COUNTER){
                    OkhttpHelper.Post(Constants.CLIENT + page, map, new OkhttpHelper.PostCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            if (response!=null){
                                Client client = new Gson().fromJson(response, Client.class);
                                dataList.addAll(client.getList());
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
        OkhttpHelper.Post(Constants.CLIENT + page, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                Client client = new Gson().fromJson(response, Client.class);
                dataList = new ArrayList<>();
                dataList = client.getList();
                TOTAL_COUNTER = client.getCount();
                adapter = new ClientAdapter(ClientActivity.this,dataList);
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
        Intent intent = new Intent(context, ClientActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_client;
    }
}
