package com.leafmi.mi.androiddemo.activity.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.bean.network.FunVideo;
import com.leafmi.mi.androiddemo.utils.network.RetrofitHelper;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class RetorfitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorfit);

        getFunVideoData();
    }

    private void getFunVideoData() {
        RetrofitHelper.getDaniudFunVideoApi()
                .getFunnyVideoCall(1, 100)
               .flatMap(new Func1<FunVideo, Observable<FunVideo.ResultsBean>>() {
                   @Override
                   public Observable<FunVideo.ResultsBean> call(FunVideo funVideo) {
                       return Observable.from(funVideo.getResults());
                   }
               })

                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe();

//        RetrofitHelper.getDaniudFunVideoApi()
//                .getFunnyVideoCall(1, 100)
//                .enqueue(new Callback<FunVideo>() {
//                    @Override
//                    public void onResponse(Call<FunVideo> call, Response<FunVideo> response) {
//                        List<FunVideo.ResultsBean> results = response.body().getResults();
//                        int size = results.size();
//                        for (int i = 0; i < size; i++) {
//                            FunVideo.ResultsBean resultsBean = results.get(i);
//                            Log.d("TAG", resultsBean.getDesc());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<FunVideo> call, Throwable t) {
//
//                    }
//                });
    }
}
