package agricultural.nxt.agriculturalsupervision.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.github.jdsjlzx.util.RecyclerViewStateUtils;
import com.github.jdsjlzx.view.LoadingFooter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.NetworkUtils;
import agricultural.nxt.agriculturalsupervision.Widget.LetToolBar;
import agricultural.nxt.agriculturalsupervision.Widget.NiceSpinner;
import agricultural.nxt.agriculturalsupervision.adapter.AnnounceAdapter;
import agricultural.nxt.agriculturalsupervision.base.BaseActivity;
import agricultural.nxt.agriculturalsupervision.entity.ItemModel;
import butterknife.BindView;
import butterknife.OnClick;

public class AnnounceActivity extends BaseActivity {
    @BindView(R.id.lettoolbar)
    LetToolBar toolBar;
    @BindView(R.id.line_shaixuan)
    LinearLayout ll_shaixuan;
    @BindView(R.id.sp_status)
    NiceSpinner sp_status;
    @BindView(R.id.list)
    LRecyclerView mRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private static final String TAG = "lzx";

    /**服务器端一共多少条数据*/
    private static final int TOTAL_COUNTER = 64;

    /**每一页展示多少条数据*/
    private static final int REQUEST_COUNT = 10;

    /**已经获取到多少条数据了*/
    private static int mCurrentCounter = 0;

    private AnnounceAdapter mDataAdapter = null;

    private PreviewHandler mHandler = new PreviewHandler(this);
    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;

    private boolean isRefresh = false;
    private List<String> dataset = new LinkedList<>(Arrays.asList("全部", "有效", "无效"));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        toolBar.setTitle("通知公告");
        toolBar.setLeftButtonIcon(getResources().getDrawable(R.mipmap.icon_arrow_02));
        toolBar.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_shaixuan.getVisibility()==View.VISIBLE){
                    ll_shaixuan.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.VISIBLE);
                }else {
                    finish();
                }

            }
        });
        toolBar.setRightButtonIcon(getResources().getDrawable(R.mipmap.icon_search1));
        toolBar.setRightButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setVisibility(View.GONE);
                ll_shaixuan.setVisibility(View.VISIBLE);
            }
        });
        sp_status.attachDataSource(dataset);


        ArrayList<ItemModel> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.title = "item" + i;
            dataList.add(itemModel);
            mCurrentCounter += dataList.size();
        }
        mDataAdapter = new AnnounceAdapter(this);
        mDataAdapter.setDataList(dataList);
        mDataAdapter.setOnDelListener(new AnnounceAdapter.onSwipeListener() {
            @Override
            public void onDel(int pos) {
                Toast.makeText(AnnounceActivity.this, "删除:" + pos, Toast.LENGTH_SHORT).show();

                //RecyclerView关于notifyItemRemoved的那点小事 参考：http://blog.csdn.net/jdsjlzx/article/details/52131528
//                mDataAdapter.getDataList().remove(pos);
                mDataAdapter.notifyItemRemoved(pos);//推荐用这个

                if(pos != (mDataAdapter.getDataList().size())){ // 如果移除的是最后一个，忽略
                    mDataAdapter.notifyItemRangeChanged(pos, mDataAdapter.getDataList().size() - pos);
                }
                //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
            }

            @Override
            public void onTop(int pos) {//置顶功能有bug，后续解决

                ItemModel itemModel = mDataAdapter.getDataList().get(pos);

                mDataAdapter.getDataList().remove(pos);
                mDataAdapter.notifyItemRemoved(pos);
                mDataAdapter.getDataList().add(0, itemModel);
                mDataAdapter.notifyItemInserted(0);


                if(pos != (mDataAdapter.getDataList().size())){ // 如果移除的是最后一个，忽略
                    mDataAdapter.notifyItemRangeChanged(0, mDataAdapter.getDataList().size() - 1,"jdsjlzx");
                }

                mRecyclerView.scrollToPosition(0);

            }
        });

        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mDataAdapter);
        mRecyclerView.setAdapter(mLRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        //添加headerview
//        mLRecyclerViewAdapter.addHeaderView(new SampleHeader(this));

        mRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                RecyclerViewStateUtils.setFooterViewState(mRecyclerView,LoadingFooter.State.Normal);
                mDataAdapter.clear();
                mLRecyclerViewAdapter.notifyDataSetChanged();//fix bug:crapped or attached views may not be recycled. isScrap:false isAttached:true
                mCurrentCounter = 0;
                isRefresh = true;
                requestData();
            }
        });

        mRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
                if(state == LoadingFooter.State.Loading) {
                    Log.d(TAG, "the state is Loading, just wait..");
                    return;
                }

                if (mCurrentCounter < TOTAL_COUNTER) {
                    // loading more
                    RecyclerViewStateUtils.setFooterViewState(AnnounceActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                    requestData();
                } else {
                    //the end
                    RecyclerViewStateUtils.setFooterViewState(AnnounceActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);

                }
            }
        });


        mRecyclerView.setRefreshing(true);

    }

    private void notifyDataSetChanged() {
        mLRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void addItems(ArrayList<ItemModel> list) {

        mDataAdapter.addAll(list);
        mCurrentCounter += list.size();

    }

    private View.OnClickListener mFooterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewStateUtils.setFooterViewState(AnnounceActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
            requestData();
        }
    };
    @OnClick(R.id.fab) void fab(){
        AnnounceAddActivity.actionStart(this);
    }

    /**
     * 模拟请求网络
     */
    private void requestData() {
        Log.d(TAG, "requestData");
        new Thread() {

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //模拟一下网络请求失败的情况
                if(NetworkUtils.isNetAvailable(AnnounceActivity.this)) {
                    mHandler.sendEmptyMessage(-1);
                } else {
                    mHandler.sendEmptyMessage(-3);
                }
            }
        }.start();
    }


    public static void actionStart(Context context){
        Intent intent = new Intent(context,AnnounceActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_announce;
    }

    private static class PreviewHandler extends Handler {

        private WeakReference<AnnounceActivity> ref;

        PreviewHandler(AnnounceActivity activity) {
            ref = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final AnnounceActivity activity = ref.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            switch (msg.what) {

                case -1:
                    if(activity.isRefresh){
                        activity.mDataAdapter.clear();
                        mCurrentCounter = 0;
                    }

                    int currentSize = activity.mDataAdapter.getItemCount();

                    //模拟组装10个数据
                    ArrayList<ItemModel> newList = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        if (newList.size() + currentSize >= TOTAL_COUNTER) {
                            break;
                        }

                        ItemModel item = new ItemModel();
                        item.id = currentSize + i;
                        item.title = "item" + (item.id);

                        newList.add(item);
                    }


                    activity.addItems(newList);

                    if(activity.isRefresh){
                        activity.isRefresh = false;
                        activity.mRecyclerView.refreshComplete();
                    }

                    RecyclerViewStateUtils.setFooterViewState(activity.mRecyclerView, LoadingFooter.State.Normal);
                    activity.notifyDataSetChanged();
                    break;
                case -2:
                    activity.notifyDataSetChanged();
                    break;
                case -3:
                    if(activity.isRefresh){
                        activity.isRefresh = false;
                        activity.mRecyclerView.refreshComplete();
                    }
                    activity.notifyDataSetChanged();
                    RecyclerViewStateUtils.setFooterViewState(activity, activity.mRecyclerView, REQUEST_COUNT, LoadingFooter.State.NetWorkError, activity.mFooterClick);
                    break;
                default:
                    break;
            }
        }

    }


}
