package cn.com.medicine.equipment.mvp.login;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.dto.WeatherDto;
import cn.com.medicine.equipment.mvp.adapter.WeatherAdapter;
import cn.com.medicine.equipment.mvp.login.contract.LoginContract;
import cn.com.medicine.equipment.mvp.login.presenter.LoginPresenterImpl;
import cn.com.medicine.equipment.views.AcFunFooter;
import cn.com.medicine.equipment.views.AcFunHeader;
import lib.com.hxin.base.BaseActivity;
import lib.com.hxin.base.BaseAdapter;
import lib.com.hxin.views.SpringView;

/**
 * 用于测试矿建
 */
public class LoginActivity extends BaseActivity implements LoginContract.View, SpringView.OnFreshListener {

    @BindView(R.id.login_city)
    EditText loginCity;
    @BindView(R.id.login_get)
    Button loginGet;
    @BindView(R.id.login_rv)
    RecyclerView loginRv;
    @BindView(R.id.login_spring)
    SpringView loginSpring;

    private LoginContract.Presenter presenter;
    private WeatherAdapter adapter;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        loginSpring.setVisibility(View.INVISIBLE);
        loginSpring.setListener(this);//下拉刷新，上拉加载
        loginSpring.setGive(SpringView.Give.NONE);
        loginSpring.setHeader(new AcFunHeader(mContext, R.drawable.acfun_header));
        loginSpring.setFooter(new AcFunFooter(mContext, R.drawable.acfun_footer));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LoginActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        loginRv.setLayoutManager(linearLayoutManager);

        loginRv.setHasFixedSize(true);
        adapter = new WeatherAdapter(R.layout.itm_weather, null);
        adapter.openLoadAnimation(BaseAdapter.SCALEIN);
        loginRv.setAdapter(adapter);


    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {
        presenter = new LoginPresenterImpl(this);//获取presenter对象
    }

    private String cityStr;

    private void attemptLogin() {//出发登录操作
        cityStr = loginCity.getText().toString();
        presenter.Load(cityStr);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void newData(WeatherDto data) {
        //请求成功后被回调
        adapter.setNewData(data.getFuture());
        loginSpring.setVisibility(View.VISIBLE);

    }

    @Override
    public void showLoadFailMsg() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();//关闭view防止mvp内存泄露
    }

    @Override
    public void onRefresh() {//刷新页面
        presenter.Load("大连");
    }

    @Override
    public void onLoadmore() {//加载更多

    }
}

