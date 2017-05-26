package com.example.qlsv.qlsv.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.qlsv.qlsv.R;
import com.example.qlsv.qlsv.fragment.UserInfoFragment;
import com.example.qlsv.qlsv.model.UserInfo;

import org.json.JSONArray;
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

public class UseInfoApi {
    TextView txtLastName,txtFirstName,txtMSSV,txtPhone,txtBirthday,txtPlaceOfBirth,txtGender,txtNation,txtClass;
    String UrlLogin;


    public void start(final Activity activity) {
        txtLastName = (TextView) activity.findViewById(R.id.txtLastName);
        txtFirstName = (TextView) activity.findViewById(R.id.txtFirstName);
        txtMSSV = (TextView) activity.findViewById(R.id.txtMSSV);
        txtPhone = (TextView) activity.findViewById(R.id.txtLastName);
        txtBirthday = (TextView) activity.findViewById(R.id.txtBirthday);
        txtPlaceOfBirth = (TextView) activity.findViewById(R.id.txtPlaceOfBirth);
        txtGender = (TextView) activity.findViewById(R.id.txtGender);
        txtNation = (TextView) activity.findViewById(R.id.txtNation);
        txtClass = (TextView) activity.findViewById(R.id.txtClass);
    }

    public void ParseJson(String input) {
        UserInfo userInfo = new UserInfo();

        if (input.isEmpty()) {
            return;
        }

        try {
            JSONArray mang = new JSONArray(input);
            for (int i = 0; i < mang.length(); i++) {

                JSONObject obj = mang.getJSONObject(i);
                userInfo.setFistname(obj.getString("ho_dem"));
                userInfo.setLastname(obj.getString("ten"));
                userInfo.setBirthday(obj.getString("ngay_sinh"));
                userInfo.setMssv(obj.getString("ho_dem"));
                userInfo.setPhone(obj.getString("dien_thoai"));
                userInfo.setPlaceofbirth(obj.getString("noi_sinh_id"));
                userInfo.setGender(obj.getString("gioi_tinh"));
                userInfo.setNation(obj.getString("dan_toc"));
                userInfo.setClassroom(obj.getString("ho_dem"));

                txtFirstName.setText(userInfo.getFistname());
                txtLastName.setText(userInfo.getLastname());
                txtMSSV.setText(userInfo.getMssv());
                txtPhone.setText(userInfo.getPhone());
                txtBirthday.setText(userInfo.getBirthday());
                txtPlaceOfBirth.setText(userInfo.getPlaceofbirth());
                txtGender.setText(userInfo.getGender());
                txtNation.setText(userInfo.getNation());
                txtClass.setText(userInfo.getClassroom());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ProssData extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {

            String res = null;
            try {
                res = downloadUrl(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("test", res);
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            ParseJson(s);
        }
    }

    public String GetParamLogin(String mssv, String tokens){
        String paramString = "";
        JSONObject param = new JSONObject();
        try {
            param.put("mssv", mssv);
            param.put("token", tokens);
            paramString = URLEncoder.encode(param.toString(), "utf-8");
        } catch (Exception e) {

        }
        Log.d("test", "param:" + param.toString());
        return paramString;
    }

    public void Info(UserInfoFragment activity, String Mssv, String Tokens){
        String param = GetParamLogin(Mssv, Tokens);
        UrlLogin = SettingAPI.GetUrlLogin(param);
//        try {
//            String output=  downloadUrl(UrlLogin);
//           Log.d("test",output);
//            // bay gio minh test nên mình chưa cần tới cái tháng này
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public String ParseJsonInfo(String input){
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
}
