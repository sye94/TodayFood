package com.sye.todayfood.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SYE on 2018-03-26.
 */

public abstract class BaseFragment<V extends ViewDataBinding> extends Fragment {
    private V mViewBinding;

    protected View setBinding(LayoutInflater inflater, @LayoutRes int layoutResId, ViewGroup container) {

        if (mViewBinding == null) {
            mViewBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false);
        }

        return mViewBinding.getRoot();

    }

    public V getBinding() {
        return mViewBinding;
    }
}
