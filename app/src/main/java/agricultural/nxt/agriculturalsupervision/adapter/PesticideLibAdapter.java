package agricultural.nxt.agriculturalsupervision.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.Activity.WebActivity;
import agricultural.nxt.agriculturalsupervision.Activity.pesticideLib.LibDetailActivity;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.Lib;

/**
 * Created by huqiang on 2017/1/13 11:49.
 */

public class PesticideLibAdapter extends RecyclerView.Adapter<PesticideLibAdapter.ViewHolder>{
    private List<Lib.ListBean> list;
    private Context mContext;
    public PesticideLibAdapter(Context context,List<Lib.ListBean> list) {
        this.list = list;
        this.mContext = context;
    }

    public void setList(List<Lib.ListBean> list) {
        this.list = list;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesticidelib,parent,false);
        return new ViewHolder(view);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.registrationNo.setText(list.get(position).getRegistrationNo());
        holder.name.setText(list.get(position).getName());
        holder.companyName.setText(list.get(position).getCompanyName());
        holder.toxicity.setText(list.get(position).getToxicity());
        holder.btn_detail.setOnClickListener(v -> {
            Lib.ListBean listBean = list.get(position);
            Intent intent = new Intent(mContext, LibDetailActivity.class);
            intent.putExtra("lib",listBean);
            mContext.startActivity(intent);
        });
        holder.btn_top.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, WebActivity.class);
            intent.putExtra("label", Constants.LABEL+list.get(position).getRegistrationNo());
            mContext.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView registrationNo,name,companyName,toxicity;
        public Button btn_top,btn_detail;
        public ViewHolder(View view){
            super(view);
            registrationNo = (TextView) view.findViewById(R.id.registrationNo);
            name = (TextView) view.findViewById(R.id.name);
            companyName = (TextView) view.findViewById(R.id.companyName);
            toxicity = (TextView) view.findViewById(R.id.toxicity);
            btn_top = (Button) view.findViewById(R.id.btnTop);
            btn_detail = (Button) view.findViewById(R.id.btn_detail);
        }
    }
}
