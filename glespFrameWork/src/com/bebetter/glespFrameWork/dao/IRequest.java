package com.bebetter.glespFrameWork.dao;

import com.lidroid.xutils.http.client.HttpRequest;

/**
 * Created by songmengyu on 14-10-14.
 */
public interface IRequest {

      public long getID();

      public int getCategory();

      public HttpRequest.HttpMethod getMethod();

      public String getUrl();

      public IParser getParser();
}
