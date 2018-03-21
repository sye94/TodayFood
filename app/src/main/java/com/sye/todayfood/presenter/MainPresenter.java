package com.sye.todayfood.presenter;

import android.content.Context;
import android.util.Log;

import com.sye.todayfood.R;

/**
 * Created by SYE on 2018-03-21.
 */

public class MainPresenter implements MainContract.Presenter {

    private Context context;
    private MainContract.View view;

    @Override
    public void attachView(MainContract.View view, Context context) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void showDialog() {

        String title = context.getString(R.string.network_title);
        String content = context.getString(R.string.network_check_message);
        String positiveButton = context.getString(R.string.confirm);

        view.showDialog(title, content, positiveButton, null);

    }
}
