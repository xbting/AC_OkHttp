package com.xbting.ac.okhttp;

import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xubt on 2015/12/24.
 */
public class ACHttpEngine {

    public static final long DEFAULT_MILLISECONDS = 10000;
    private static ACHttpEngine instance;
    private OkHttpClient okHttpClient;
    private Handler mHandler;


    public static ACHttpEngine getInstance() {
        if (instance == null) {
            synchronized (ACHttpEngine.class) {
                if (instance == null) {
                    instance = new ACHttpEngine();
                }
            }
        }
        return instance;
    }

    public ACHttpEngine() {
        okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(ACHttpConfig.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);//超时时间30秒
        okHttpClient.setReadTimeout(ACHttpConfig.SO_TIMEOUT, TimeUnit.MILLISECONDS);

        mHandler = new Handler(Looper.getMainLooper());
    }

    public void request(final ACHttpRequest mACHttpRequest) {
        okHttpClient.newCall(mACHttpRequest.request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, final IOException e) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mACHttpRequest.listener != null)
                            mACHttpRequest.listener.onError(mACHttpRequest.id, 0, null);
                    }
                });
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String str = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (mACHttpRequest.listener != null)
                                mACHttpRequest.listener.onResult(mACHttpRequest.id, str, null);
                        }
                    });

                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (mACHttpRequest.listener != null)
                                mACHttpRequest.listener.onError(mACHttpRequest.id, response.code(), response.message());
                        }
                    });
                }
            }
        });
        okHttpClient.newCall(mACHttpRequest.request);

    }

    public void removeRequest(ACHttpRequest request) {
        okHttpClient.cancel(request.id);

    }


}
