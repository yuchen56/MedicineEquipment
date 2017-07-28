package lib.com.hxin.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Window;

import lib.com.hxin.application.BaseApplication;

/**
 * Created by YongChen.Yu on 2017/2/20.
 * 框架的基类Activity需要使用者的acitivity进行继承
 */

public abstract class BaseActivity extends FragmentActivity {
    protected Context mContext;
    private ConnectivityManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//设置窗口没有标题
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏显示
        mContext = getApplicationContext();
        initView();
//        ButterKnife.bind(this);//绑定到butterknife
        initdata();
        BaseApplication.getInstance().addActivity(this);
    }

    /**
     * 初始activity方法
     */
    private void initView() {
        loadViewLayout();
    }

    /**
     * 数据初始化
     */
    private void initdata(){
//        findViewById();
        setListener();
        processLogic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.getInstance().finishActivity(this);
    }

    /**
     * 页面初始化时，加载页面layout
     */
    protected abstract void loadViewLayout();

    /**
     * 页面初始化时，加载页面元素
     */
//    protected abstract void findViewById();

    /**
     * 页面初始化时，设置各种事件的监听器
     */
    protected abstract void setListener();

    /**
     * 页面初始化时，业务逻辑处理
     */
    protected abstract void processLogic();

    /**
     * 获取屏幕宽度(px)
     *
     * @param
     * @return
     */
    public int getMobileWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        return width;
    }

    /**
     * 获取屏幕高度(px)
     *
     * @param
     * @return
     */
    public int getMobileHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        return height;
    }

    public boolean checkNetworkState() {
        boolean flag = false;
        //得到网络连接信息
        manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }

    /**
     * 获取版本号
     * @return
     */
    public String getVersionName()
    {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
            String version = packInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "1.0";
    }
}
