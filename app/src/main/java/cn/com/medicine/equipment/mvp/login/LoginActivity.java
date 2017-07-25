package cn.com.medicine.equipment.mvp.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.dto.WeatherDto;
import cn.com.medicine.equipment.mvp.login.contract.LoginContract;
import cn.com.medicine.equipment.mvp.login.presenter.LoginPresenterImpl;
import lib.com.hxin.base.BaseActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.login_city)
    EditText loginCity;
    @BindView(R.id.login_get)
    Button loginGet;
    @BindView(R.id.login_show_txt)
    TextView loginShowTxt;

    private LoginContract.Presenter presenter;

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
        loginShowTxt.setText(data.toString());
    }

    @Override
    public void showLoadFailMsg() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();//关闭view防止mvp内存泄露
    }
}

