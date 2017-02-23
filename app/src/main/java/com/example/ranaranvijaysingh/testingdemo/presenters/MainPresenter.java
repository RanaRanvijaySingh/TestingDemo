package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.ApiBridges;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;
import com.example.ranaranvijaysingh.testingdemo.webservice.WebService;

import java.util.List;

public class MainPresenter {
    private final MainView mMainView;
    private WebService mWebService;

    public void setWebService(final WebService mWebService) {
        this.mWebService = mWebService;
    }

    public MainPresenter(final MainView mainView) {
        this.mMainView = mainView;
        mWebService = new WebService();
    }

    public void presentDataFromApi() {
        mMainView.showProgressDialog(true);
        mWebService.makeUserListApiCall(new ApiBridges.OnGetUserListApiCall() {
            @Override
            public void onSuccess(final List<UserResponse> userResponseList) {
                mMainView.onResponseReceived(Constants.DummyData.SUCCESS);
                mMainView.showProgressDialog(false);
            }

            @Override
            public void onError(final String message) {
                mMainView.onErrorReceived(Constants.DummyData.ERROR);
                mMainView.showProgressDialog(false);
            }
        });
    }
}
