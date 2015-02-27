package com.bebetter.glespClient;

import com.bebetter.glespFrameWork.dao.BaseParser;
import com.bebetter.glespFrameWork.dao.IBean;

/**
 * Created by SamuraiSong on 14/2/15.
 */
public class StatusParser extends BaseParser {


    public StatusParser(BaseParser nextParser) {
        super(nextParser);
    }

    @Override
    public IBean parse(String json) {
        return null;
    }

}
