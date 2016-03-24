package com.xbting.ac.okhttp;

import com.squareup.okhttp.Request;

/**
 * Created by xubt on 2015/12/24.
 */
public class ACGetRequest  extends ACHttpRequest {
    public ACGetRequest(int id, String url, ACHttpRequestListener listener) {
        super(id, url, null, listener);
         request = new Request.Builder().tag(id)
                .url(url).build();

    }


}
