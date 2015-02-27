package com.bebetter.glespFrameWork;

/**
 * Created by SamuraiSong on 14/2/15.
 */
public class SingleInstance {

    private static SingleInstance instance = null;

    private SingleInstance () {

    }

    public static SingleInstance getInstance() {
        if (null != instance)
            return instance;
        synchronized (SingleInstance.class) {
            instance = new SingleInstance();
        }
        return instance;
    }
}
