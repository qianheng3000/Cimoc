package com.hiroshi.cimoc.core;

import com.hiroshi.cimoc.core.base.Manga;

/**
 * Created by Hiroshi on 2016/7/3.
 */
public class Kami {

    public static final int SOURCE_IKANMAN = 0;
    public static final int SOURCE_DMZJ = 1;

    public static String getSourceById(int id) {
        switch (id) {
            case SOURCE_IKANMAN:
                return "看漫画";
            case SOURCE_DMZJ:
                return "动漫之家";
            default:
                return "";
        }
    }

    public static String getRefererById(int id) {
        switch (id) {
            default:
            case SOURCE_IKANMAN:
                return "http://m.ikanman.com";
            case SOURCE_DMZJ:
                return "http://manhua.dmzj.com/";
        }
    }

    private static IKanman mIKanman;
    private static Dmzj mDmzj;

    public static Manga getMangaById(int id) {
        switch (id) {
            default:
            case SOURCE_IKANMAN:
                if (mIKanman == null) {
                    mIKanman = new IKanman();
                }
                return mIKanman;
            case SOURCE_DMZJ:
                if (mDmzj == null) {
                    mDmzj = new Dmzj();
                }
                return mDmzj;
        }
    }

}
