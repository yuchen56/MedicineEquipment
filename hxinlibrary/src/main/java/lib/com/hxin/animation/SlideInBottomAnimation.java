package lib.com.hxin.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import lib.com.hxin.base.BaseAnimation;


/**
 * Created by YongChen.Yu on 2017/7/23.
 */
public class SlideInBottomAnimation implements BaseAnimation {

    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0)
        };
    }
}
