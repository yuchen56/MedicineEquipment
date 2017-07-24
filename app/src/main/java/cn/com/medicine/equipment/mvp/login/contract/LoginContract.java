package cn.com.medicine.equipment.mvp.login.contract;

import cn.com.medicine.equipment.dto.UserDto;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import lib.com.hxin.base.BaseView;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public class LoginContract {

    public interface View extends BaseView{
        //数据加载成功
        void newData(UserDto data);
        //显示加载失败
        void showLoadFailMsg();
    }

    public interface Presenter {
        void onDestroy();
        void Load(UserDto dto);

    }

    public interface Model {
        void doLoginAct(UserDto dto, final OnLoadDataListener listener);
    }
}