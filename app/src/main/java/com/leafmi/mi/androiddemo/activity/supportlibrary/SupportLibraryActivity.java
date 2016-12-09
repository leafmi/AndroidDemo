package com.leafmi.mi.androiddemo.activity.supportlibrary;

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

public class SupportLibraryActivity extends AppCompatActivity {

private ListView mListView;
    private List<String> listData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_library);

        initView();
        initData();
        listener();
    }

    private void initView() {
        mListView =(ListView)findViewById(R.id.listview);
    }

    private void initData() {
        listData.add("CoordinatorLayout");

        mListView.setAdapter(new GeneralAdapter(this,listData));
    }

    private void listener(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ActivityBuilder.toCoordinatorLayoutActivity(SupportLibraryActivity.this);
                        break;
                }
            }
        });
    }
}
