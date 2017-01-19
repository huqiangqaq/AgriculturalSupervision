package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.PurFertilizer;

/**
 * Created by huqiang on 2017/1/19 13:11.
 */

public class PurFertilizerAdapter extends RecyclerView.Adapter<PurFertilizerAdapter.ViewHolder>{
    private List<PurFertilizer.ListBean> list;
    private Context mContext;
    protected ProgressDialog loadingDialog;
    private String type;

    public PurFertilizerAdapter(List<PurFertilizer.ListBean> list, Context mContext, String type) {
        this.list = list;
        this.mContext = mContext;
        this.type = type;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_purchase,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PurFertilizer.ListBean purchase = list.get(position);
        holder.id.setText(purchase.getPoh().getId());
        holder.vcorgname.setText(purchase.getOwner().getVcorgname());
        holder.vcvarietyname.setText(purchase.getFertilizer().getVcfertilizename());
        holder.tMysupplierName.setText(purchase.getPoh().getTMysupplierName());
        holder.fponumber.setText(purchase.getFponumber());
        holder.fprice.setText(purchase.getFprice());
        holder.vcunit.setText(purchase.getVcunit());
        holder.type.setText(type);
        Date date = new Date(purchase.getDtpodate());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sb = format.format(date);
        holder.dtpodate.setText(sb);
//        holder.btnDel.setOnClickListener(v -> delete(holder,position));
//        holder.btnUpdate.setOnClickListener(v -> update(holder,position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SwipeMenuLayout swipe_content;
        public TextView id,vcorgname,vcvarietyname,tMysupplierName,fponumber,fprice,vcunit,dtpodate,type;
        public Button btnUpdate,btnDel;
        public ViewHolder(View view){
            super(view);
            swipe_content = (SwipeMenuLayout) view.findViewById(R.id.swipe_content);
            id = (TextView) view.findViewById(R.id.id);
            vcorgname = (TextView) view.findViewById(R.id.vcorgname);
            vcvarietyname = (TextView) view.findViewById(R.id.vcvarietyname);
            tMysupplierName = (TextView) view.findViewById(R.id.tMysupplierName);
            fponumber = (TextView) view.findViewById(R.id.fponumber);
            fprice = (TextView) view.findViewById(R.id.fprice);
            vcunit = (TextView) view.findViewById(R.id.vcunit);
            dtpodate = (TextView) view.findViewById(R.id.dtpodate);
            btnUpdate = (Button) view.findViewById(R.id.btUpdate);
            btnDel = (Button) view.findViewById(R.id.btnDel);
            type = (TextView) view.findViewById(R.id.type);
        }
    }
}
