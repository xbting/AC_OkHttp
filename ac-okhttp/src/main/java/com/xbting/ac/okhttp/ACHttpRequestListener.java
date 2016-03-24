package com.xbting.ac.okhttp;

/**
 * Created by xubt on 2015/12/24.
 */
public interface ACHttpRequestListener {

    public void onError(int id, int errorCode, Object object);

    public void onResult(int id, String content, Object object);
}
