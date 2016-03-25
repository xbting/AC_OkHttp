package com.xbting.ac.okhttp;

import com.squareup.okhttp.Request;

/**
 * Created by xubt on 2016/2/17.
 */
public class ACGetFileRequest extends ACHttpRequest {
    /**
     * 目标文件存储的文件夹路径
     */
    public String destFileDir;
    /**
     * 目标文件存储的文件名
     */
    private String destFileName;

    public ACGetFileRequest(int id, String url, ACRequestParam reqData, String destFileDir) {
        super(id, url, reqData, null);
        this.destFileDir = destFileDir;
        request = new Request.Builder().tag(id)
                .url(url).build();
    }


}
