package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.presenters.MainPresenter;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.editTextEmailAddress)
    EditText mEditTextEmailAddress;
    @BindView(R.id.editTextPassword)
    EditText mEditTextPassword;
    @BindView(R.id.buttonLogin)
    Button mButtonLogin;
    @BindView(R.id.progressBarLoading)
    ProgressBar mProgressBarLoading;
    @BindView(R.id.textViewResponse)
    TextView mTextViewResponse;

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
    }

    @OnClick(R.id.buttonLogin)
    public void onLoginButtonClick(final View view) {
        mMainPresenter.verifyLoginCredentials(
                mEditTextEmailAddress.getText().toString(),
                mEditTextPassword.getText().toString());
    }

    @OnClick(R.id.buttonSpinnerExample)
    public void onSpinnerButtonClick(final View view) {
        startActivity(new Intent(this, SpinnerDemoActivity.class));
    }

    @Override
    public void showInvalidEmailMessage() {
        Toast.makeText(this, Constants.DummyData.INVALID_EMAIL, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInvalidPasswordMessage() {
        Toast.makeText(this, Constants.DummyData.INVALID_PASSWORD, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog(final boolean showProgressDialog) {
        mProgressBarLoading.setVisibility(showProgressDialog ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onResponseReceived(final String success) {
        Toast.makeText(this, success, Toast.LENGTH_SHORT).show();
        mTextViewResponse.setText(success);
    }

    @Override
    public void onErrorReceived(final String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        mTextViewResponse.setText(error);
    }
}
