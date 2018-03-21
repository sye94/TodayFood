package com.sye.todayfood.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sye.todayfood.R;
import com.sye.todayfood.common.dialog.ConfirmDialog;
import com.sye.todayfood.utils.NetworkUtil;

/**
 * Created by SYE on 2018-03-16.
 */

public abstract class BaseActivity <V extends ViewDataBinding> extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = BaseActivity.class.getSimpleName();

    private V mViewDataBinding;

    public void isOnline(Context context){

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!NetworkUtil.getConnectivityStatus()) {

                    ConfirmDialog dialog = ConfirmDialog.newInstance(getString(R.string.network_title), getString(R.string.network_check_message), getString(R.string.confirm), null);
                    dialog.show(getSupportFragmentManager(), getString(R.string.network_title));

                }

            }
        }, 1);

    }

    protected void setBinding(@LayoutRes int layoutResId){
        if(mViewDataBinding == null){
            mViewDataBinding = DataBindingUtil.setContentView(this, layoutResId);
        }
    }

    protected V getBinding(){
        return mViewDataBinding;
    }

}
