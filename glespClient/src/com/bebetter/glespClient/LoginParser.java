package com.bebetter.glespClient;

import com.bebetter.glespFrameWork.dao.BaseParser;
import com.bebetter.glespFrameWork.dao.IBean;

/**
 * Created by SamuraiSong on 21/12/14.
 */
public class LoginParser extends BaseParser {

    public LoginParser(BaseParser nextParser) {
        super(nextParser);
    }

    @Override
    public IBean parse(String json) {

        if (null != nextParser ) {
            return nextParser.parse(json);
        }

        return new IBean() {
        };
    }

}
