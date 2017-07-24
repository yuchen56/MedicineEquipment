package cn.com.medicine.equipment.mvp.main.contract;

import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.lictener.OnLoadDataListener;
import lib.com.hxin.base.BaseView;

/**
 * Created by YongChen.Yu on 2017/7/24.
 */

public class P1Contract {

    public interface View extends BaseView{
        //加载新数据
        void newDatas(HomeDto data);
        //显示加载失败
        void showLoadFailMsg();
    }

    public interface Presenter {
        void onDestroy();
        void Load();
    }

    public interface Model {
        void getHomeInfo(final OnLoadDataListener listener);
    }


}