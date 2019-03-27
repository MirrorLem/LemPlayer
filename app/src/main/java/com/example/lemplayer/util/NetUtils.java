package com.example.lemplayer.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络检测工具
 * @author fangzehua
 *
 */
public class NetUtils {

    /**
     * 检测网络是否连接
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
    	if (context != null) { 
    	ConnectivityManager mConnectivityManager = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
    	if (mNetworkInfo != null) { 
    	return mNetworkInfo.isAvailable(); 
    	} 
    	} 
    	return false; 
    }
    
    
    
    /**
     * 判断WIFI是否可用
     * @param context
     * @return
     */
     public static boolean isWifiConnected(Context context) {
    	if (context != null) { 
    	ConnectivityManager mConnectivityManager = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo mWiFiNetworkInfo = mConnectivityManager .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    	if (mWiFiNetworkInfo != null) { 
    	return mWiFiNetworkInfo.isAvailable(); 
    	} 
    	} 
    	return false; 
    }
    
    /**
     * 判断MOBILE网络是否可用
     * @param context
     * @return
     */
      public static boolean isMobileConnected(Context context) {
    	if (context != null) { 
    	ConnectivityManager mConnectivityManager = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo mMobileNetworkInfo = mConnectivityManager
    	.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
    	if (mMobileNetworkInfo != null) { 
    	return mMobileNetworkInfo.isAvailable(); 
    	} 
    	} 
    	return false; 
     }
}
