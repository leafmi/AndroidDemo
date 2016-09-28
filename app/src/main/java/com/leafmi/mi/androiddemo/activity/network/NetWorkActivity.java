package com.leafmi.mi.androiddemo.activity.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.bean.network.FunVideo;
import com.leafmi.mi.androiddemo.utils.network.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetWorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        getFunVideoData();
    }


    private void getFunVideoData() {
        RetrofitHelper.getDaniudFunVideoApi()
                .getFunnyVideoCall("1", "10")
                .enqueue(new Callback<List<FunVideo>>() {
                    @Override
                    public void onResponse(Call<List<FunVideo>> call, Response<List<FunVideo>> response) {
                        Gson gson = new Gson();
                        ArrayList<FunVideo> contributorsList = gson.fromJson(response.body().toString(), new TypeToken<List<FunVideo>>(){}.getType());
                    }

                    @Override
                    public void onFailure(Call<List<FunVideo>> call, Throwable t) {

                    }
                });
    }
}
