package com.sye.todayfood.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by SYE on 2018-03-26.
 */

public class PinAbsActivityTask {

    public static String BUNDLE;
    public static String TASK;

    private static PinAbsActivityTask sStarter;

    private Context mContext;
    private Bundle mBundle;
    private FragmentType mFragmentType;
    private Intent mIntent;

    static {
        TASK = "Task";
        BUNDLE = "Bundle";
    }

    public PinAbsActivityTask(){

    }

    public void starter(Context context, FragmentType fragmentType){
        newStarter(context, fragmentType);
    }

    public PinAbsActivityTask(Context context, FragmentType fragmentType){
        newStarter(context, fragmentType);
    }

    private void newStarter(Context context, FragmentType fragmentType){
        setContext(context);
        setTask(fragmentType);
        clearBundle();


        start();
    }

    private void setContext(Context context){
        mContext = context;
    }

    private PinAbsActivityTask setTask(FragmentType fragmentType){
        mFragmentType = fragmentType;
        mIntent = new Intent(mContext, PinAbsActivity.class);
        mIntent.putExtra(TASK, fragmentType);
        return this;

    }

    private void clearBundle(){
        if( null == mBundle ){
            mBundle = new Bundle();
            return;
        }
        mBundle.clear();
    }

    public static PinAbsActivityTask getInstance(){
        if (sStarter == null){
            synchronized (PinAbsActivityTask.class){
                if (sStarter != null) return sStarter;
                sStarter = new PinAbsActivityTask();
                return sStarter;
            }
        }
        return sStarter;
    }


    public static PinAbsActivityTask with(Context context, FragmentType fragmentType){
        if (sStarter == null) {
            synchronized (PinAbsActivityTask.class) {
                if (sStarter != null) return sStarter;
                sStarter = new PinAbsActivityTask(context, fragmentType);
                return sStarter;
            }
        }
        sStarter.newStarter(context, fragmentType);
        return sStarter;
    }

    public void start(){

        String nullCheck;

        if(null == mBundle){
            mBundle = new Bundle();
        }

//        if(!mBundle.containsKey(PinAbsFragment.PREV_FRAGMENT) && !TextUtils.isEmpty((CharSequence) (nullCheck = ScreenNameUtils.getScreenName(mContext)))){
//            mBundle.putString(PinAbsFragment.PREV_FRAGMENT, nullCheck);
//        }
        mIntent.putExtra(BUNDLE, mBundle);

        if(mContext instanceof PinAbsActivity) {

            ((PinAbsActivity) mContext).startActivityForResult(mIntent, 0);
        }
        else{
            mContext.startActivity(mIntent);
        }

        mBundle = null;
        mContext = null;
        mIntent = null;

    }
}
