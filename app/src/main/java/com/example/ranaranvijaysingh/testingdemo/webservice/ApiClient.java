package com.example.ranaranvijaysingh.testingdemo.webservice;

import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by on 15/02/17.
 * Purpose of this class is to
 */

public class ApiClient {

    private static Retrofit sRetrofit;
    public static Retrofit getInstance() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.Urls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
