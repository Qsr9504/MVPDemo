package com.qsr.mvpdemo.mvp.Presenter;


import com.qsr.mvpdemo.mvp.Model.Biz.LoginBiz;
import com.qsr.mvpdemo.mvp.Model.data.Action;

/**
 * Created by pillow on 16/5/18.
 */
public class LoginPresenter extends BasePresenter{

    private LoginBiz mLoginBiz;

    @Override
    public void init() {
        mLoginBiz = new LoginBiz();
        mLoginBiz.registerBizListener(this);
    }

    @Override
    public void requestAction(String event) {
        action = new Action(event);
        mLoginBiz.setAction(action);

        if(event.equals(LoginBiz.EVENT_LOGIN)){
            mLoginBiz.login();
        }

    }
}
