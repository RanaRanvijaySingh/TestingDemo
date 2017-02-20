package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.presenters.MainPresenter;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.textViewApiData)
    TextView mTextViewApiData;
    @BindView(R.id.progressBarLoading)
    ProgressBar mProgressBarLoading;

    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeComponents();
    }

    private void initializeComponents() {
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.presentDataFromApi();
    }

    @Override
    public void onResponseReceived(final String response) {
        mTextViewApiData.setText(response);
    }

    @Override
    public void onErrorReceived(final String message) {
        mTextViewApiData.setText(message);
    }

    @Override
    public void showProgressDialog(final boolean enableProgressDialog) {
        mProgressBarLoading.setVisibility(enableProgressDialog ? View.VISIBLE : View.GONE);
    }
}
