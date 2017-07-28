package cn.com.medicine.equipment.mvp.main.model;

import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import cn.com.medicine.equipment.mvp.main.contract.P2Contract;

/**
 * Created by YongChen.Yu on 2017/07/27
 */

public class P2ModelImpl implements P2Contract.Model {

    @Override
    public void getInfo(final OnLoadDataListener listener) {
        listener.onSuccess("000000");

//        HttpData.getInstance().getHomeInfo(false,new Observer<HomeDto>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                listener.onFailure(e);
//            }
//
//            @Override
//            public void onNext(HomeDto homeDto) {
//                listener.onSuccess(homeDto);
//            }
//        });
    }
}