package com.xbting.ac.okhttp;

/**
 * Created by xubt on 2016/2/17.
 */
public interface ACDownFileListener {
    public void onError(int id, int errorCode, Object object);

    public void onResult(int id, String content, Object object);

    public void inProgress(float progress);

}
