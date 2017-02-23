package com.qsr.mvpdemo.mvp.Model.Biz;


import android.os.Message;
import android.util.Log;
import android.widget.Toast;


import com.qsr.mvpdemo.mvp.Model.data.Action;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by pillow on 16/5/19.
 */
public abstract class BaseBiz {

    IBiz mListener;

    Action mAction;

    private final int HANDLER_CALLBACK = 0;

    private android.os.Handler myHandler = new android.os.Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mListener.BizCallBack(mAction);
                break;
            }
            super.handleMessage(msg);
        }
    };

    public abstract void setAction(Action action);

    public void registerBizListener(IBiz listener){
        mListener = listener;
    }
    public void bizCallBack(){
        myHandler.sendEmptyMessage(HANDLER_CALLBACK);
    }

}
