package com.example.parth.mvp_test.domain.inputhandler;

import android.util.Log;

import com.example.parth.mvp_test.domain.rest.RestAPIServices;
import com.example.parth.mvp_test.model.RestData;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Parth on 12-Nov-15.
 */

public class RestAPIInputHandler {

    public String getDataFromRest(){

        final RestData[] restDataResponse = new RestData[1];

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo4462252.mockable.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestAPIServices restAPIServices = retrofit.create(RestAPIServices.class);
        Call<RestData> restDataCallSession = restAPIServices.loadString();
        restDataCallSession.enqueue(new Callback<RestData>() {
            @Override
            public void onResponse(Response<RestData> response, Retrofit retrofit) {

                restDataResponse[0] = response.body();
                Log.i("Frequency", response.body().string_test);
                Log.i("Frequency", restDataResponse[0].string_test);

            }
            @Override
            public void onFailure(Throwable t) {
                Log.i("Frequency", t.getLocalizedMessage());
            }
        });

        return restDataResponse[0].string_test;
    }

}
