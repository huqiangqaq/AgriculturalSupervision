package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.entity.CompanyView;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by huqiang on 2017/1/12 16:12.
 */

public class CompanyAdapter extends BaseAdapter {
    private Context mContext;
    private List<CompanyView.ListBean> list = new ArrayList<>();
    protected ProgressDialog loadingDialog;
    private CompanyAdapter.ViewHolder holder;
    private CompanyAdapter.onSwipeCheck swipeCheck;
    private CompanyView.ListBean company;
    private boolean canCheck;

    public CompanyAdapter(Context mContext, List<CompanyView.ListBean> list, boolean canCheck) {
        this.mContext = mContext;
        this.list = list;
        this.canCheck = canCheck;
    }

    public void setList(List<CompanyView.ListBean> list) {
        this.list = list;
    }

    public void setSwipeCheck(onSwipeCheck swipeCheck) {
        this.swipeCheck = swipeCheck;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder = new ViewHolder();
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.company_item,parent,false);
            holder.swipe_content = (SwipeMenuLayout) convertView.findViewById(R.id.swipe_content);
            holder.tv_province = (TextView) convertView.findViewById(R.id.province);
            holder.tv_vcorgname = (TextView) convertView.findViewById(R.id.vcorgname);
            holder.tv_vccorporation = (TextView) convertView.findViewById(R.id.vccorporation);
            holder.tv_vcphone = (TextView) convertView.findViewById(R.id.vcphone);
            holder.tv_icheckstaus = (TextView) convertView.findViewById(R.id.icheckstatus);
            holder.tv_ikind = (TextView) convertView.findViewById(R.id.ikind);
            holder.tv_updateTime = (TextView) convertView.findViewById(R.id.updateTime);
            holder.btn_del = (Button) convertView.findViewById(R.id.btn_del);
            holder.btn_check = (Button) convertView.findViewById(R.id.btn_check);
            holder.btn_checkf = (Button) convertView.findViewById(R.id.btn_checkf);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        final SwipeMenuLayout finalConvertView = (SwipeMenuLayout) convertView;
        company = list.get(position);
        holder.tv_province.setText(company.getArea().getName());
        holder.tv_vcorgname.setText(company.getVcorgname());
        holder.tv_vccorporation.setText(company.getVccorporation());
        holder.tv_vcphone.setText(company.getVcphone());
        if ("-1".equals(company.getIcheckstatus())){
            holder.tv_icheckstaus.setText("待审核");
        }else if ("0".equals(company.getIcheckstatus())){
            holder.tv_icheckstaus.setText("未审核通过");
        }else if ("1".equals(company.getIcheckstatus())){
            holder.tv_icheckstaus.setText("审核通过");
        }
        holder.tv_ikind.setText(company.getIkind());
        holder.tv_updateTime.setText(company.getUpdateDate());
        if (canCheck){
            if ("-1".equals(company.getIcheckstatus())){
                holder.btn_checkf.setVisibility(View.VISIBLE);
                holder.btn_check.setVisibility(View.VISIBLE);
                holder.btn_del.setVisibility(View.VISIBLE);
            }else {
                holder.btn_del.setVisibility(View.VISIBLE);
            }
        }
        //删除
        holder.btn_del.setOnClickListener(v ->delete(holder,position) );

        //审核通过
        holder.btn_check.setOnClickListener(v -> swipeCheck.onCheck(position,finalConvertView,"1"));
        holder.btn_checkf.setOnClickListener(v -> swipeCheck.onCheck(position,finalConvertView,"0"));
        return convertView;
    }
    private void delete(final CompanyAdapter.ViewHolder holder, final int pos) {
        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("确定删除此条记录吗?")
                .setPositiveButton("确定", (dialog, which) -> {
                    String id = list.get(pos).getId();
                    showLoadingDialog("删除中...");
                    OkhttpHelper.Get(Constants.COMPANY_DEL + id, new OkhttpHelper.GetCallBack() {
                        @Override
                        public void onSuccess(String response, int tag) {
                            dismissLoadingDialog();
                            if (TextUtils.equals(JsonUtil.PareJson(response), "true")) {
                                new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                                        .setConfirmText("删除成功")
                                        .show();
                                holder.swipe_content.quickClose();
                                list.remove(pos);
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

    private class ViewHolder {
        SwipeMenuLayout swipe_content;
        TextView tv_province, tv_vcorgname, tv_vccorporation, tv_vcphone,tv_icheckstaus,tv_ikind,tv_updateTime;
        Button btn_del, btn_check,btn_checkf;
    }

    public interface onSwipeCheck{
        void onCheck(int postion,SwipeMenuLayout finalConvertView,String status);
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
