package com.ex.ranaranvijaysingh.testingdemo.views.interfaces;

public interface MainView {

    void showInvalidEmailMessage();

    void showInvalidPasswordMessage();

    void showProgressDialog(boolean showProgressDialog);

    void onResponseReceived(String success);

    void onErrorReceived(String error);
}
