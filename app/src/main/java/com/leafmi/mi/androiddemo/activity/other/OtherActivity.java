package com.leafmi.mi.androiddemo.activity.other;

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

public class OtherActivity extends AppCompatActivity {
    private List<String> listOther = new ArrayList<>();

    private ListView mListViewOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initView();
        initData();
        listener();
    }

    private void initView() {
        mListViewOther = (ListView) findViewById(R.id.listview_other);
    }

    private void initData() {
        listOther.add("CurveChart");

        mListViewOther.setAdapter(new GeneralAdapter(this, listOther));
    }

    private void listener() {
        mListViewOther.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        ActivityBuilder.toCurveChartActivity(OtherActivity.this);
                        break;
                }
            }
        });
    }
}
