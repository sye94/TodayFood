package com.sye.todayfood.presenter;

import android.content.Context;

/**
 * Created by SYE on 2018-03-21.
 */

public interface MainContract {

    interface View{
        void showDialog(String title, String content, String positiveButton, String negativeButton);
    }

    interface Presenter{
        void attachView(View view, Context context);
        void showDialog();
    }
}
