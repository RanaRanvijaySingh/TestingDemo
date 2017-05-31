package com.ex.ranaranvijaysingh.testingdemo.webservice;

import com.ex.ranaranvijaysingh.testingdemo.utilities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by on 15/02/17.
 * Purpose of this class is to
 */

public class ApiClient {

    private static Retrofit sRetrofit;
    private static final ApiClient API_CLIENT = new ApiClient();
//    private final ApiInterface mApiInterface;

   /* private ApiClient() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.Urls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        this.mApiInterface = sRetrofit.create(ApiInterface.class);
    }*/

    public static Retrofit getInstance() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.Urls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

   /* public void getUsers(final Subscriber<List<UserResponse>> subscriber) {
        mApiInterface.getUsers()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }*/
}
