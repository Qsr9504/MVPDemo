package com.qsr.mvpdemo.mvp.View;

import android.app.Activity;
import android.os.Bundle;

import com.qsr.mvpdemo.mvp.Model.data.Action;
import com.qsr.mvpdemo.mvp.Presenter.IPresenter;

import butterknife.ButterKnife;

/**
 * Created by pillow on 16/5/18.
 */
public abstract class BaseActivity extends Activity implements IPresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        init();
    }

    abstract void init();

    abstract int getContentView();

    abstract void notify(Action action);

    @Override
    public void presenteCallBack(Action action){
        notify(action);
    }

}
