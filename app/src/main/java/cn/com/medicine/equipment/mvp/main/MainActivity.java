package cn.com.medicine.equipment.mvp.main;

import android.support.annotation.IdRes;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.mvp.main.fragment.FmController;
import lib.com.hxin.base.BaseActivity;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.main_radio)
    RadioGroup mainRadio;
    private FmController controller;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//绑定到butterknife
        controller = FmController.getInstance(this, R.id.main_board_fm);
        controller.showFragment(0);//显示第一个fragment
    }

    @Override
    protected void setListener() {
        mainRadio.setOnCheckedChangeListener(this);
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        FmController.onDestory();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.main_p1_rb:
                controller.showFragment(0);
                break;
            case R.id.main_p2_rb:
                controller.showFragment(1);
                break;
//            case R.id.main_p3_rb:
//                controller.showFragment(2);
//                break;
//            case R.id.main_p4_rb:
//                controller.showFragment(3);
//                break;
        }
    }
}
