package com.xbting.ac.okhttp;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Request;

import java.util.Map;

/**
 * Created by xubt on 2015/12/24.
 */
public class ACHttpRequest {
    /**
     * 请求唯一id
     */
    public int id;
    /**
     * Url地址
     */
    public String url;
    /**
     * 请求数据
     */
    public ACRequestParam reqData;

    public Map<String, String> headers;

    public Request request;
    public Call call;

    /**
     * 请求监听器
     */
    public ACHttpRequestListener listener;

    public ACHttpRequest(int id, String url, ACRequestParam reqData, ACHttpRequestListener listener) {
        this.listener = listener;
        this.id = id;
        this.url = url;
        this.reqData = reqData;
    }

    public static final class Error {
        /**
         * 网络连接超时标识
         */
        public final static int CONNECTION_TIME_OUT = -1;
        /**
         * 网络连接失败标识
         */
        public static final int CONNECTION_FAIL = -2;
    }
}
