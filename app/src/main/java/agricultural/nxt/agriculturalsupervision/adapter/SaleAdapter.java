package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.entity.Sale;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by huqiang on 2017/1/19 9:42.
 */

public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.ViewHolder> {
    private List<Sale.ListBean> list;
    private Context mContext;
    protected ProgressDialog loadingDialog;

    public SaleAdapter(List<Sale.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_sale,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Sale.ListBean sale = list.get(position);
        holder.id.setText(sale.getSoh().getId());
        holder.vcmycustomername.setText(sale.getSoh().getMyCustomer().getVcmycustomername());
        holder.vcvarietyname.setText(sale.getSeedbatch().getSeed().getVcvarietyname());
        holder.vcorgname.setText(sale.getOwner().getVcorgname());
        holder.fponumber.setText(sale.getFnumber());
        holder.fprice.setText(sale.getFprice());
        holder.vcunit.setText(sale.getVcunit());
        holder.dtpodate.setText(sale.getDtsodate());
        holder.btnDel.setOnClickListener(v -> delete(holder,position));
    }

    private void delete(ViewHolder holder, int position) {

        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("确定删除此条记录吗?")
                .setPositiveButton("确定", (dialog, which) -> {
                    String id = list.get(position).getId();
                    showLoadingDialog("删除中...");
                    OkhttpHelper.Get(Constants.SALE_DEL + id, new OkhttpHelper.GetCallBack() {
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
        public TextView id, vcmycustomername, vcvarietyname, vcorgname, fponumber, fprice, vcunit, dtpodate;
        public Button btnUpdate, btnDel;

        public ViewHolder(View view) {
            super(view);
            swipe_content = (SwipeMenuLayout) view.findViewById(R.id.swipe_content);
            id = (TextView) view.findViewById(R.id.id);
            vcorgname = (TextView) view.findViewById(R.id.vcorgname);
            vcvarietyname = (TextView) view.findViewById(R.id.vcvarietyname);
            vcmycustomername = (TextView) view.findViewById(R.id.vcmycustomername);
            fponumber = (TextView) view.findViewById(R.id.fponumber);
            fprice = (TextView) view.findViewById(R.id.fprice);
            vcunit = (TextView) view.findViewById(R.id.vcunit);
            dtpodate = (TextView) view.findViewById(R.id.dtpodate);
            btnUpdate = (Button) view.findViewById(R.id.btUpdate);
            btnDel = (Button) view.findViewById(R.id.btnDel);
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
