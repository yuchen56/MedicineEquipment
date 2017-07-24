package cn.com.medicine.equipment.mvp.main.presenter;

import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import cn.com.medicine.equipment.mvp.main.contract.P1Contract;
import cn.com.medicine.equipment.mvp.main.model.P1ModelImpl;

/**
 * Created by YongChen.Yu on 2017/07/24
 */

public class P1PresenterImpl implements P1Contract.Presenter, OnLoadDataListener<HomeDto> {

    private P1Contract.View view;
    private P1Contract.Model model;

    public P1PresenterImpl(P1Contract.View view) {
        this.view = view;
        model = new P1ModelImpl();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void Load() {
        model.getHomeInfo(this);
        view.showProgress();
    }

    @Override
    public void onSuccess(HomeDto data) {
        view.newDatas(data);
        view.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        view.hideProgress();
    }
}