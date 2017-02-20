package com.example.ranaranvijaysingh.testingdemo.webservice;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.ApiBridges;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by on 20/02/17.
 * Purpose of this class is to
 */

public class WebService {

    private final ApiInterface mApiInterface;

    public WebService() {
        mApiInterface = ApiClient.getInstance().create(ApiInterface.class);
    }

    public void makeUserListApiCall(final ApiBridges.OnGetUserListApiCall onGetUserListApiCall) {
        final Call<List<UserResponse>> callListUserResponse = mApiInterface.getUsers();
        callListUserResponse.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(final Call<List<UserResponse>> call, final Response<List<UserResponse>> response) {
                onGetUserListApiCall.onSuccess(response.body());
            }

            @Override
            public void onFailure(final Call<List<UserResponse>> call, Throwable t) {
                onGetUserListApiCall.onError(t.getMessage());
            }
        });
    }
}
