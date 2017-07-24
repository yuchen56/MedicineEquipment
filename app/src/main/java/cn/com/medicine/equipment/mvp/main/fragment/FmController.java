package cn.com.medicine.equipment.mvp.main.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * Created by YongChen.Yu on 2017/7/24.
 * 控制主页底部Tab
 */

public class FmController {

    private int containerId;
    private FragmentManager fmger;
    private ArrayList<Fragment> fmList;

    private static FmController controller;

    /**
     * 实例化
     *
     * @param activity
     * @param containerId
     * @return
     */
    public static FmController getInstance(FragmentActivity activity, int containerId) {
        if (controller == null) {
            controller = new FmController(activity, containerId);
        }
        return controller;
    }

    public static void onDestory() {
        controller = null;
    }

    private FmController(FragmentActivity activity, int containerId) {
        this.containerId = containerId;
        fmger = activity.getSupportFragmentManager();
        initFragmentTab();
    }

    /**
     * fragment tab栏 初始化
     */
    private void initFragmentTab() {
        fmList = new ArrayList<>();
        fmList.add(new P1_Fragment());
        fmList.add(new P2_Fragment());
        fmList.add(new P3_Fragment());
        fmList.add(new P4_Fragment());

        FragmentTransaction ft = fmger.beginTransaction();
        for (Fragment fragment : fmList) {
            ft.add(containerId, fragment);
        }
//		ft.commit();
        ft.commitAllowingStateLoss();
    }

    /**
     * 指定需要显示的fragment
     * @param position
     */
    public void showFragment(int position) {
        hideFragments();
        Fragment fragment = fmList.get(position);
        FragmentTransaction ft = fmger.beginTransaction();
        ft.show(fragment);
//		ft.commit();
        ft.commitAllowingStateLoss();
    }

    /**
     * 隐藏Fragment
     */
    public void hideFragments() {
        FragmentTransaction ft = fmger.beginTransaction();
        for (Fragment fragment : fmList) {
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
//		ft.commit();
        ft.commitAllowingStateLoss();
    }

    /**
     * 根据position 获取fragment
     *
     * @param position
     * @return
     */
    public Fragment getFragment(int position) {
        return fmList.get(position);
    }
}
