package com.leafmi.mi.androiddemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.adapter.GeneralAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listMina = new ArrayList<>();

    private ListView mListViewMian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        listener();
    }

    private void initView() {
        mListViewMian = (ListView) findViewById(R.id.listview_mian);
    }

    private void initData() {
        listMina.add("NetWork");
        listMina.add("Image");
        listMina.add("Animation");
        listMina.add("Other");
        listMina.add("View");
        listMina.add("Support library");

        mListViewMian.setAdapter(new GeneralAdapter(this, listMina));
    }

    private void listener() {
        mListViewMian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        ActivityBuilder.toNetWorkActivity(MainActivity.this);
                        break;
                    case 1:
                        break;
                    case 2:
                        ActivityBuilder.toAnimationActivity(MainActivity.this);
                        break;
                    case 3:
                        ActivityBuilder.toOtherActivity(MainActivity.this);
                        break;
                    case 4:
                        ActivityBuilder.toViewActivity(MainActivity.this);
                        break;
                    case 5:
                        ActivityBuilder.toSupportLibraryActivity(MainActivity.this);
                        break;
                }
            }
        });
    }
}
