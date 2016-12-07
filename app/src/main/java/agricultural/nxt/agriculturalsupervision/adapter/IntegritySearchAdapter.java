package agricultural.nxt.agriculturalsupervision.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import agricultural.nxt.agriculturalsupervision.R;
import agricultural.nxt.agriculturalsupervision.entity.IntegritySearch;

/**
 * Created by huqiang on 2016/12/7 17:26.
 */

public class IntegritySearchAdapter extends BaseQuickAdapter<IntegritySearch,BaseViewHolder> {
    public IntegritySearchAdapter(List<IntegritySearch> data) {
        super(R.layout.item_integrity_search,data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, IntegritySearch integritySearch) {

    }
}
