package cn.com.medicine.equipment.mvp.main.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.mvp.main.contract.P1Contract;
import cn.com.medicine.equipment.mvp.main.presenter.P1PresenterImpl;
import lib.com.hxin.base.BaseFragment;
import lib.com.hxin.views.SpringView;

/**
 * Created by YongChen.Yu on 2017/7/24.
 */

public class P1_Fragment extends BaseFragment implements P1Contract.View, SpringView.OnFreshListener{

    private P1Contract.Presenter presenter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View mRootView = inflater.inflate(R.layout.fm_p1, container, false);
        ButterKnife.bind(this, mRootView);//绑定到butterknife
        return mRootView;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter = new P1PresenterImpl(this);
        presenter.Load();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void newDatas(HomeDto data) {

    }

    @Override
    public void showLoadFailMsg() {

    }
}
