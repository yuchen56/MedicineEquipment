package lib.com.hxin.base;

import android.content.Context;

import lib.com.hxin.http.RxManager;

/**
 * Created by YongChen.Yu on 2017/2/20.
 */

public abstract class BasePresenter<E, T> {
    public Context context;
    public E mModel;
    public T mView;
    public RxManager mRxManager = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
    }

    public RxManager getmRxManager() {
        return mRxManager;
    }

    public void onDestroy() {
        mRxManager.clear();

        mView = null;
    }


}
