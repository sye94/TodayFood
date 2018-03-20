package com.sye.todayfood.utils;

import android.support.v4.app.Fragment;

import com.sye.todayfood.fragment.TestFragment;

/**
 * Created by SYE on 2018-03-16.
 */

public enum  FragmentType {

    TEST(TestFragment.class);

    private Class<? extends Fragment> mFragmentInstance;

    FragmentType(Class<? extends Fragment> fragment) {
        mFragmentInstance = fragment;
    }

    public Class<? extends Fragment> getFragmentInstance() {
        return mFragmentInstance;
    }

    public int getValue() {
        return ordinal();
    }
}
