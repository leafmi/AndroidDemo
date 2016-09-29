package com.leafmi.mi.androiddemo.activity.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.activity.ActivityBuilder;
import com.leafmi.mi.androiddemo.adapter.GeneralAdapter;
import com.leafmi.mi.androiddemo.adapter.JokePicAdapter;
import com.leafmi.mi.androiddemo.bean.network.JokePic;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpActivity extends AppCompatActivity {

    private static final String apiKey = "44300d8fedd3ad764c439543bd6098b2";
    private static final String baseUrl = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_pic";

    private ListView mListViewJokePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        initView();
        initData();
        listener();
        getData(1);
    }


    private void initView() {
        mListViewJokePic = (ListView) findViewById(R.id.listview_joke_pic);
    }

    private void initData() {
        getData(1);

    }

    private void listener() {
    }

    private static final OkHttpClient okHttpClient;

    static {
        okHttpClient = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    private void getData(int page) {
        Request request = new Request.Builder()
                .addHeader("apiKey", apiKey)
                .url(baseUrl + "?" + page)
                .build();
        okHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Gson gson = new Gson();
                        JokePic jokPic = gson.fromJson(response.body().string(), new TypeToken<JokePic>() {
                        }.getType());
                        final List<JokePic.ShowapiResBodyBean.ContentlistBean> contentlist = jokPic.getShowapi_res_body().getContentlist();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mListViewJokePic.setAdapter(new JokePicAdapter(OkHttpActivity.this, contentlist));
                            }
                        });

                    }
                });
    }

}
