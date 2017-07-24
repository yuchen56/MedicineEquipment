package cn.com.medicine.equipment.mvp.main.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import lib.com.hxin.base.BaseFragment;
import lib.com.hxin.views.SpringView;

/**
 * Created by YongChen.Yu on 2017/7/24.
 */

public class P3_Fragment extends BaseFragment implements SpringView.OnFreshListener{


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View mRootView = inflater.inflate(R.layout.fm_p3, container, false);
        ButterKnife.bind(this, mRootView);//绑定到butterknife
        return mRootView;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadmore() {

    }
}
