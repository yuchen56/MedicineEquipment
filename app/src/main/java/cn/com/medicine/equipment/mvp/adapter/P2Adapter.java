package cn.com.medicine.equipment.mvp.adapter;

import java.util.List;

import cn.com.medicine.equipment.R;
import lib.com.hxin.base.BaseAdapter;
import lib.com.hxin.base.BaseViewHolder;
import lib.com.hxin.utils.StrUtil;

/**
 * Created by YongChen.Yu on 2017/7/25.
 */

public class P2Adapter extends BaseAdapter<String> {

    public P2Adapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.p2_video_title_tv, StrUtil.parseEmpty(item));

//        Glide.with(mContext)
//                .load(item.getImageUrl())
//                .crossFade()
//                .placeholder(R.mipmap.pic_not_exist)
//                .into((ImageView) helper.getView(R.id.p2_video_img_tv));



    }
}
