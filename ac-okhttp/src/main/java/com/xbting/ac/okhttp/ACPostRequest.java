package com.xbting.ac.okhttp;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.util.Map;

/**
 * Created by xubt on 2015/12/24.
 */
public class ACPostRequest extends ACHttpRequest {

    public ACPostRequest(int id, String url, ACRequestParam reqData, ACHttpRequestListener listener) {
        super(id, url, reqData, listener);
        FormEncodingBuilder builder = new FormEncodingBuilder();
        if (reqData == null) {
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{}");
            request = new Request.Builder().tag(id).url(url).post(body).build();
        } else {
            addParams(builder);
            request = new Request.Builder().tag(id).url(url).post(builder.build()).build();
        }

    }

    private void addParams(FormEncodingBuilder builder) {
        if (reqData == null) {
            return;
        }

        Map<String, String> params = reqData.getFormatParams();
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
    }
}
