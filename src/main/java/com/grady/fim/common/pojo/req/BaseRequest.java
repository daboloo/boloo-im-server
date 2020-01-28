package com.grady.fim.common.pojo.req;

public class BaseRequest {
    /**
     * 当前请求的时间戳
     */
    private int timeStamp;



    public BaseRequest() {
        this.setTimeStamp((int)(System.currentTimeMillis() / 1000));
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
