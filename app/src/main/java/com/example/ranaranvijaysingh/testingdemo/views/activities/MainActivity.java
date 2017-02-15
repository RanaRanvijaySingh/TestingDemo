package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.presenters.MainPresenter;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.textViewFullName)
    TextView textViewFullName;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        mainPresenter.presentFullName();
    }

    @Override
    public void setFullName(String fullName) {
        textViewFullName.setText(fullName);
    }
}
