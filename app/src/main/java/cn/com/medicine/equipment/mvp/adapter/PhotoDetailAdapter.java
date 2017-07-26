package cn.com.medicine.equipment.mvp.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.com.medicine.equipment.R;
import lib.com.hxin.utils.StrUtil;
import lib.com.hxin.views.photo.PhotoView;
import lib.com.hxin.views.photo.PhotoViewAttacher;

/**
 * Created by YongChen.Yu on 2017/7/26.
 */

public class PhotoDetailAdapter extends PagerAdapter {

    private List<String> imgPaths = null;
    private Context mContext = null;
    private LayoutInflater mInflater = null;


    public PhotoDetailAdapter(Context mContext, List<String> imgPaths) {
        this.mContext = mContext;
        this.imgPaths = imgPaths;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return imgPaths == null ? 0 : imgPaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
//        super.finishUpdate(container);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
//        super.restoreState(state, loader);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(ViewGroup container) {
//        super.startUpdate(container);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View photoDetailItem = mInflater.inflate(R.layout.itm_photo,container, false);

        PhotoView imgDetail = (PhotoView) photoDetailItem.findViewById(R.id.photo_detail_pv);

        imgDetail.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                ((android.app.Activity) mContext).finish();
            }
        });
        ImageView imgError = (ImageView) photoDetailItem.findViewById(R.id.photo_error);


        Glide.with(mContext)
                .load(StrUtil.parseEmpty(imgPaths.get(position)))//设置图片url
                .placeholder(R.mipmap.pic_not_exist)//占位图
                .error(R.mipmap.pic_not_exist)//错误图
                .into(imgDetail);
        ((ViewPager)container).addView(photoDetailItem, 0);

        return photoDetailItem;
    }
}
