package com.example.ranaranvijaysingh.testingdemo.presenters;

import android.text.TextUtils;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.utilities.ValidationUtil;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiClient;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private final MainView mMainView;
    private Call<List<UserResponse>> mCallListUserResponse;

    void setUserResponseCall(final Call<List<UserResponse>> userResponse) {
        mCallListUserResponse = userResponse;
    }

    public MainPresenter(final MainView mainView) {
        this.mMainView = mainView;
        final ApiInterface apiInterface = ApiClient.getInstance().create(ApiInterface.class);
        mCallListUserResponse = apiInterface.getUsers();
    }

    private boolean isValidEmail(final String emailAddress) {
        return emailAddress != null
                && !emailAddress.isEmpty()
                && ValidationUtil.isValidEmailAddress(emailAddress);
    }

    public void verifyLoginCredentials(final String email, final String password) {
        if (TextUtils.isEmpty(email) || !isValidEmail(email)) {
            mMainView.showInvalidEmailMessage();
        } else if (TextUtils.isEmpty(password)) {
            mMainView.showInvalidPasswordMessage();
        } else {
            verifyLoginFromServer();
        }
    }

    private void verifyLoginFromServer() {
        mMainView.showProgressDialog(true);
        mCallListUserResponse.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(final Call<List<UserResponse>> call,
                                   final Response<List<UserResponse>> response) {
                mMainView.onResponseReceived(Constants.DummyData.SUCCESS);
                mMainView.showProgressDialog(false);
            }

            @Override
            public void onFailure(final Call<List<UserResponse>> call, final Throwable t) {
                mMainView.onErrorReceived(Constants.DummyData.ERROR);
                mMainView.showProgressDialog(false);
            }
        });
    }
}
