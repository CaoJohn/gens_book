package com.zhibeiyou.util.constants;

import java.util.HashMap;

/**
 * Created by cheng on 2017/9/25.
 */
public class ResultMap extends HashMap<String, Object> {

    private static final long serialVersionUID = -5251276311912216510L;
    private final String msg = "msg";
    private final String success = "success";
    private final String data = "data";

    public ResultMap(){
        this.put(msg, "操作失败");
        this.put(success, false);
    }

    public boolean getSuccess(){
        return (Boolean) this.get(success);
    }

    public void setSuccess(boolean success){
        this.put(this.success, success);
    }

    public String getMsg(){
        return (String) this.get(msg);
    }

    public void setMsg(String msg){
        this.put(this.msg, msg);
    }

    public void msgFailed(String msg){
        this.put(this.msg, msg);
        this.put(this.success, false);
    }

    public void setData(Object data){
        this.put(this.data,data);
    }

}
