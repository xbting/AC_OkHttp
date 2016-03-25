package com.xbting.ac.okhttp;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

/**
 * Created by xubt on 2016/2/17.
 */
public class ACPostJsonRequest extends ACHttpRequest {
//    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public ACPostJsonRequest(int id, String url, ACRequestParam reqData, ACHttpRequestListener listener) {
        super(id, url, reqData, listener);
        JSONObject jsonObject = new JSONObject(reqData.getFormatParams());
        RequestBody body = RequestBody.create( MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        request = new Request.Builder().tag(id).url(url).post(body).build();
    }
}
