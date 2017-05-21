package com.example.qlsv.qlsv.api;

import android.app.Activity;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by phong on 5/20/2017.
 */

public class Login {
    String UrlLogin;
    public String GetParamLogin(String username, String Pass){
        String paramString = "";
        JSONObject param = new JSONObject();
        try {
            param.put("mssv", username);
            param.put("pass", Pass);
            paramString = URLEncoder.encode(param.toString(), "utf-8");
        } catch (Exception e) {

        }
        Log.d("test", "param:" + param.toString());
        return paramString;
    }

    public void Login(Activity activity, String User, String Pass){
        String param = GetParamLogin(User, Pass);
        Log.d("test", param);
        UrlLogin = SettingAPI.GetUrlLogin(param);
        Log.d("test", UrlLogin);
        String data = datatest(400,"Bad Request");
        Log.d("test", "data ban can doc: " + data);

        String hung = ParseJsonLogin(data);
        Log.d("test", "trang thai cua toi" + hung);
//        try {
//            String output=  downloadUrl(UrlLogin);
//           Log.d("test",output);
//            // bay gio minh test nên mình chưa cần tới cái tháng này
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public String ParseJsonLogin(String input){
        String mess = "";
        try {
            JSONObject obj  = new JSONObject(input);
            int code = obj.getInt("status");
            if(code ==200){
                mess = obj.getString("tokens");
            }else{
                mess = obj.getString("message");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mess;
    }
    public String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Error downloading url", e.toString());
        } finally {
            try {
                if (iStream != null) {
                    iStream.close();
                }
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            } catch (Exception ignored) {
            }
        }
        return data;
    }

    public String datatest(int status, String mess){
        String paramString = "";
        JSONObject param = new JSONObject();
        try {
            param.put("status", status);
            param.put("message", mess);
            paramString =param.toString();
        } catch (Exception e) {
        }

        return paramString;
    }
}
