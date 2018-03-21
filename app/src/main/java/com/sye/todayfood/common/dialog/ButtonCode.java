package com.sye.todayfood.common.dialog;

/**
 * Created by SYE on 2018-03-21.
 */

public enum ButtonCode {

    POSITIVE(1), NEGATIVE(2);

    private int dismissCode;

    ButtonCode(int dismissCode){
        this.dismissCode = dismissCode;
    }

    public int getDismissCode(){
        return dismissCode;
    }

}
