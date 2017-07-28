package cn.com.medicine.equipment.mvp.main.presenter;

import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import cn.com.medicine.equipment.mvp.main.contract.P2Contract;
import cn.com.medicine.equipment.mvp.main.model.P2ModelImpl;

/**
* Created by YongChen.Yu on 2017/07/27
*/

public class P2PresenterImpl implements P2Contract.Presenter, OnLoadDataListener<String> {

    private P2Contract.Model model;
    private P2Contract.View view;

    public P2PresenterImpl(P2Contract.View view){
        this.view = view;
        model = new P2ModelImpl();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void Load() {
        model.getInfo(this);
    }

    @Override
    public void onSuccess(String data) {
        view.newDatas(data);
    }

    @Override
    public void onFailure(Throwable e) {

    }
}