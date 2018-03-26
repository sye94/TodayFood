package com.sye.todayfood.utils;

import android.content.Context;

import com.sye.todayfood.common.PinAbsActivity;
import com.sye.todayfood.common.PinAbsFragment;


/**
 * Created by SYE on 2018-03-26.
 */

public class ScreenNameUtils {

    public static String getScreenName(Context context){
        if (null!=context&&context instanceof PinAbsActivity){
            PinAbsFragment baseFragment = ((PinAbsActivity) context).getFragment();

            if (null!=baseFragment){
                return baseFragment.getCurrentFragment();
            }
        }
        return null;
    }
}
