package com.sye.todayfood;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.sye.todayfood.base.BaseActivity;
import com.sye.todayfood.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(R.layout.activity_main);

        init();

    }

    private void init(){

        getBinding().open.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (!getBinding().drawer.isDrawerOpen(Gravity.START)) {
            getBinding().drawer.openDrawer(Gravity.START);
        } else {
            getBinding().drawer.closeDrawer(Gravity.START);
        }



    }


}
