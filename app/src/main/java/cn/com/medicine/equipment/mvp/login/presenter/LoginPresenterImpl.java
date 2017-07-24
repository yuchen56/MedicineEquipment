package cn.com.medicine.equipment.mvp.login.presenter;

import cn.com.medicine.equipment.dto.UserDto;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import cn.com.medicine.equipment.mvp.login.contract.LoginContract;
import cn.com.medicine.equipment.mvp.login.model.LoginModelImpl;
import lib.com.hxin.base.BasePresenter;

/**
* Created by YongChen.Yu on 2017/07/20
*/

public class LoginPresenterImpl extends BasePresenter implements LoginContract.Presenter, OnLoadDataListener<UserDto> {

    private LoginContract.View view;
    private LoginContract.Model model;

    public LoginPresenterImpl(LoginContract.View view){
        this.view = view;
        model = new LoginModelImpl();
    }

    @Override
    public void onSuccess(UserDto data) {
        view.newData(data);
        view.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        view.hideProgress();;
    }

    @Override
    public void Load(UserDto dto) {
        model.doLoginAct(dto, this);
        view.showProgress();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}