package com.ex.ranaranvijaysingh.testingdemo.views.interfaces;

import com.ex.ranaranvijaysingh.testingdemo.models.UserResponse;

import java.util.List;

/**
 * Created by on 17/02/17.
 * Purpose of this class is to
 */
public interface UserCallback {
    void onResponse(final List<UserResponse> response);

    void onFailure(final String message);
}
