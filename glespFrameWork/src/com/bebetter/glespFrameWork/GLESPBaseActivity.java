package com.bebetter.glespFrameWork;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bebetter.glespFrameWork.dao.IBean;
import com.bebetter.glespFrameWork.dao.IRequest;
import com.bebetter.glespFrameWork.dao.IResponse;
import com.bebetter.glespFrameWork.dao.Response;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * Created by songmengyu on 14-10-14.
 */
public abstract class GLESPBaseActivity extends Activity {

    protected Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            handleMessage(msg);
        }
    };


    public void sendRequest(final IRequest request) {
        HttpMethod method = request.getMethod();
        switch (method) {
            case GET:
                GLESPBaseApplication.getInstance().getHttpUtils().send(request.getMethod(), request.getUrl(), new RequestCallBack<String>() {

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
                        IResponse response = new Response(request, bean);
                        handleResponse(response);
                        mHandler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {

                    }
                });
                break;
            case POST:
                RequestParams params = request.getParams();
                GLESPBaseApplication.getInstance().getHttpUtils().send(request.getMethod(), request.getUrl(), params, new RequestCallBack<String>() {

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
                        IResponse response = new Response(request, bean);
                        handleResponse(response);
                        mHandler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {

                    }
                });
                break;
            default:
                break;
        }
    }

    public void downloadFile(IRequest request) {

    }

    public void uploadFile(IRequest request) {

    }

    public abstract void handleResponse(IResponse response);


    protected void handleMessage(Message msg) {

    }
}
