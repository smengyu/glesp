package com.bebetter.glespFrameWork.dao;

import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * Created by SamuraiSong on 21/12/14.
 */
public abstract class BaseRequest implements IRequest {

    public static final int LOGIN = 1000;
    @Override
    public long getID() {
        return 0;
    }
}
