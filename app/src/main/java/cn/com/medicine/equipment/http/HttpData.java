package cn.com.medicine.equipment.http;

import java.io.File;

import cn.com.medicine.equipment.api.ApiService;
import cn.com.medicine.equipment.cache.CacheProviders;
import cn.com.medicine.equipment.common.Contants;
import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.dto.HttpResult;
import cn.com.medicine.equipment.dto.HttpResult2;
import cn.com.medicine.equipment.dto.WeatherDto;
import cn.com.medicine.equipment.exception.ApiException;
import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import io.rx_cache.internal.RxCache;
import lib.com.hxin.http.RetrofitUtils;
import lib.com.hxin.utils.FileUtil;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public class HttpData extends RetrofitUtils {
    private static File cacheDirectory = FileUtil.getcacheDirectory();//获取缓存地址
    private static final CacheProviders providers = new RxCache.Builder()
            .persistence(cacheDirectory)
            .using(CacheProviders.class);

    protected static final ApiService service = getRetrofit(Contants.API_SERVER).create(ApiService.class);

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpData INSTANCE = new HttpData();
    }

    //获取单例
    public static HttpData getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     *  banner
     *  isload 是否需要更新缓存
     *  true 删除缓存重新加载；
     *  fasle 优先使用缓存
     */
    public void getWeather(boolean isload,String city, Observer<WeatherDto> observer) {

        Observable observable = service.getWeather(2, "大连", "14a0b68aeef74fc6cac297bfd19a4bbb").map(new HttpResultFunc2<WeatherDto>());//从服务器端获取数据
        Observable observableCache = providers.getWeather(observable, new DynamicKey(city),//对数据进行缓存。
                new EvictDynamicKey(isload)).map(new HttpResultFuncCcche<WeatherDto>());
        setSubscribe(observableCache, observer);
//        setSubscribe(observable, observer);
    }

    public void getHomeInfo(boolean isload,Observer<HomeDto> observer){
        Observable observable=service.getHomeInfo().map(new HttpResultFunc<HomeDto>());
        Observable observableCache=providers.getHomeInfo(observable,new DynamicKey("首页配置"),new EvictDynamicKey(isload)).map(new HttpResultFuncCcche<HomeDto>());
        setSubscribe(observableCache,observer);
    }


    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }
    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private  class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (!httpResult.getResultCd().equals("00") ) {
                throw new ApiException(httpResult);
            }
            return httpResult.getData();
        }
    }

    private  class HttpResultFunc2<T> implements Func1<HttpResult2<T>, T> {

        @Override
        public T call(HttpResult2<T> httpResult) {
            if (!httpResult.getResultcode().equals("200") ) {
//                throw new ApiException(httpResult);
                System.out.println("httpResult" + httpResult);
            }
            return httpResult.getResult();
        }
    }
    /**
     * 用来统一处理RxCacha的结果
     */
    private  class HttpResultFuncCcche<T> implements Func1<Reply<T>, T> {

        @Override
        public T call(Reply<T> httpResult) {
            return httpResult.getData();
        }
    }
}
