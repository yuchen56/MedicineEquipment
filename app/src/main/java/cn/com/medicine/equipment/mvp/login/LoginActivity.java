package cn.com.medicine.equipment.mvp.login;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.dto.UserDto;
import cn.com.medicine.equipment.mvp.login.contract.LoginContract;
import cn.com.medicine.equipment.mvp.login.presenter.LoginPresenterImpl;
import lib.com.hxin.base.BaseActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View{

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;

    private LoginContract.Presenter presenter;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        emailSignInButton.setOnClickListener(new View.OnClickListener() {
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

    private String emailStr;
    private String passwordStr;

    private void attemptLogin() {//出发登录操作
        emailStr = email.getText().toString();
        passwordStr = password.getText().toString();
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();

        UserDto dto = new UserDto();
        dto.setUserId(emailStr);
        dto.setPassword(passwordStr);
        dto.setMacId(info.getMacAddress());
        presenter.Load(dto);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void newData(UserDto data) {
        //请求成功后被回调
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

