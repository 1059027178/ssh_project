package com.qianyang.ayio2o.HttpOperation;

import android.os.StrictMode;

/**
 * Created by YangYang on 2015/11/6.
 */
public class TheadDAO {
    /**
     * 解决connection.getInputStream   ----报错
     */
    public static void closeStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll().penaltyLog().build());
    }
}
