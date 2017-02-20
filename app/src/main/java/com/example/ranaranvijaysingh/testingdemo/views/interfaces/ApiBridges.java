package com.example.ranaranvijaysingh.testingdemo.views.interfaces;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;

import java.util.List;

/**
 * Created by on 20/02/17.
 * Purpose of this class is to
 */

public interface ApiBridges {
    public interface OnGetUserListApiCall {
        void onSuccess(List<UserResponse> userResponseList);

        void onError(String message);
    }
}
