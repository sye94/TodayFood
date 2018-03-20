package com.sye.todayfood;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.sye.todayfood.base.BaseActivity;
import com.sye.todayfood.common.dialog.ConfirmDialog;
import com.sye.todayfood.databinding.ActivityMainBinding;
import com.sye.todayfood.model.response.User;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(R.layout.activity_main);

        init();

    }

    private void init(){
        getBinding().btnTest.setOnClickListener(this);

        User user = new User("shin", "youngeun");
        getBinding().setUser(user);
    }

    @Override
    public void onClick(View view) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ConfirmDialog dialog = ConfirmDialog.newInstance(getString(R.string.network_title),getString(R.string.network_check_message));
        dialog.show(transaction, ConfirmDialog.TAG);

    }
}
