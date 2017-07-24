package cn.com.medicine.equipment.mvp.main.model;

import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.http.HttpData;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import cn.com.medicine.equipment.mvp.main.contract.P1Contract;
import rx.Observer;

/**
* Created by YongChen.Yu on 2017/07/24
*/

public class P1ModelImpl implements P1Contract.Model{

    @Override
    public void getHomeInfo(final OnLoadDataListener listener) {

        HttpData.getInstance().getHomeInfo(false,new Observer<HomeDto>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
            }

            @Override
            public void onNext(HomeDto homeDto) {
                listener.onSuccess(homeDto);
            }
        });
    }
}