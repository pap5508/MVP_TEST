package com.example.parth.mvp_test.domain.rest;

import com.example.parth.mvp_test.model.RestData;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Parth on 12-Nov-15.
 */

public interface RestAPIServices {

    /**
     * loadString - get the String from the REST API with Path - /api/testmock after Base URL
     * @return
     */
    @GET("/api/testmock")
    Call<RestData> loadString();

}
