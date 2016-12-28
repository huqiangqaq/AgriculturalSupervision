package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

import agricultural.nxt.agriculturalsupervision.Activity.Integrity.IntegrityCheckActivity;
import agricultural.nxt.agriculturalsupervision.Activity.Integrity.IntegrityDetailActivity;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.entity.Integrity;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by huqiang on 2016/12/13 9:31.
 */

public class IntegrityMoreAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integrity.ListBean> list = new ArrayList<>();
    protected ProgressDialog loadingDialog;
    private ViewHolder holder;
    public IntegrityMoreAdapter(Context mContext, List<Integrity.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public List<Integrity.ListBean> getList() {
        return list;
    }

    public void setList(List<Integrity.ListBean> list) {
        this.list = list;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
         holder = new ViewHolder();
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.integrity_item,parent,false);
            holder.swipe_content = (SwipeMenuLayout) convertView.findViewById(R.id.swipe_content);
            holder.tv_illegalprod = (TextView) convertView.findViewById(R.id.tv_illegalprod);
            holder.tv_producttype = (TextView) convertView.findViewById(R.id.tv_producttype);
            holder.tv_vcillegalcomp = (TextView) convertView.findViewById(R.id.tv_vcillegalcomp);
            holder.tv_ownerName = (TextView) convertView.findViewById(R.id.tv_ownerName);
            holder.btn_check = (Button) convertView.findViewById(R.id.btn_check);
            holder.btn_del = (Button) convertView.findViewById(R.id.btn_del);
            holder.btn_detail = (Button) convertView.findViewById(R.id.btn_detail);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Integrity.ListBean bean = list.get(position);
        holder.tv_illegalprod.setText(bean.getVcillegalprod());
        holder.tv_producttype.setText(bean.getIproducttype());
        holder.tv_vcillegalcomp.setText(bean.getVcillegalcomp());
        holder.tv_ownerName.setText(bean.getOwnerName());
        String status = list.get(position).getIcheckstatus();
        //待审核
        if ("-1".equalsIgnoreCase(status)){
            holder.btn_check.setVisibility(View.VISIBLE);
        }
        final SwipeMenuLayout finalConvertView = (SwipeMenuLayout) convertView;
        holder.btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalConvertView.quickClose();
                Integrity.ListBean listBean = list.get(position);
                Intent intent = new Intent(mContext, IntegrityCheckActivity.class);
                intent.putExtra("id",listBean.getId());
                intent.putExtra("dtarosedate",listBean.getDtarosedate());
                intent.putExtra("vcillegalcomp",listBean.getVcillegalcomp());
                intent.putExtra("iproducttype",listBean.getIproducttype());
                intent.putExtra("vcillegalprod",listBean.getVcillegalprod());
                intent.putExtra("vcdesc",listBean.getVcdesc());
                mContext.startActivity(intent);
            }
        });

        holder.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalConvertView.quickClose();
                String id = list.get(position).getId();
                Intent intent = new Intent(mContext, IntegrityDetailActivity.class);
                intent.putExtra("id",id);
                mContext.startActivity(intent);
            }
        });
        final ViewHolder finalHolder = holder;
        holder.btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(finalHolder,position);
            }
        });
        return convertView;
    }



    private void delete(final ViewHolder holder, final int pos) {
        new AlertDialog.Builder(mContext)
                    .setTitle("提示")
                    .setMessage("确定删除此条记录吗?")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String id = list.get(pos).getId();
                            showLoadingDialog("删除中...");
                            OkhttpHelper.Get(Constants.INTEGRITY_DEL+id, new OkhttpHelper.GetCallBack() {
                                @Override
                                public void onSuccess(String response, int tag) {
                                    dismissLoadingDialog();
                                    if (TextUtils.equals(JsonUtil.PareJson(response),"true")){
                                        new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                                                .setConfirmText("删除成功")
                                                .show();
                                        holder.swipe_content.quickClose();
                                        list.remove(pos);
                                        notifyDataSetChanged();
                                    }else {
                                        new SweetAlertDialog(mContext,SweetAlertDialog.ERROR_TYPE)
                                                .setConfirmText("删除失败,"+JsonUtil.ParseMsg(response))
                                                .show();
                                    }
                                }

                                @Override
                                public void onFailed(String error, int tag) {

                                }
                            },1);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
    }


    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);
        void onDetail(int pos);
        void onCheck(int pos);
    }

    private onSwipeListener mOnSwipeListener;

    public void setOnSipeListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }

    private class ViewHolder{
        SwipeMenuLayout swipe_content;
        TextView tv_illegalprod,tv_producttype,tv_vcillegalcomp,tv_ownerName;
        Button btn_detail,btn_del,btn_check;

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
