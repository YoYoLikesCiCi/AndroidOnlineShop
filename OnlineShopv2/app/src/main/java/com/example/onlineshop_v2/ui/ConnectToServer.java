package com.example.onlineshop_v2.ui;

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


public class ConnectToServer {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public JSONObject TempJsonObject = new JSONObject();
    public void sendRequestWithHttpURLConnection(JSONObject sentJsonObject, String keyword){

        final String url = "http://47.93.25.50/"+keyword;
        System.out.println(url);
        //开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    //后面让他等于传入的jsonObject
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name","孙起");
                    jsonObject.put("password","123445");

                    String json = jsonObject.toString();
                    OkHttpClient client = new OkHttpClient();

                    RequestBody requestBody = RequestBody.create(JSON,json);

                    System.out.println("tostring" + requestBody.toString());
//                    Log.d(TAG, "tostring"+requestBody.toString());
                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    JSONObject Jobject = new JSONObject(responseData);
//                    System.out.println(Jobject);
//                    String decode = decodeUnicode(responseData);
//                    System.out.println("type of response:"+getType(response));
//                    System.out.println(response.toString());
//                    System.out.println("type of responseData:"+getType(responseData));
//                    System.out.println(responseData.toCharArray());
//                    System.out.println("type of decode:"+getType(decode));


//                    System.out.println(Jobject);
                    TempJsonObject = Jobject;
//                    Log.d(TAG, "run: "+ decode);
//                    showResponse(responseData);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
//                    Log.d(TAG, "run: error");
                    System.out.println("run error");
                }

            }
        }).start();
    }

//    private void showResponse(final String response){
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //在这里进行UI操作，将结果显示到界面上
////                responseText.setText(response);
//            }
//        });
//    }

//    private void parseJsonWithJsonObject(Response response) throws IOException {
//        String responseData=response.body().string();
//        try{
//            JSONArray jsonArray=new JSONArray(responseData);
//            for(int i=0;i<jsonArray.length();i++)
//            {
////                JSONObject jsonObject=jsonArray.getJSONObject(i);
////                String id=jsonObject.getString("id");
////                String name=jsonObject.getString("name");
//                Log.d(TAG, "parseJsonWithJsonObject: " + i);
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }


    //转换接收过来的json数据编码， unicode -> utf-8
    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuilder outBuffer = new StringBuilder(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

    //获取数据类型
//    public static String getType(Object o) {
//        return o.getClass().getName();
//    }

}
