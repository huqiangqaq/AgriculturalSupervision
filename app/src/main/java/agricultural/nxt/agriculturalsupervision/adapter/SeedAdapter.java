package agricultural.nxt.agriculturalsupervision.adapter;

import android.app.ProgressDialog;
import android.content.Context;
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

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.Seed;

/**
 * Created by huqiang on 2016/12/29 14:04.
 */

public class SeedAdapter extends BaseAdapter {

    private Context mContext;
    private List<Seed.ListBean> list = new ArrayList<>();
    protected ProgressDialog loadingDialog;
    private SeedAdapter.ViewHolder holder;
    public SeedAdapter(Context mContext, List<Seed.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
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
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.seed_item,parent,false);
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
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Seed.ListBean seed = list.get(position);
        holder.tv_vcvarietyname.setText(seed.getVcvarietyname());
        holder.tv_vccategory.setText(seed.getVccategory());
        holder.tv_icheckstatus.setText(seed.getIcheckstatus());
        holder.tv_vcorgname.setText(seed.getOwner().getVcorgname());

        String status = list.get(position).getIcheckstatus();
        boolean b1 =ZPreferenceUtils.getPrefBoolean("查看",false);
        boolean b2 = ZPreferenceUtils.getPrefBoolean("备案",false);
        boolean b3 = ZPreferenceUtils.getPrefBoolean("审核",false);

        if (b1&b2&b3){                                    //全部权限
            holder.btn_detail.setVisibility(View.VISIBLE);
            holder.btn_del.setVisibility(View.VISIBLE);
            holder.btn_update.setVisibility(View.VISIBLE);
            if ("-1".equalsIgnoreCase(status)){
                holder.btn_check.setVisibility(View.VISIBLE);
            }
        }else if (b1&!b2&!b3){                            //只有查看权限
           holder.btn_detail.setVisibility(View.VISIBLE);
        }else if (b1&b3){                             //查看，审核
            holder.btn_detail.setVisibility(View.VISIBLE);
            if ("-1".equalsIgnoreCase(status)){
                holder.btn_check.setVisibility(View.VISIBLE);
            }
        }else if (b2&!b3){                            //备案
            holder.btn_detail.setVisibility(View.VISIBLE);
            holder.btn_del.setVisibility(View.VISIBLE);
            holder.btn_update.setVisibility(View.VISIBLE);
        }

        if (ZPreferenceUtils.getPrefBoolean("审核",false)){
            //待审核
            if ("-1".equalsIgnoreCase(status)){

            }
        }


        return convertView;
    }

    private class ViewHolder{
        SwipeMenuLayout swipe_content;
        TextView tv_vcvarietyname,tv_vccategory,tv_icheckstatus,tv_vcorgname;
        Button btn_detail,btn_del,btn_check,btn_update;

    }
}
