package com.example.qlsv.qlsv.api;

import android.util.Log;

/**
 * Created by phong on 5/20/2017.
 */

public class SettingAPI {
    private static final String APILogin ="LoginApi";
    public static String TOKEN = null;

    public static String getBaseUrl(String api) {
        return "http://caifido.com" + api + "&token=" + TOKEN;

    }
    public static String GetUrlLogin(String param){
        String url = new StringBuilder(String.valueOf(getBaseUrl(APILogin))).append("&arrParam=").append(param).toString();
        Log.d("test", "url:" + url.toString());
        return url;
    }

}
