package com.leafmi.mi.androiddemo.activity.other;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.view.CurveChartView;

import java.util.ArrayList;
import java.util.List;

public class CurveChartActivity extends AppCompatActivity {

    private CurveChartView mCurveChart;
    private List<Long> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curve_chart);

        initView();
        initData();
    }

    private void initView() {
        mCurveChart = (CurveChartView) findViewById(R.id.curve_chart);

    }

    private void initData() {

//        list.add(899664l);
//        list.add(4646l);
//        list.add(313l);
//        list.add(899664l);
//        list.add(567l);
//        list.add(342424l);
//        list.add(42342l);
//        list.add(4646l);
//        list.add(313l);
//        list.add(54646l);
//        list.add(483l);
//        list.add(42342l);
//
//        list.add(8888l);
//        list.add(25243l);
//        list.add(567l);
//        list.add(342424l);
//        list.add(42342l);
//        list.add(4646l);
//        list.add(2511l);
//        list.add(54646l);
//        list.add(483l);
//        list.add(9631l);
//
//        list.add(89541l);
//        list.add(313l);
//        list.add(567l);
//        list.add(552l);
//        list.add(42342l);
//        list.add(4646l);
//        list.add(313l);
//        list.add(54646l);
//        list.add(483l);
//        list.add(81463l);


        list.add(46462l);
        list.add(4655l);
        list.add(3330l);
        list.add(18954l);
        list.add(8562l);
        list.add(46462l);
        list.add(2215l);
        list.add(3695l);

        list.add(4655l);
        list.add(3330l);
        list.add(18954l);
        list.add(8562l);
        list.add(2215l);
        list.add(3695l);

        list.add(4655l);
        list.add(3330l);
        list.add(18954l);
        list.add(8562l);
        list.add(2215l);
        list.add(3695l);

        list.add(4655l);
        list.add(3330l);
        list.add(18954l);
        list.add(8562l);
        list.add(2215l);
        list.add(3695l);

        list.add(4655l);
        list.add(3330l);
        list.add(18954l);
        list.add(2215l);
        list.add(3695l);
        list.add(3695l);
        mCurveChart.setLitData(list);
    }
}
