package com.sye.todayfood.base;

import android.app.Application;

/**
 * Created by SYE on 2018-03-16.
 */

public class MyApplication extends Application{

    private static MyApplication myApplication = null;

    public static MyApplication getInstance(){
        return myApplication;
    }

}
