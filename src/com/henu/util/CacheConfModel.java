package com.henu.util;
/**
* @author ����
* @version ����ʱ�䣺2019��1��14�� ����9:58:46
* ��˵��
*/
public class CacheConfModel implements java.io.Serializable {

    private long beginTime;// ���濪ʼʱ��
    private boolean isForever = false;// �Ƿ�־�
    private int durableTime;// ����ʱ��

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