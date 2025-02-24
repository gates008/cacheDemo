package com.henu.util;
/**
* @author 作者
* @version 创建时间：2019年1月14日 上午9:58:46
* 类说明
*/
public class CacheConfModel implements java.io.Serializable {

    private long beginTime;// 缓存开始时间
    private boolean isForever = false;// 是否持久
    private int durableTime;// 持续时间

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public boolean isForever() {
        return isForever;
    }

    public void setForever(boolean isForever) {
        this.isForever = isForever;
    }

    public int getDurableTime() {
        return durableTime;
    }

    public void setDurableTime(int durableTime) {
        this.durableTime = durableTime;
    }

}