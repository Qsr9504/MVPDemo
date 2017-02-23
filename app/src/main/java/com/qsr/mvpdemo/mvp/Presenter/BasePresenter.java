package com.qsr.mvpdemo.mvp.Presenter;


import com.qsr.mvpdemo.mvp.Model.Biz.IBiz;
import com.qsr.mvpdemo.mvp.Model.data.Action;

/**
 * Created by pillow on 16/5/18.
 */
public abstract class BasePresenter implements IBiz {

    IPresenter mListener;
    Action action;

    protected BasePresenter(){
        init();
    }

    public void registerPresenterListener(IPresenter ipresenter){
        mListener = ipresenter;
    }

    public abstract void requestAction(String event);

    @Override
    public void BizCallBack(Action action) {
        mListener.presenteCallBack(action);
    }

    public abstract void init();



}
