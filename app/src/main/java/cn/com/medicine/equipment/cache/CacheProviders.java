package cn.com.medicine.equipment.cache;

import java.util.concurrent.TimeUnit;

import cn.com.medicine.equipment.dto.HomeDto;
import cn.com.medicine.equipment.dto.UserDto;
import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by YongChen.Yu on 2017/7/20.
 * * 缓存API接口
 * @LifeCache设置缓存过期时间.
 * 如果没有设置@LifeCache ,
 * 数据将被永久缓存理除非你使用了 EvictProvider,
 * EvictDynamicKey or EvictDynamicKeyGroup .
 * EvictProvider可以明确地清理所有缓存数据.
 * EvictDynamicKey可以明确地清理指定的数据 DynamicKey.
 * EvictDynamicKeyGroup 允许明确地清理一组特定的数据. DynamicKeyGroup.
 * DynamicKey驱逐与一个特定的键使用EvictDynamicKey相关的数据。比如分页，排序或筛选要求
 * DynamicKeyGroup。驱逐一组与key关联的数据，使用EvictDynamicKeyGroup。比如分页，排序或筛选要求
 */

public interface CacheProviders {
    String HEADER_API_VERSION = "Accept: application/txt";

    @Headers({HEADER_API_VERSION})
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)//缓存七天
    Observable<Reply<UserDto>> getUserInfo(Observable<UserDto> oRepos, DynamicKey userName, EvictDynamicKey evictDynamicKey);


    //获取首页配置数据 banner 最热 最新  缓存时间7天
    @LifeCache(duration = 7, timeUnit = TimeUnit.DAYS)
    Observable<Reply<HomeDto>> getHomeInfo(Observable<HomeDto> oRepos, DynamicKey userName, EvictDynamicKey evictDynamicKey);


}
