package cn.com.medicine.equipment.mvp.login.contract;

import cn.com.medicine.equipment.dto.WeatherDto;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import lib.com.hxin.base.BaseView;
import lib.com.hxin.http.RxManager;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public class LoginContract {

    public interface View extends BaseView{
        //数据加载成功
        void newData(WeatherDto data);
        //显示加载失败
        void showLoadFailMsg();
    }

    public interface Presenter {
        void onDestroy();
        void Load(String cityname);
        RxManager getRxManager();

    }

    public interface Model {
        void getWeather(String cityStr, final OnLoadDataListener listener);
    }
}