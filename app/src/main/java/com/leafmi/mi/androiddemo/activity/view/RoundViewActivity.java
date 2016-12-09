package com.leafmi.mi.androiddemo.activity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.view.RoundView;

public class RoundViewActivity extends AppCompatActivity {

    private SeekBar seekBarRound, seekBarTopLeft, seekBarTopRight, seekBarBottomLeft, seekBarBottomRight;
    private RoundView mRoundView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_view);
        initView();
        initData();
        listener();
    }

    private void initView() {
        mRoundView = (RoundView) findViewById(R.id.roundView);
        seekBarRound = (SeekBar) findViewById(R.id.seekBar_round);
        seekBarTopLeft = (SeekBar) findViewById(R.id.seekBar_topLeft);
        seekBarTopRight = (SeekBar) findViewById(R.id.seekBar_topRight);
        seekBarBottomLeft = (SeekBar) findViewById(R.id.seekBar_bottomLeft);
        seekBarBottomRight = (SeekBar) findViewById(R.id.seekBar_bottomRight);
    }

    private void initData() {
        mRoundView.post(new Runnable() {
            @Override
            public void run() {
                int seekBarMaxValue = mRoundView.getMeasuredHeight() / 2;
                seekBarRound.setMax(seekBarMaxValue);
                seekBarTopLeft.setMax(seekBarMaxValue);
                seekBarTopRight.setMax(seekBarMaxValue);
                seekBarBottomLeft.setMax(seekBarMaxValue);
                seekBarBottomRight.setMax(seekBarMaxValue);
            }
        });
    }

    private void listener() {
        seekBarRound.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRoundView.setRound(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarTopLeft.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRoundView.setTopLeftRound(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarTopRight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRoundView.setTopRightRound(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarBottomLeft.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRoundView.setBottomLeftRound(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarBottomRight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRoundView.setBottomRightRound(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
