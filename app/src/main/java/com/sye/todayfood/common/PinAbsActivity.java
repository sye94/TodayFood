package com.sye.todayfood.common;

import android.os.Bundle;

import com.sye.todayfood.R;
import com.sye.todayfood.databinding.ActivityMainBinding;

/**
 * Created by SYE on 2018-03-26.
 */

public class PinAbsActivity extends BaseActivity<ActivityMainBinding> {

    protected PinAbsFragment mFragment;

    protected FragmentType mTask;
    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(R.layout.activity_main);

        if(getIntent() !=null){
            if(getIntent().hasExtra(PinAbsActivityTask.TASK)){
                mTask = (FragmentType)getIntent().getSerializableExtra(PinAbsActivityTask.TASK);
            }
            if(getIntent().hasExtra(PinAbsActivityTask.BUNDLE)){
                mBundle = getIntent().getBundleExtra(PinAbsActivityTask.BUNDLE);
            }
        }

        if(savedInstanceState !=null) return;

        try {
            mFragment = (PinAbsFragment) mTask.getFragmentInstance().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            getSupportFragmentManager().beginTransaction().add(R.id.container, mFragment).commit();

            return;
        } catch (Exception var3_3) {
            var3_3.printStackTrace();
            return;
        }
    }

    public PinAbsFragment getFragment(){
        return mFragment;
    }

}
