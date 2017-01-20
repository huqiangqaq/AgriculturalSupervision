package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.Activity.purchase.PurFerAddActivity;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.entity.PurFertilizer;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by huqiang on 2017/1/19 13:11.
 */

public class PurFertilizerAdapter extends RecyclerView.Adapter<PurFertilizerAdapter.ViewHolder>{
    private List<PurFertilizer.ListBean> list;
    private Context mContext;
    private ProgressDialog loadingDialog;
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
//        Date date = new Date(purchase.getDtpodate());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String sb = format.format(date);
        holder.dtpodate.setText(purchase.getDtpodate());
        holder.btnDel.setOnClickListener(v -> delete(holder,position));
        holder.btnUpdate.setOnClickListener(v -> update(holder,position));
    }
    private void update(ViewHolder holder, int position) {
        Intent intent = new Intent(mContext, PurFerAddActivity.class);
        PurFertilizer.ListBean listBean = list.get(position);
        intent.putExtra("purFert",listBean);
        intent.putExtra("type","update");
        ((SwipeMenuLayout) holder.itemView).quickClose();
        mContext.startActivity(intent);
    }

    private void delete(ViewHolder holder, int position) {
        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("确定删除此条记录吗?")
                .setPositiveButton("确定", (dialog, which) -> {
                    String id = list.get(position).getId();
                    showLoadingDialog("删除中...");
                    OkhttpHelper.Get(Constants.PUR_FER_DEL + id, new OkhttpHelper.GetCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            dismissLoadingDialog();
                            if (TextUtils.equals(JsonUtil.PareJson(response), "true")) {
                                new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                                        .setConfirmText("删除成功")
                                        .show();
                                holder.swipe_content.quickClose();
                                list.remove(position );
                                notifyDataSetChanged();
                            } else {
                                new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE)
                                        .setConfirmText("删除失败," + JsonUtil.ParseMsg(response))
                                        .show();
                            }
                        }

                        @Override
                        public void onFailed(String error, int tag) {

                        }
                    }, 1);
                }).setNegativeButton("取消",(dialog, which) -> dialog.dismiss()).show();


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
    /**
     * 显示进度对话框
     *
     * @param message {@link String} 消息文本
     */
    private void showLoadingDialog(String message) {

        if (loadingDialog == null) {
            loadingDialog = new ProgressDialog(mContext);
        }
        loadingDialog.setMessage(message);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
    }

    /**
     * 取消进度对话框
     */
    private void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }
}
