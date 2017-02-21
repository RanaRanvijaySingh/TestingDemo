package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.presenters.MainPresenter;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.textViewFullName)
    TextView textViewFullName;
    @BindView(R.id.textViewApiData)
    TextView textViewApiData;
    @BindView(R.id.progressBarLoading)
    ProgressBar progressBarLoading;
    @BindView(R.id.editTextEmailAddress)
    EditText editTextEmailAddress;
    @BindView(R.id.buttonCheckEmail)
    Button buttonCheckEmail;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeComponents();
    }

    private void initializeComponents() {
        mainPresenter = new MainPresenter(this);
        mainPresenter.presentFullName();
    }

    @Override
    public void setFullName(String fullName) {
        textViewFullName.setText(fullName);
    }

    @Override
    public void onResponseReceived(String response) {
        textViewApiData.setText(response);
    }

    @Override
    public void onErrorReceived(String message) {
        textViewApiData.setText(message);
    }

    @Override
    public void showProgressDialog(boolean enableProgressDialog) {
        progressBarLoading.setVisibility(enableProgressDialog ? View.VISIBLE : View.GONE);
    }

    @OnClick(R.id.buttonCheckEmail)
    public void onClickEmailCheckButton(View view) {
        mainPresenter.onClickEmailCheckButton();
    }

    @Override
    public String getEmailAddress() {
        return editTextEmailAddress.getText().toString();
    }

    @Override
    public void showValidEmailMessage(boolean isEmailValid) {
        Toast.makeText(this, isEmailValid ? R.string.toast_valid_email :
                R.string.toast_invalid_email, Toast.LENGTH_SHORT).show();
    }
}
