package cn.com.medicine.equipment.mvp.login.model;
import cn.com.medicine.equipment.dto.UserDto;
import cn.com.medicine.equipment.http.HttpData;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import cn.com.medicine.equipment.mvp.login.contract.LoginContract;
import rx.Observer;

/**
* Created by YongChen.Yu on 2017/07/20
*/

public class LoginModelImpl implements LoginContract.Model{

    @Override
    public void doLoginAct(UserDto dto, final OnLoadDataListener listener) {
        HttpData.getInstance().getUserInfo(false, dto, new Observer<UserDto>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
                System.out.println(e.toString());
            }

            @Override
            public void onNext(UserDto userDto) {
                listener.onSuccess(userDto);
            }
        });
    }
}