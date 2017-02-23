package com.qsr.mvpdemo.mvp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.qsr.mvpdemo.R;
import com.qsr.mvpdemo.mvp.Model.Biz.LoginBiz;
import com.qsr.mvpdemo.mvp.Model.data.Action;
import com.qsr.mvpdemo.mvp.Model.data.User;
import com.qsr.mvpdemo.mvp.Presenter.LoginPresenter;

import java.util.List;

import butterknife.Bind;

public class LoginActivity extends BaseActivity {

	private LoginPresenter login;

	@Bind(R.id.tv_account)
	TextView mTvAccount;
	@Bind(R.id.tv_name)
	TextView mTvName;
	@Bind(R.id.tv_password)
	TextView mTvPassword;
	@Bind(R.id.tv_state)
	TextView mTvState;

	public LoginActivity() {
	}


	@Override
	void init() {
		login = new LoginPresenter();
		login.registerPresenterListener(this);
		login.requestAction(LoginBiz.EVENT_LOGIN);
	}

	@Override
	int getContentView() {
		return R.layout.activity_login;
	}

	@Override
	void notify(Action action) {
		String event = action.getEvent();
		Log.e("LoginActivity", event);
		if(event.equals(LoginBiz.EVENT_LOGIN)){
			List<User> userList = action.getData();
			StringBuilder sbAccount = new StringBuilder();
			StringBuilder sbName = new StringBuilder();
			StringBuilder sbPassword = new StringBuilder();

			for (int i = 0; i < userList.size(); i++) {
				Log.e("LoginActivity", "account = " + userList.get(i).getAccount() + "," + "name = " + userList.get(i).getName() + ",password = " + userList.get(i).getPassword()+",state = " + action.getState());
				sbAccount.append(userList.get(i).getAccount()).append(",");
				sbName.append(userList.get(i).getName()).append(",");
				sbPassword.append(userList.get(i).getPassword()).append(",");
			}
			mTvAccount.setText(sbAccount.toString());
			mTvName.setText(sbName.toString());
			mTvPassword.setText(sbPassword.toString());
			mTvState.setText((action.getState() == LoginBiz.STATE_LOGIN_SUCCESS)?"成功":"失败");
		}
	}
}
