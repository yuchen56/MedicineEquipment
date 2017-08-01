package cn.com.medicine.equipment.mvp.palette;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.medicine.equipment.R;
import lib.com.hxin.base.BaseActivity;
import lib.com.hxin.utils.PaletteUtil;

/**
 * Created by YongChen.Yu on 2017/7/31.
 * 提取主题色
 */

public class PaletteActivity extends BaseActivity {

    @BindView(R.id.p_img1)
    ImageView img1;
    @BindView(R.id.p_img2)
    ImageView img2;
    @BindView(R.id.p_img3)
    ImageView img3;
    @BindView(R.id.p_img4)
    ImageView img4;
    @BindView(R.id.palette_body_ll)
    LinearLayout bodyLayout;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_palette);
        ButterKnife.bind(this);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {

    }

    @OnClick({R.id.p_img1, R.id.p_img2, R.id.p_img3, R.id.p_img4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.p_img1:
                changeColor(R.mipmap.p1);
                break;
            case R.id.p_img2:
                changeColor(R.mipmap.p2);
                break;
            case R.id.p_img3:
                changeColor(R.mipmap.p3);
                break;
            case R.id.p_img4:
                changeColor(R.mipmap.p4);
                break;
        }
    }

    /**
     * 改变背景颜色
     *
     * @param imgId
     */
    private void changeColor(int imgId) {

        PaletteUtil.getInstance().init(getResources(), imgId, new PaletteUtil.PatternCallBack() {
            @Override
            public void onCallBack(Drawable drawable, int titleColor) {
                bodyLayout.setBackground(drawable);
            }
        });

//        //1.获取Bitmap对象
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgId);
//        //2.获取颜色值
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(Palette palette) {
//                //1.活力颜色
//                Palette.Swatch a = palette.getVibrantSwatch();
//                //2.亮的活力颜色
//                Palette.Swatch b = palette.getLightVibrantSwatch();
//                //3.暗的活力颜色
//                Palette.Swatch c = palette.getDarkVibrantSwatch();
//                //4.柔色
//                Palette.Swatch d = palette.getMutedSwatch();
//                //5.亮的柔色
//                Palette.Swatch e = palette.getLightMutedSwatch();
//                //6.暗的柔色
//                Palette.Swatch f = palette.getDarkMutedSwatch();
//                f.getRgb(); //rgb颜色
//                f.getTitleTextColor();//文本颜色
//
//                //返回float[]，可以进行修改，后使用ColorUtils工具类进行转换
//                f.getHsl();
//                f.getBodyTextColor();//和文本颜色一样
//
//                bodyLayout.setBackgroundColor(a.getRgb());
//            }
//        });
    }

}
