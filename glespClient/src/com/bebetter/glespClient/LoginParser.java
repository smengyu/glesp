package com.bebetter.glespClient;

import com.bebetter.glespFrameWork.dao.IBean;
import com.bebetter.glespFrameWork.dao.IParser;

/**
 * Created by SamuraiSong on 21/12/14.
 */
public class LoginParser implements IParser {
    private IParser nextParser;

    @Override
    public IBean parse(String json) {

        if (null != nextParser) {
            return nextParser.parse(json);
        }

        return new IBean() {
        };
    }

    @Override
    public void setNextParser(IParser parser) {
        nextParser = parser;
    }
}
