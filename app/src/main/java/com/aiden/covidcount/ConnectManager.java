package com.aiden.covidcount;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public class ConnectManager {
    public static void getHttp() {
        InputStream inputStream = null;
        try {

            String a = URLDecoder.decode(Config.URL,"UTF-8");
            Log.e("KEG","Config.URL = "+ Config.URL);
            Log.e("KEG","Config.URL.DECODE = "+ a);
            URL url = new URL(a);
            HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
            httpConnection.setRequestProperty("Accepct","application/xml");
            /*
                setRequestProperty - Request Header값 셋팅.
                setRequestProperty("Accepct","application/xml"); 서버 Response Data를 xml 형식으로 요청 \
                 setRequestProperty("Accepct","application/json"); 서버 Response Data를 json 형식의 타입으로 요청.

                setRequestProperty("Content-Type","text/html"); Request Body 전달 시 text/html로 서버에 전달
                setRequestProperty("Content-Type","application/xml"); Request Body 전달 시 application/xml로 서버에 전달
                 setRequestProperty("Content-Type","application/json"); Request Body 전달 시 application/json로 서버에 전달.
             */
            httpConnection.setRequestMethod(Config.HTTP_METHOD_GET);
            httpConnection.setConnectTimeout(Config.HTTP_CONNECT_TIME_OUT);    // Connect Time Out
            httpConnection.setReadTimeout(5000);    // Read시 연결 시간.
            httpConnection.setDoInput(true);    // InputStream으로 서버로부터 응답을 받겠다는 옵션.
            Log.e("KEG","getHttp Code " + httpConnection.getResponseCode());
            if(httpConnection.getResponseCode()==HttpURLConnection.HTTP_OK) {
                inputStream = httpConnection.getInputStream();
                ParsingTool.parseXml(inputStream);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
