package cn.com.medicine.equipment.mvp.main.contract;

import cn.com.medicine.equipment.lictener.OnLoadDataListener;

/**
 * Created by YongChen.Yu on 2017/7/27.
 */

public class P2Contract {

    public interface View {
        //加载新数据
        void newDatas(String data);
        //显示加载失败
        void showLoadFailMsg();
    }

    public interface Presenter {
        void onDestroy();
        void Load();
    }

    public interface Model {
        public void getInfo(final OnLoadDataListener listener);
    }


}