package cn.com.medicine.equipment.dto;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public class HttpResult<T> {
    public String resultCd;
    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultCd() {
        return resultCd;
    }

    public void setResultCd(String resultCd) {
        this.resultCd = resultCd;
    }
}
