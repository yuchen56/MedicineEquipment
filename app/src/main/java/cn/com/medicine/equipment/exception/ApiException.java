package cn.com.medicine.equipment.exception;

import cn.com.medicine.equipment.dto.HttpResult2;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public class ApiException extends RuntimeException {
    public ApiException(HttpResult2 httpResult) {
        this(getApiExceptionMessage(httpResult));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 对服务器接口传过来的错误信息进行统一处理
     * 免除在Activity的过多的错误判断
     */
    private static String getApiExceptionMessage(HttpResult2 httpResult){
        String message = "";
        switch (httpResult.getResultcode()) {
            case "ERROR":
                message = "ERROR:解析失败";
                break;
            case "ERROR2":
                message = "ERROR:服务器通讯故障";
                break;
            default:
                message = "ERROR:网络连接异常";

        }
        return message;
    }
}
