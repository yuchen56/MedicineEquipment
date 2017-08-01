package cn.com.medicine.equipment.mvp.login.presenter;

import cn.com.medicine.equipment.dto.WeatherDto;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import cn.com.medicine.equipment.mvp.login.contract.LoginContract;
import cn.com.medicine.equipment.mvp.login.model.LoginModelImpl;
import lib.com.hxin.base.BasePresenter;
import lib.com.hxin.http.RxManager;

/**
* Created by YongChen.Yu on 2017/07/20
*/

public class LoginPresenterImpl extends BasePresenter implements LoginContract.Presenter, OnLoadDataListener<WeatherDto> {

    private LoginContract.View view;
    private LoginContract.Model model;

    public RxManager getRxManager() {
        return rxManager;
    }

    public RxManager rxManager;

    public LoginPresenterImpl(LoginContract.View view){
        this.view = view;
        model = new LoginModelImpl();
        this.rxManager = mRxManager;
    }

    @Override
    public void onSuccess(WeatherDto data) {
        view.newData(data);
        view.hideProgress();

        rxManager.post("GET_WEATHER", data);
    }

    @Override
    public void onFailure(Throwable e) {
        view.hideProgress();
    }

    @Override
    public void Load(String cityname) {
        model.getWeather(cityname, this);
        view.showProgress();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}