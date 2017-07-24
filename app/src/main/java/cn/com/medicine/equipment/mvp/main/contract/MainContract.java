package cn.com.medicine.equipment.mvp.main.contract;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public class MainContract {

    public interface View {//把Activity中的UI逻辑抽象成的View接口


    }

    public interface Presenter {//把业务逻辑抽象成Presenter接口
        void getHomePageDataFromServer();//处理从服务器端获取的数据
    }

    public interface Model {//用于获取数据、保存实例数据、与服务器交互

    }


}