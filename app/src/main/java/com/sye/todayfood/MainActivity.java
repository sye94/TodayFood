package com.sye.todayfood;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.MenuItem;

import com.sye.todayfood.common.BaseActivity;
import com.sye.todayfood.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(R.layout.activity_main);

        init();

    }

    private void init(){

        setSupportActionBar(getBinding().toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                if (!getBinding().drawer.isDrawerOpen(Gravity.START)) {
                    getBinding().drawer.openDrawer(Gravity.START);
                } else {
                    getBinding().drawer.closeDrawer(Gravity.START);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
