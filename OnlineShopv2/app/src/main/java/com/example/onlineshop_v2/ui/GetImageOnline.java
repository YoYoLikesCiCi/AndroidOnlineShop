package com.example.onlineshop_v2.ui;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class GetImageOnline extends Thread{

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public JSONObject TempJsonObject = new JSONObject(); //返回数据存储区

    private String bisbn = "";  //书号
    //获取成功massage
    private int bookMessage = 1;
    //获取失败返回massage
    private int imageStream = 2;

    private Handler handlerGetImageOnline ; //UI线程传递的参数用于向UI线程传递消息和数据

    private String url = "http://47.93.25.50/static";
    public GetImageOnline (Handler mHandler, String bisbn){

        this.handlerGetImageOnline = mHandler;
        this.bisbn = bisbn;
        this.url = this.url + this.bisbn;
        System.out.println(url);
    }

    @Override
    public void run(){
        try {
//            Looper.prepare();

            OkHttpClient client = new OkHttpClient();


//                    Log.d(TAG, "tostring"+requestBody.toString());
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
             Object responseData = response.body().bytes();
//            Looper.loop();
            handlerGetImageOnline.obtainMessage(imageStream,responseData).sendToTarget();
//            Looper.myLooper().quit();
            System.out.println(" 转换成功");
//                    Log.d(TAG, "run: "+ decode);
//                    showResponse(responseData);
        } catch (IOException e) {
            e.printStackTrace();
//                    Log.d(TAG, "run: error");
            System.out.println("run error");
        }

    }

}
