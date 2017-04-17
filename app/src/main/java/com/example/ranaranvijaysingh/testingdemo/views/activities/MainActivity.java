package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.test.espresso.idling.CountingIdlingResource;
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

    private static final long ONE_SECOND_DELAY = 1000;
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
    @BindView(R.id.textViewCounter)
    TextView mTextViewCounter;

    private MainPresenter mMainPresenter;
    private final CountingIdlingResource mIdlingResource = new CountingIdlingResource("toast");
    private int mCounter = 0;

    public CountingIdlingResource getIdlingResource() {
        return mIdlingResource;
    }

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
        final Intent intent = new Intent(this, SpinnerDemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonListView)
    public void onListViewButtonClick(final View view) {
        final Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.buttonRecyclerView)
    public void onRecyclerViewButtonClick(final View view) {
        final Intent intent = new Intent(this, RecyclerViewDemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonStartCounter)
    public void onStartCounterButtonClick(final View view) {
        Toast.makeText(this, R.string.toast_counter_started, Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        mIdlingResource.increment();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTextViewCounter.setText(String.valueOf(mCounter++));
                if (mCounter > 10) {
                    handler.removeCallbacks(this);
                    Toast.makeText(MainActivity.this, R.string.toast_counter_end,
                            Toast.LENGTH_SHORT).show();
                } else {
                    handler.postDelayed(this, ONE_SECOND_DELAY);
                    mIdlingResource.increment();
                }
                mIdlingResource.decrement();
            }
        }, ONE_SECOND_DELAY);
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
