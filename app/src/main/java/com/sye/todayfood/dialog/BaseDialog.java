package com.sye.todayfood.dialog;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SYE on 2018-03-20.
 */

public abstract class BaseDialog <V extends ViewDataBinding> extends DialogFragment implements View.OnClickListener {

    private V mViewBinding;

    protected View setBinding(LayoutInflater inflater, @LayoutRes int layoutResId, ViewGroup container){

        if (mViewBinding == null) {

            mViewBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false);

        }

        return mViewBinding.getRoot();
    }

    protected V getBinding(){
        return mViewBinding;
    }

}
