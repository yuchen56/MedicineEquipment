package lib.com.hxin.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by YongChen.Yu on 2017/2/20.
 * okHttp的配置
 * 缓存已经添加  目前只支持GET请求的缓存  POST的我在找合适的处理方法
 * 也可根据自己的需要进行相关的修改
 */

public class OkHttp3Utils {
    private static OkHttpClient mOkHttpClient;
    /*
     * 是否输出log true-输出（默认-true）false-不输出
     * 开启日志后，会记录request和response的相关信息
     */
    private static boolean loggerState = true;
    private static HttpLoggingInterceptor logging;

    /**
     * 获取OkHttpClient对象
     */
    public static OkHttpClient getOkHttpClient() {

        if (null == mOkHttpClient) {
            //设置输出log
            logging = new HttpLoggingInterceptor();
            if(isLoggerState()){
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);//输出
            }else{
                logging.setLevel(HttpLoggingInterceptor.Level.NONE);//不输出
            }
            //同样okhttp3后也使用build设计模式
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .build();
        }

        return mOkHttpClient;
    }

    public static boolean isLoggerState() {
        return loggerState;
    }

    /**
     * 是否输出log
     * true-输出（默认-true）
     * false-不输出
     * @param loggerState
     */
    public void setLoggerState(boolean loggerState) {
        this.loggerState = loggerState;
    }
}
