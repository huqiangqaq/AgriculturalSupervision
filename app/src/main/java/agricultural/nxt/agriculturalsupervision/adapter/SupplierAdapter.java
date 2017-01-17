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

import agricultural.nxt.agriculturalsupervision.Activity.intercourse.SupplierAddUpdateActivity;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.entity.Supplier;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by huqiang on 2017/1/16 16:34.
 */

public class SupplierAdapter extends RecyclerView.Adapter<SupplierAdapter.ViewHolder> {
    private ProgressDialog loadingDialog;
    private Context mContext;
    private List<Supplier.ListBean> list;

    public SupplierAdapter(Context mContext, List<Supplier.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_supplier,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Supplier.ListBean supplier = list.get(position);
        holder.vcmysuppliername.setText(supplier.getVcmysuppliername());
        holder.vccorporation.setText(supplier.getVccorporation());
        holder.vcphone.setText(supplier.getVcphone());
        holder.vcaddress.setText(supplier.getVcaddress());
        holder.vcemail.setText(supplier.getVcemail());
        holder.vcbizlicense.setText(supplier.getVcbizlicense());
        holder.vcproductlicense.setText(supplier.getVcproductlicense());
        holder.btn_del.setOnClickListener(v -> delete(holder,position));
        holder.btn_update.setOnClickListener(v -> update(holder,position));
    }

    private void update(ViewHolder holder, int position) {
        Intent intent = new Intent(mContext, SupplierAddUpdateActivity.class);
        Supplier.ListBean listBean = list.get(position);
        intent.putExtra("supplier",listBean);
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
                    OkhttpHelper.Get(Constants.SUPPLIER_DEL + id, new OkhttpHelper.GetCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            dismissLoadingDialog();
                            if (TextUtils.equals(JsonUtil.PareJson(response), "true")) {
                                new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                                        .setConfirmText("删除成功")
                                        .show();
                                ((SwipeMenuLayout) holder.itemView).quickClose();
                                list.remove(position);
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
                }).setNegativeButton("取消", (dialog, which) -> dialog.dismiss()).show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView vcmysuppliername,vccorporation,vcphone,vcaddress,vcemail,vcbizlicense,vcproductlicense;
        public Button btn_del,btn_update;
        public ViewHolder(View view){
            super(view);
            vcmysuppliername = (TextView) view.findViewById(R.id.vcmysuppliername);
            vccorporation = (TextView) view.findViewById(R.id.vccorporation);
            vcphone = (TextView) view.findViewById(R.id.vcphone);
            vcaddress = (TextView) view.findViewById(R.id.vcaddress);
            vcemail = (TextView) view.findViewById(R.id.vcemail);
            vcbizlicense = (TextView) view.findViewById(R.id.vcbizlicense);
            vcproductlicense = (TextView) view.findViewById(R.id.vcproductlicense);
            btn_del = (Button) view.findViewById(R.id.btnDel);
            btn_update = (Button) view.findViewById(R.id.btn_update);
        }
    }
    /**
     * 显示进度对话框
     *
     * @param message {@link String} 消息文本
     */
    protected void showLoadingDialog(String message) {

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
    protected void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }
}
