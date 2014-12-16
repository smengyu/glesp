package com.bebetter.glespFrameWork;

import android.app.Application;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;

/**
 * Created by songmengyu on 14-10-14.
 */
public class GLESPBaseApplication extends Application {

      private HttpUtils httpUtils;
      private BitmapUtils bitmapUtils;
      private DbUtils dbUtils;
      private static GLESPBaseApplication instance;

      @Override
      public void onCreate() {
            super.onCreate();
            instance = this;
            httpUtils = new HttpUtils();
            bitmapUtils = new BitmapUtils(this);
            dbUtils = DbUtils.create(this);
      }

      public static GLESPBaseApplication getInstance(){
            return instance;
      }

      public HttpUtils getHttpUtils() {
            return httpUtils;
      }

      public BitmapUtils getBitmapUtils() {
            return bitmapUtils;
      }

      public DbUtils getDbUtils() {
            return dbUtils;
      }
}
