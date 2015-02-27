package com.bebetter.glespFrameWork.dao;

/**
 * Created by SamuraiSong on 21/12/14.
 */
public abstract class BaseParser implements IParser {

    protected BaseParser nextParser = null;

    public BaseParser (BaseParser nextParser) {
        this.nextParser = nextParser;
    }
}
