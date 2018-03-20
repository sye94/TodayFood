package com.sye.todayfood.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.sye.todayfood.base.MyApplication;

/**
 * Created by SYE on 2018-03-16.
 */

public class NetworkUtil {

    public static boolean getConnectivityStatus() {

        boolean isNetworkConnect = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (null != activeNetwork && activeNetwork.isConnected()) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                isNetworkConnect = checkWifiAddr();
            }

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                isNetworkConnect = true;
            }
        }

        return isNetworkConnect;
    }

    public static boolean checkWifiAddr() {
        WifiManager wifiManager = (WifiManager) MyApplication.getInstance().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();

        String ipString = String.format("%d.%d.%d.%d",
                (ip & 0xff),
                (ip >> 8 & 0xff),
                (ip >> 16 & 0xff),
                (ip >> 24 & 0xff));

        if (ip != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMobileConnected() {
        boolean isNetworkConnect = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (null != activeNetwork && activeNetwork.isConnected()) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                isNetworkConnect = true;
            }
        }
        return isNetworkConnect;
    }
}
