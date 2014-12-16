package com.bebetter.glespFrameWork;

import android.app.Activity;
import com.bebetter.glespFrameWork.dao.IBean;
import com.bebetter.glespFrameWork.dao.IRequest;
import com.bebetter.glespFrameWork.dao.IResponse;
import com.bebetter.glespFrameWork.dao.Response;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

/**
 * Created by songmengyu on 14-10-14.
 */
public abstract class GLESPBaseActivity extends Activity {

      public void sendRequest(final IRequest request){
            GLESPBaseApplication.getInstance().getHttpUtils().send(request.getMethod(),request.getUrl(),new RequestCallBack<String>() {

                  @Override
                  public void onStart() {
                        super.onStart();
                  }

                  @Override
                  public void onLoading(long total, long current, boolean isUploading) {
                        super.onLoading(total, current, isUploading);
                  }

                  @Override
                  public void onSuccess(ResponseInfo<String> stringResponseInfo) {
                        IBean bean = request.getParser().parse(stringResponseInfo.result);
                        IResponse response = new Response(request,bean);
                        handleResponse(response);
                  }

                  @Override
                  public void onFailure(HttpException e, String s) {

                  }
            });
      }

      public void downloadFile(IRequest request){

      }

      public void uploadFile(IRequest request){

      }

      public abstract void handleResponse(IResponse response);
}
