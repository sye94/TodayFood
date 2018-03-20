package com.sye.todayfood.common.dialog;

import android.os.Bundle;
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

    private String mTitle;
    private String mContent;

    public static ConfirmDialog newInstance(String title, String content) {

        Bundle args = new Bundle();

        ConfirmDialog fragment = new ConfirmDialog();
        args.putString(ARGS_TITLE, title);
        args.putString(ARGS_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (null != getArguments()) {
            mTitle = getArguments().getString(ARGS_TITLE);
            mContent = getArguments().getString(ARGS_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return setBinding(inflater, R.layout.dialog_confirm, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBinding().btnPositive.setOnClickListener(this);
        getBinding().btnNegative.setOnClickListener(this);
        getBinding().txtTitle.setText(mTitle);
        getBinding().txtConfirm.setText(mContent);

    }

    public void setButtonCode(int code){

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_positive:
                break;
            case R.id.btn_negative:
                break;
        }
        dismiss();
    }

    public enum ButtonCode{

        POSITIVE(1), NEGATIVE(2);

        private int dismissCode;

        ButtonCode(int dismissCode){
            this.dismissCode = dismissCode;
        }

        public int getDismissCode(){
            return dismissCode;
        }
    }
}



















