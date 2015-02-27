package com.bebetter.glespClient;

import com.bebetter.glespFrameWork.dao.IBean;

/**
 * Created by SamuraiSong on 14/2/15.
 */
public class LoginBean implements IBean {
    // { head : { status : "fail"},body { uid: "sifsdglfdg",date:"2015-02-14"}}

    String uid = "";
    String date = "";

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
