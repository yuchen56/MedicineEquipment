package cn.com.medicine.equipment.api;

import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.dto.HttpResult;
import cn.com.medicine.equipment.dto.HttpResult2;
import cn.com.medicine.equipment.dto.WeatherDto;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public interface ApiService {

    //@FormUrlEncoded
    @GET("index")
    Observable<HttpResult2<WeatherDto>> getWeather(@Query("format") int format
            , @Query("cityname")String cityname
            , @Query("key")String citynakeyme);
    //@Field("userId") String userId, @Field("password") String password, @Field("macId") String macId

    //获取首页详情
    @GET("api/getHomeInfo")
    Observable<HttpResult<HomeDto>> getHomeInfo();

}
