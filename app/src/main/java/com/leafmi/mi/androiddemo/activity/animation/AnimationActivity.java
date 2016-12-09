package com.leafmi.mi.androiddemo.activity.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.activity.ActivityBuilder;
import com.leafmi.mi.androiddemo.adapter.GeneralAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnimationActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<>();
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
        initData();
        listener();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.listview_animation);
    }

    private void initData() {
        list.add("DownLoadView");

        mListView.setAdapter(new GeneralAdapter(this, list));
    }

    private void listener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ActivityBuilder.toDownloadViewActivity(AnimationActivity.this);
                        break;
                }
            }
        });
    }
}
