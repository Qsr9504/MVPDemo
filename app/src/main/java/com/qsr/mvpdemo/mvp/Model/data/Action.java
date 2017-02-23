package com.qsr.mvpdemo.mvp.Model.data;

import java.util.List;

/**
 * Created by pillow on 16/5/18.
 */
public class Action<T> {
    /**请求事件*/
    private String event;
    /**请求返回的数据*/
    private List<T> dataList;
    /**描述*/
    private String describe;
    /**状态*/
    private int state;

    public Action(String event){
        this.event = event;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<T> getData() {
        return dataList;
    }

    public void setData(List<T> data) {
        this.dataList = data;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
