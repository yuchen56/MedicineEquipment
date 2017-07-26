package cn.com.medicine.equipment.mvp.photo;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.mvp.adapter.PhotoDetailAdapter;
import lib.com.hxin.base.BaseActivity;
import lib.com.hxin.views.photo.PhotoViewPager;

/**
 * Created by YongChen.Yu on 2017/7/26.
 * 用于浏览图片
 */

public class PhotoDetailActivity extends BaseActivity {


    @BindView(R.id.photo_pager_pv)
    PhotoViewPager photoPagerPv;
    @BindView(R.id.photo_point_ll)
    LinearLayout photoPointLl;

    private int selectedPosition = 0;
    private List<String> imagePaths = null;
    private PhotoDetailAdapter mAdapter = null;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);

//        selectedPosition = getIntent().getIntExtra("position", 0);
//        imagePaths = getIntent().getStringArrayListExtra("paths");

        imagePaths = new ArrayList<>();
        imagePaths.add("https://img6.bdstatic.com/img/image/smallpic/weijuchiluntu.jpg");
        imagePaths.add("https://img6.bdstatic.com/img/image/smallpic/yangmixiaotugengxin.jpg");
        imagePaths.add("https://img6.bdstatic.com/img/image/smallpic/xiaoqingxbanq.jpg");




        if (imagePaths == null) {
            return;
        } else {
            mAdapter = new PhotoDetailAdapter(mContext, imagePaths);

            photoPagerPv.setAdapter(mAdapter);
            photoPagerPv.setCurrentItem(selectedPosition);

            photoPagerPv.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(int arg0) {
                    selectedPosition = arg0;
                    setIndicator();
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {
                }

                @Override
                public void onPageScrollStateChanged(int arg0) {
                }
            });
            setIndicator();
        }
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {

    }


    private void setIndicator() {
        if (imagePaths.size() <= 1) {
            return;
        }
        // 循环取得小点图片
        photoPointLl.removeAllViews();
        for (int i = 0; i < imagePaths.size(); i++) {
            ImageView dot = new ImageView(PhotoDetailActivity.this);
            dot.setImageResource(R.drawable.dot);
            dot.setPadding(8, 0, 8, 0);
            photoPointLl.addView(dot);
            if (selectedPosition == i) {
                dot.setEnabled(false);// 设置为白色，即选中状态
            } else {
                dot.setEnabled(true);// 都设为灰色
            }
        }
    }

}
