package com.qsr.mvpdemo.mvp.Model.Biz;


import com.qsr.mvpdemo.mvp.Model.data.Action;
import com.qsr.mvpdemo.mvp.Model.data.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pillow on 16/5/18.
 */
public class LoginBiz extends BaseBiz{

    public static final String EVENT_LOGIN = "LoginBiz.event_login";
    public static final int STATE_LOGIN_SUCCESS = 0;

    public void login(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User user = new User();
                user.setAccount("aaaaa");
                user.setName("啊啊啊");
                user.setPassword("123456");

                List<User> userList = new ArrayList<User>();
                userList.add(user);

                mAction.setData(userList);
                mAction.setState(STATE_LOGIN_SUCCESS);
                bizCallBack();
            }
        }).start();
    }


    @Override
    public void setAction(Action action) {
        mAction = action;
    }
}
