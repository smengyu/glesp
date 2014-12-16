package com.bebetter.glespFrameWork.dao;

/**
 * Created by songmengyu on 14-10-14.
 */
public class Response implements IResponse {

      private IRequest request = null;
      private IBean bean = null;

      public Response(IRequest request, IBean bean) {
            this.request = request;
            this.bean = bean;
      }

      @Override
      public IRequest getRequest() {
            return request;
      }

      @Override
      public IBean getData() {
            return bean;
      }
}
