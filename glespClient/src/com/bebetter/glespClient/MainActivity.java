package com.bebetter.glespClient;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.bebetter.glespFrameWork.GLESPBaseActivity;
import com.bebetter.glespFrameWork.dao.BaseRequest;
import com.bebetter.glespFrameWork.dao.IBean;
import com.bebetter.glespFrameWork.dao.IParser;
import com.bebetter.glespFrameWork.dao.IResponse;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * Created by SamuraiSong on 16/12/14.
 */
public class MainActivity extends GLESPBaseActivity {

    private EditText userNameEditText;
    private Button loginBtn;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        userNameEditText = (EditText) findViewById(R.id.username);
        loginBtn = (Button) findViewById(R.id.login);

        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameStr = userNameEditText.getText().toString();

                BaseRequest baseRequest = new BaseRequest() {
                    @Override
                    public int getCategory() {
                        return LOGIN;
                    }

                    @Override
                    public HttpMethod getMethod() {
                        return HttpMethod.POST;
                    }

                    @Override
                    public String getUrl() {
                        return "http://bibaite.cn/interfaces.php/student/login.html";
                    }

                    @Override
                    public IParser getParser() {
                        return new LoginParser(new StatusParser(null));
                    }

                    @Override
                    public RequestParams getParams() {
                        RequestParams requestParams = new RequestParams();
                        requestParams.addQueryStringParameter("username", "123456");
                        requestParams.addQueryStringParameter("password", "123456");
                        return requestParams;
                    }
                };

                sendRequest(baseRequest);
            }
        });
    }

    @Override
    public void handleResponse(IResponse response) {
        IBean data = response.getData();
    }

    @Override
    protected void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
