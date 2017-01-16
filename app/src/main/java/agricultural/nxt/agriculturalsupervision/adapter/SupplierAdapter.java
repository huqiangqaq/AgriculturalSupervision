package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.Supplier;

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
        holder.vcmysuppliername.setText(supplier.getVcmycustomername());
    }

    @Override
    public int getItemCount() {
        return 0;
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
