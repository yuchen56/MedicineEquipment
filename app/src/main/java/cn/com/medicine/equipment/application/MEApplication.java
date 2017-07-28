package cn.com.medicine.equipment.application;

import lib.com.hxin.application.BaseApplication;
import lib.com.hxin.utils.FileUtil;

/**
 * Created by YongChen.Yu on 2017/7/18.
 */

public class MEApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        FileUtil.setDirectoryName("ME_FILE_CACHE");//设置文件的缓存地址
    }
}
