package com.sye.todayfood.common;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.SearchView;

import com.sye.todayfood.R;

/**
 * Created by SYE on 2018-03-19.
 */

public class ToolbarHelper implements SearchView.OnQueryTextListener{

    protected static ToolbarHelper instance;
    protected ActionBar mActionbar;
    protected AppCompatActivity mActivity;
    protected int mBgColorId;
    protected Menu mMenu;
    protected SearchView mSearchView;
    protected Toolbar mToolbar;
    protected ToolbarActionType mToolbarActionType;

    public ToolbarHelper(AppCompatActivity appCompatActivity){
        mActivity = appCompatActivity;
    }

    public static ToolbarHelper getInstance(AppCompatActivity appCompatActivity){
        if(appCompatActivity != null){
            instance = new ToolbarHelper(appCompatActivity);
        }
        return instance;
    }

    public void clearHelper() {
        if (mSearchView != null && !mSearchView.isIconified()) {
            mSearchView.setIconified(true);
        }
        if (mSearchView != null) {
            mSearchView.setOnQueryTextListener(this);
        }
    }

    public void clearSearchView(){
        if(mSearchView!=null){
            if(mSearchView.getQuery().length() > 0){
                mSearchView.setQuery(null, false);
            }

            clearSearchViewFocus();
        }
    }

    public void clearSearchViewFocus(){
        if(mSearchView!=null){
            mSearchView.clearFocus();;
        }
    }

    public void clearToolbarActionType() {
        mToolbarActionType = null;
    }

    public int getActionBarTitleId(){
        try {
            int n = Class.forName("com.android.internal.R$id").getField("action_bar_title").getInt(null);
            return n;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public ActionBar getActionbar() {
        if (mActivity != null && mActionbar == null) {
            setToolbar();
        }
        return mActionbar;
    }

    public int getBackgroundColorId(){
        return mBgColorId;
    }

    public Toolbar getToolbar(){
        if(mActivity!=null && mToolbar == null){

        }
        return mToolbar;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    public void setBackground(int color){
        getToolbar().setBackgroundColor(ContextCompat.getColor(mActivity.getApplicationContext(), color));
        mBgColorId = color;
    }

    public void setBackground(Drawable drawable){
        int sdk_version = Build.VERSION.SDK_INT;
        if(sdk_version < 22){
            if(sdk_version<16){
                getToolbar().setBackgroundDrawable(drawable);
                return;
            }
            getToolbar().setBackground(drawable);
            return;
        }
        getToolbar().setBackground(drawable);
    }

    public void setNavigationIcon(int navigationIcon){
        getToolbar().setBackground(ContextCompat.getDrawable(mActivity.getApplicationContext(), navigationIcon));
    }

    public void setTitleColor(int color){
        getToolbar().setTitleTextColor(ContextCompat.getColor(mActivity.getApplicationContext(), color));
    }

    public void setToolbar() {
        if (mActivity != null) {
            mToolbar = (Toolbar)mActivity.findViewById(R.id.toolbar);
            mActivity.setSupportActionBar(mToolbar);
            mActionbar = mActivity.getSupportActionBar();
        }
    }

    public void setToolbarActionType( ToolbarActionType toolbarActionType) {
        if (mToolbarActionType == null) {
            mToolbarActionType = toolbarActionType;
        }
    }

    public void setToolbarHeight(int n) {
        getToolbar().getLayoutParams().height = n;
    }

    public void setToolbarSearchView(SearchView searchView) {
        if (searchView == null) {
            return;
        }
        mSearchView = searchView;
        mSearchView.setOnQueryTextListener((SearchView.OnQueryTextListener)this);
    }

    public void setToolbarSubtitle(String string) {
        if (getActionbar() == null) {
            return;
        }
        getActionbar().setSubtitle(string);
    }

    public void setToolbarTheme() {
        if (mActivity == null) {
            // empty if block
        }
    }

    public void setToolbarTitle(String string) {
        setToolbarTitle(string, null);
    }

    public void setToolbarTitle(String string, String string2) {
        if (getActionbar() == null) {
            return;
        }
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
/*
        RobotoTypefaceSpan span = new RobotoTypefaceSpan(
                mActivity,
                RobotoTypefaceManager.FontFamily.ROBOTO,
                RobotoTypefaceManager.TextWeight.BOLD,
                RobotoTypefaceManager.TextStyle.NORMAL);


        Spannable spannable = new SpannableString(string);
        spannable.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/

        getActionbar().setTitle(string);
        getActionbar().setSubtitle(string2);
    }

    public void updateMenuItemText(int n, String string) {
        if (mMenu != null && string != null) {
            mMenu.findItem(n).setTitle((CharSequence)string);
        }
    }

    public enum ToolbarActionType{
        NONE, TRANSPARENT, SCROLL;
    }
}
