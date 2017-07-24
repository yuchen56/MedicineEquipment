package lib.com.hxin.application;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongChen.Yu on 2017/2/20.
 * 自定义application 需要框架使用者进行继承
 * 用于初始化 各种数据、服务
 */
public class BaseApplication extends Application{
    /**
     * 应用实例
     */
    private static BaseApplication instance;

    //记录当前栈里所有的activity
    private List<Activity> activityAll = new ArrayList<>();
    //记录需要一次性关闭的页面
    private List<Activity> activityOnce = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 获得实例
     *
     * @return
     */
    public static BaseApplication getInstance() {
        return instance;
    }

    /**
     * 新建了一个activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activityAll.add(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            this.activityAll.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /*
    *给临时Activitys
    * 添加activity
    * */
    public void addTemActivity(Activity activity) {
        activityOnce.add(activity);
    }

    public void finishTemActivity(Activity activity) {
        if (activity != null) {
            this.activityOnce.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /*
    * 退出指定的Activity
    * */
    public void exitActivitys() {
        for (Activity activity : activityOnce) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activityAll) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }
}
