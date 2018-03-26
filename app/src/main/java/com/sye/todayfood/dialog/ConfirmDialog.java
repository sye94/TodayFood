package com.sye.todayfood.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sye.todayfood.R;
import com.sye.todayfood.databinding.DialogConfirmBinding;

/**
 * Created by SYE on 2018-03-16.
 */

public class ConfirmDialog extends BaseDialog<DialogConfirmBinding> implements View.OnClickListener{

    public final static String TAG = ConfirmDialog.class.getSimpleName();

    private static final String ARGS_TITLE = "title";
    private static final String ARGS_CONTENT = "content";
    private static final String ARGS_POSITIVE_BUTTON = "positiveButton";
    private static final String ARGS_NEGATIVE_BUTTON = "negativeButton";

    private String mTitle;
    private String mContent;
    private String mPositiveButton;
    private String mNegativeButton;

    private ButtonCallback mButtonCallback;

    public static ConfirmDialog newInstance(String title, String content, String positiveButton, String negativeButton) {

        Bundle args = new Bundle();

        ConfirmDialog fragment = new ConfirmDialog();
        args.putString(ARGS_TITLE, title);
        args.putString(ARGS_CONTENT, content);
        args.putString(ARGS_POSITIVE_BUTTON, positiveButton);
        args.putString(ARGS_NEGATIVE_BUTTON, negativeButton);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (null != getArguments()) {
            mTitle = getArguments().getString(ARGS_TITLE);
            mContent = getArguments().getString(ARGS_CONTENT);
            mPositiveButton = getArguments().getString(ARGS_POSITIVE_BUTTON);
            mNegativeButton = getArguments().getString(ARGS_NEGATIVE_BUTTON);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return setBinding(inflater, R.layout.dialog_confirm, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        init();

    }

    private void init(){

        getBinding().btnPositive.setOnClickListener(this);
        getBinding().btnNegative.setOnClickListener(this);

        if(!TextUtils.isEmpty(mTitle)){
            getBinding().txtTitle.setVisibility(View.VISIBLE);
            getBinding().txtTitle.setText(mTitle);
        }

        if(!TextUtils.isEmpty(mNegativeButton)){
            getBinding().btnNegative.setVisibility(View.VISIBLE);
            getBinding().btnNegative.setText(mNegativeButton);
        }

        getBinding().btnPositive.setText(mPositiveButton);
        getBinding().txtConfirm.setText(mContent);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_positive:
                mButtonCallback.callback(ButtonCode.POSITIVE);
                break;
            case R.id.btn_negative:
                mButtonCallback.callback(ButtonCode.NEGATIVE);
                break;
        }
        dismiss();
    }

    public void setCallback(ButtonCallback buttonCallback){
        mButtonCallback = buttonCallback;
    }

}



















