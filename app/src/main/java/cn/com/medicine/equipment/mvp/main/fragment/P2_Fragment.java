package cn.com.medicine.equipment.mvp.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.medicine.equipment.R;
import cn.com.medicine.equipment.mvp.adapter.P2Adapter;
import cn.com.medicine.equipment.mvp.main.contract.P2Contract;
import cn.com.medicine.equipment.mvp.main.presenter.P2PresenterImpl;
import cn.com.medicine.equipment.views.AcFunFooter;
import cn.com.medicine.equipment.views.AcFunHeader;
import lib.com.hxin.base.BaseAdapter;
import lib.com.hxin.base.BaseFragment;
import lib.com.hxin.views.SpringView;

/**
 * Created by YongChen.Yu on 2017/7/24.
 */

public class P2_Fragment extends BaseFragment implements P2Contract.View, SpringView.OnFreshListener {


    @BindView(R.id.iv_header_left)
    ImageView headerLeftImg;
    @BindView(R.id.tv_header_title)
    TextView headerTitleTv;
    @BindView(R.id.tv_header_rightTitle)
    TextView rightTitleTv;
    @BindView(R.id.iv_header_right1)
    ImageView headerRight1Img;
    @BindView(R.id.iv_header_right2)
    ImageView headerRight2Img;
    @BindView(R.id.fmp2_rv)
    RecyclerView recylerV;
    @BindView(R.id.fmp2_spring)
    SpringView spring;

    private P2Adapter adapter;
    private P2Contract.Presenter presenter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View mRootView = inflater.inflate(R.layout.fm_p2, container, false);
        ButterKnife.bind(this, mRootView);//绑定到butterknife

//        spring.setVisibility(View.INVISIBLE);
        spring.setListener(this);//下拉刷新，上拉加载
        spring.setGive(SpringView.Give.NONE);
        spring.setHeader(new AcFunHeader(getActivity(), R.drawable.acfun_header));
        spring.setFooter(new AcFunFooter(getActivity(), R.drawable.acfun_footer));

        recylerV.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recylerV.setHasFixedSize(true);
        adapter = new P2Adapter(R.layout.itm_p2, null);
        adapter.openLoadAnimation(BaseAdapter.SCALEIN);
        recylerV.setAdapter(adapter);

        presenter = new P2PresenterImpl(this);
        headerTitleTv.setText("视频");

        return mRootView;
    }

    @Override
    protected void initListener() {
        presenter.Load();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void newDatas(String data) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=10;i++){
            list.add(String.valueOf(i));
        }
        adapter.setNewData(list);
    }

    @Override
    public void showLoadFailMsg() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
