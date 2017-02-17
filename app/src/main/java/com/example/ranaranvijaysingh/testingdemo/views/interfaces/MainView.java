package com.example.ranaranvijaysingh.testingdemo.views.interfaces;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;

import java.util.List;

public interface MainView {
    void setFullName(String fullName);

    void onResponseReceived(String response);

    void onErrorReceived(String message);

    void showProgressDialog(boolean enableProgressDialog);

    String getEmailAddress();

    void showValidEmailMessage(boolean isEmailValid);
}
