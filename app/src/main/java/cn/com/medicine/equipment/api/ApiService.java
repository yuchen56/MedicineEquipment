package cn.com.medicine.equipment.api;

import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.dto.HttpResult;
import cn.com.medicine.equipment.dto.UserDto;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by YongChen.Yu on 2017/7/20.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("login.json")
    Observable<HttpResult<UserDto>> getUserInfo(@Field("userId") String userId, @Field("password") String password, @Field("macId") String macId);


    //获取首页详情
    @GET("api/getHomeInfo")
    Observable<HttpResult<HomeDto>> getHomeInfo();

}
