package com.ex.ranaranvijaysingh.testingdemo.webservice;

import com.ex.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.ex.ranaranvijaysingh.testingdemo.utilities.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by on 15/02/17.
 * Purpose of this class is to
 */

public interface ApiInterface {
    @GET(Constants.Urls.USERS)
//    Observable<List<UserResponse>> getUsers();
    Call<List<UserResponse>> getUsers();
}
