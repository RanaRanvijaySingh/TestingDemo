package com.example.ranaranvijaysingh.testingdemo.views.interfaces;

public interface MainView {

    void onResponseReceived(String response);

    void onErrorReceived(String message);

    void showProgressDialog(boolean enableProgressDialog);
}
