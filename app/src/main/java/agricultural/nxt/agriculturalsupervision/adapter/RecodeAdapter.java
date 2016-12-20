package agricultural.nxt.agriculturalsupervision.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nxt.zyl.util.ZToastUtils;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Widget.SwipeMenuView;
import agricultural.nxt.agriculturalsupervision.base.ListBaseAdapter;
import agricultural.nxt.agriculturalsupervision.entity.RecodeReturn;

/**
 * Created by huqiang on 2016/12/20 15:10.
 */

public class RecodeAdapter extends ListBaseAdapter<RecodeReturn> {
    private LayoutInflater inflater;
    private Context mContext;

    public RecodeAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecodeAdapter.SwipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecodeAdapter.SwipeViewHolder(inflater.inflate(R.layout.recode_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        RecodeAdapter.SwipeViewHolder viewHolder = (RecodeAdapter.SwipeViewHolder) holder;
        //这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
//        ((SwipeMenuView) viewHolder.itemView).setIos(false).setLeftSwipe(position % 2 == 0 ? true : false);
        ((SwipeMenuView) viewHolder.itemView).setIos(false).setLeftSwipe(true);
        viewHolder.tv_id.setText(getDataList().get(position).getList().get(0).getId());
        viewHolder.tv_name.setText(getDataList().get(position).getList().get(0).getVcvarietyname());
        viewHolder.tv_speic.setText(getDataList().get(position).getList().get(0).getVccategory());
        viewHolder.tv_unit.setText(getDataList().get(position).getList().get(0).getVccheckerno());


        //隐藏控件
//        viewHolder.btnUnRead.setVisibility(position % 3 == 0 ? View.GONE : View.VISIBLE);

        viewHolder.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //((CstSwipeDelMenu) holder.itemView).quickClose();
                    mOnSwipeListener.onDel(position);
                }
            }
        });
        //注意事项，设置item点击，不能对整个holder.itemView设置咯，只能对第一个子View，即原来的content设置，这算是局限性吧。
        (viewHolder.contentView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZToastUtils.showShort(mContext, getDataList().get(position).getCount());
                Log.d("TAG", "onClick() called with: v = [" + v + "]");
            }
        });
        //置顶：
        viewHolder.btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
                    mOnSwipeListener.onUpdate(position);
                }

            }
        });
    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);

        void onUpdate(int pos);
    }

    private RecodeAdapter.onSwipeListener mOnSwipeListener;

    public void setOnDelListener(RecodeAdapter.onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }

    private class SwipeViewHolder extends RecyclerView.ViewHolder {
        View contentView;
        TextView tv_id;
        TextView tv_name;
        TextView tv_speic;
        TextView tv_unit;
        Button btn_update;
        Button btndel;

        SwipeViewHolder(View itemView) {
            super(itemView);
            contentView = itemView.findViewById(R.id.swipe_content);
            tv_id = (TextView) itemView.findViewById(R.id.tv_id);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_speic = (TextView) itemView.findViewById(R.id.tv_specie);
            tv_unit = (TextView) itemView.findViewById(R.id.tv_unit);
            btn_update = (Button) itemView.findViewById(R.id.btnupdate);
            btndel = (Button) itemView.findViewById(R.id.btnDelete);
        }
    }
}
