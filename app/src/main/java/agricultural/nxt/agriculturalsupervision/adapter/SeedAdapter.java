package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.nxt.zyl.util.ZPreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import agricultural.nxt.agriculturalsupervision.Activity.Seed.SeedDetailActivity;
import agricultural.nxt.agriculturalsupervision.Activity.Seed.SeedUpdateAddActivity;
import agricultural.nxt.agriculturalsupervision.Constants;
import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.Util.JsonUtil;
import agricultural.nxt.agriculturalsupervision.Util.OkhttpHelper;
import agricultural.nxt.agriculturalsupervision.entity.Seed;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by huqiang on 2016/12/29 14:04.
 */

public class SeedAdapter extends BaseAdapter {

    private Context mContext;
    private List<Seed.ListBean> list = new ArrayList<>();
    private ProgressDialog loadingDialog;
    private SeedAdapter.ViewHolder holder;
    private SparseArray<String> map = new SparseArray<>();
    private onSwipeCheck swipeCheck;
    private Seed.ListBean seed;

    public SeedAdapter(Context mContext, List<Seed.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public onSwipeCheck getSwipeCheck() {
        return swipeCheck;
    }

    public void setSwipeCheck(onSwipeCheck swipeCheck) {
        this.swipeCheck = swipeCheck;
    }

    public List<Seed.ListBean> getList() {
        return list;
    }

    public void setList(List<Seed.ListBean> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        holder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.seed_item, parent, false);
            holder.swipe_content = (SwipeMenuLayout) convertView.findViewById(R.id.swipe_content);
            holder.tv_vcvarietyname = (TextView) convertView.findViewById(R.id.tv_vcvarietyname);
            holder.tv_vccategory = (TextView) convertView.findViewById(R.id.tv_vccategory);
            holder.tv_icheckstatus = (TextView) convertView.findViewById(R.id.tv_icheckstatus);
            holder.tv_vcorgname = (TextView) convertView.findViewById(R.id.tv_vcorgname);
            holder.btn_check = (Button) convertView.findViewById(R.id.btn_check);
            holder.btn_del = (Button) convertView.findViewById(R.id.btn_del);
            holder.btn_detail = (Button) convertView.findViewById(R.id.btn_detail);
            holder.btn_update = (Button) convertView.findViewById(R.id.btn_update);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        seed = list.get(position);
        holder.tv_vcvarietyname.setText(seed.getVcvarietyname());
        holder.tv_vccategory.setText(seed.getVccategory());
        holder.tv_icheckstatus.setText("-1".equalsIgnoreCase(seed.getIcheckstatus())?"未审核":"已审核");
        holder.tv_vcorgname.setText(seed.getOwner().getVcorgname());
        String status = list.get(position).getIcheckstatus();
        map.put(position,status);
        boolean b1 = ZPreferenceUtils.getPrefBoolean("查看", false);
        boolean b2 = ZPreferenceUtils.getPrefBoolean("备案", false);
        boolean b3 = ZPreferenceUtils.getPrefBoolean("审核", false);

        if (b1 & b2 & b3) {                                    //全部权限
            holder.btn_detail.setVisibility(View.VISIBLE);
            holder.btn_del.setVisibility(View.VISIBLE);
            holder.btn_update.setVisibility(View.VISIBLE);
            if ("-1".equalsIgnoreCase(map.get(position))) {
                holder.btn_check.setVisibility(View.VISIBLE);
            }
        } else if (b1 & !b2 & !b3) {                            //只有查看权限
            holder.btn_detail.setVisibility(View.VISIBLE);
        } else if (b1 & b3) {                             //查看，审核
            holder.btn_detail.setVisibility(View.VISIBLE);
            if ("-1".equalsIgnoreCase(map.get(position))) {
                holder.btn_check.setVisibility(View.VISIBLE);
            }
        } else if (b2 & !b3) {                            //备案
            holder.btn_detail.setVisibility(View.VISIBLE);
            holder.btn_del.setVisibility(View.VISIBLE);
            holder.btn_update.setVisibility(View.VISIBLE);
        }
        final SwipeMenuLayout finalConvertView = (SwipeMenuLayout) convertView;
//        if (ZPreferenceUtils.getPrefBoolean("审核", false)) {
//            //待审核
//            if ("-1".equalsIgnoreCase(status)) {
//
//            }
//        }

        //删除
        holder.btn_del.setOnClickListener(v ->delete(holder,position) );
        //详情
        holder.btn_detail.setOnClickListener(v -> detail(position,finalConvertView));
        //修改
        holder.btn_update.setOnClickListener(v ->update(position,finalConvertView));

        //审核
        holder.btn_check.setOnClickListener(v -> swipeCheck.onCheck(position,finalConvertView));
        return convertView;
    }

    private void detail(int position,SwipeMenuLayout finalConvertView) {
        finalConvertView.quickClose();
        String id = list.get(position).getId();
        Intent intent = new Intent(mContext, SeedDetailActivity.class);
        intent.putExtra("id", id);
        mContext.startActivity(intent);
    }

    private void update(int postion,SwipeMenuLayout finalConvertView) {
        finalConvertView.quickClose();
        Seed.ListBean seed =list.get(postion);
        Intent intent = new Intent(mContext, SeedUpdateAddActivity.class);
        intent.putExtra("type","update");
        intent.putExtra("id",seed.getId());
        intent.putExtra("vcvarietyname",seed.getVcvarietyname());
        intent.putExtra("vccategory",seed.getVccategory());
        intent.putExtra("vcproductionunit",seed.getVcproductionunit());
        intent.putExtra("vcbusinesslicense",null==seed.getVcbusinesslicense()?"":seed.getVcbusinesslicense());
        intent.putExtra("vcquarantineno",null==seed.getVcquarantineno()?"":seed.getVcquarantineno());
        intent.putExtra("btransgene",seed.getBtransgene());
        intent.putExtra("vcuniquecode",null==seed.getVcuniquecode()?"":seed.getVcuniquecode());
        intent.putExtra("vcappraisal",null==seed.getVcappraisal()?"":seed.getVcappraisal());
        mContext.startActivity(intent);
    }

    private class ViewHolder {
        SwipeMenuLayout swipe_content;
        TextView tv_vcvarietyname, tv_vccategory, tv_icheckstatus, tv_vcorgname;
        Button btn_detail, btn_del, btn_check, btn_update;
    }
    public interface onSwipeCheck{
        void onCheck(int postion,SwipeMenuLayout finalConvertView);
    }
    private void delete(final SeedAdapter.ViewHolder holder, final int pos) {
        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("确定删除此条记录吗?")
                .setPositiveButton("确定", (dialog, which) -> {
                    String id = list.get(pos).getId();
                    showLoadingDialog("删除中...");
                    OkhttpHelper.Get(Constants.SEED_RECODE_DEL + id, new OkhttpHelper.GetCallBack() {
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
