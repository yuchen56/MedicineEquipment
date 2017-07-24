package cn.com.medicine.equipment.mvp.welcome;

import android.content.Intent;
import android.os.Handler;

import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.mvp.main.MainActivity;
import lib.com.hxin.base.BaseActivity;

/**
 * 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);//绑定到butterknife
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
