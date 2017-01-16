package agricultural.nxt.agriculturalsupervision.Activity.pesticideLib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.adapter.PesticideLibAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.Lib;
import butterknife.BindView;

public class PesticideLibActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
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
    private List<Lib.ListBean> dataList;
    private PesticideLibAdapter adapter;
    private Map<String,String> map = new HashMap<>();
    private  XRecyclerView xRecyclerView;
    private static final int REQUESTCODE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("农药库管理");
        toolBar.setLeftButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_arrow_02));
        toolBar.setRightButtonIcon(ContextCompat.getDrawable(this,R.mipmap.icon_search1));
        toolBar.setLeftButtonOnClickLinster(v -> finish());
        toolBar.setRightButtonOnClickLinster(v -> {
            Intent intent = new Intent(this,SearchActivity.class);
            startActivityForResult(intent,REQUESTCODE);
        });
        xRecyclerView = (XRecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(manager);

        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        xRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        xRecyclerView.setHasFixedSize(true);
        xRecyclerView.setLoadingMoreEnabled(true);
//        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        initData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pesticide_lib;
  }
    private void initData() {
        refresh();
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                OkhttpHelper.Post(Constants.PESTICIDELIB_LIST + page, map, new OkhttpHelper.PostCallBack() {
                    @Override
                    public void onSuccess(String response, int tag) {
                        if (response!=null){
                            Lib lib = new Gson().fromJson(response, Lib.class);
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
                    OkhttpHelper.Post(Constants.PESTICIDELIB_LIST + page, map, new OkhttpHelper.PostCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            if (response!=null){
                                Lib lib = new Gson().fromJson(response, Lib.class);
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
        OkhttpHelper.Post(Constants.PESTICIDELIB_LIST + page, map, new OkhttpHelper.PostCallBack() {
            @Override
            public void onSuccess(String response, int tag) {
                Lib lib = new Gson().fromJson(response, Lib.class);
                dataList = new ArrayList<Lib.ListBean>();
                dataList = lib.getList();
                TOTAL_COUNTER = lib.getCount();
                adapter = new PesticideLibAdapter(PesticideLibActivity.this,dataList);
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
        Intent intent = new Intent(context, PesticideLibActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1&resultCode==RESULT_OK){
            String registrationNo = data.getStringExtra("param1");
            String name = data.getStringExtra("param2");
            String companyName = data.getStringExtra("param3");
            String toxicity = data.getStringExtra("param4");
            map.put("registrationNo",registrationNo);
            map.put("name",name);
            map.put("companyName",companyName);
            map.put("toxicity",toxicity);
            refresh();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
