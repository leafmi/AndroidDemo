package com.leafmi.mi.androiddemo.activity.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.view.DownLoadView;

public class DownLoadViewActivity extends AppCompatActivity {

    private DownLoadView mDownloadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load_view);
        initView();
        listener();
    }

    private void initView(){
        mDownloadView= (DownLoadView)findViewById(R.id.download_view);
    }

    private void listener(){
        mDownloadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDownloadView.startAni();
            }
        });
    }
}
