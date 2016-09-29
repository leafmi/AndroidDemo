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
import com.leafmi.mi.androiddemo.bean.network.FunVideo;
import com.leafmi.mi.androiddemo.utils.network.RetrofitHelper;
import com.squareup.okhttp.internal.http.RealResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetWorkActivity extends AppCompatActivity {

    private List<String> listMina = new ArrayList<>();

    private ListView mListViewMian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);

        initView();
        initData();
        listener();
    }

    private void initView() {
        mListViewMian = (ListView) findViewById(R.id.listview_mian);
    }

    private void initData() {
        listMina.add("Okhttp");
        listMina.add("Retrofit");
        mListViewMian.setAdapter(new GeneralAdapter(this, listMina));
    }

    private void listener() {
        mListViewMian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        ActivityBuilder.toOkHttpActivity(NetWorkActivity.this);
                        break;
                    case 1:
                        break;
                }
            }
        });
    }

}
