package agricultural.nxt.agriculturalsupervision.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.Announce;

/**
 * Created by huqiang on 2016/12/7 16:21.
 */

public class ResultAdapter extends BaseQuickAdapter<Announce.ListBean, BaseViewHolder> {


    public ResultAdapter(List<Announce.ListBean> data) {
        super(R.layout.item_announce, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Announce.ListBean announce) {
        viewHolder.setText(R.id.vctitle,announce.getVctitle())
                .setText(R.id.dtcloseddate, announce.getDtcloseddate())
                .setText(R.id.ireadFlag, announce.getReadFlag())
                .setText(R.id.createDate,announce.getCreateDate());
        if ("0".equals(announce.getIlevel())){
            viewHolder.setText(R.id.ilevel,"一般");
        }else if("1".equals(announce.getIlevel())){
            viewHolder.setText(R.id.ilevel,"重要");
        }else if ("2".equals(announce.getIlevel())){
            viewHolder.setText(R.id.ilevel,"紧急重要");
        }
        if ("0".equals(announce.getIactiveflag())){
            viewHolder.setText(R.id.Iactiveflag,"无效");
        }else if ("1".equals(announce.getIactiveflag())){
            viewHolder.setText(R.id.Iactiveflag,"有效");
        }

    }
}
