package cn.com.medicine.equipment.lictener;

/**
 * Created by YongChen.Yu on 2017/2/21.
 */

public interface OnLoadDataListener<T> {
    /**
     * 请求数据成功
     * @param data
     */
    void onSuccess(T data);

    /**
     * 请求失败
     * @param e
     */
    void onFailure(Throwable e);
}
