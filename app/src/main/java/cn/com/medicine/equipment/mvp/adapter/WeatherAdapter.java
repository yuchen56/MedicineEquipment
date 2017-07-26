package cn.com.medicine.equipment.mvp.adapter;

import java.util.List;

import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.dto.WeatherDto;
import lib.com.hxin.base.BaseAdapter;
import lib.com.hxin.base.BaseViewHolder;
import lib.com.hxin.utils.StrUtil;

/**
 * Created by YongChen.Yu on 2017/7/25.
 */

public class WeatherAdapter extends BaseAdapter<WeatherDto.FutureBean> {

    public WeatherAdapter(int layoutResId, List<WeatherDto.FutureBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherDto.FutureBean item) {
        helper.setText(R.id.wr_temperature_tv, StrUtil.parseEmpty(item.getTemperature()));
        helper.setText(R.id.wr_weather_tv, StrUtil.parseEmpty(item.getWeather()));
        helper.setText(R.id.wr_date_tv, StrUtil.parseEmpty(item.getDate()));
        helper.setText(R.id.wr_wind_tv, StrUtil.parseEmpty(item.getWind()));
    }
}
