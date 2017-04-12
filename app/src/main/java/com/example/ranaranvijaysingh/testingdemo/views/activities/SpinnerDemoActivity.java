package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.presenters.SpinnerDemoPresenter;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.SpinnerDemoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by on 12/04/17.
 * Purpose of this class is to
 */

public class SpinnerDemoActivity extends AppCompatActivity implements SpinnerDemoView {

    @BindView(R.id.spinnerCars)
    Spinner mSpinnerCars;
    @BindView(R.id.textViewSpinnerSelection)
    TextView mTextViewSpinnerSelection;

    private SpinnerDemoPresenter mSpinnerDemoPresenter;
    private List<String> mSpinnerItemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        ButterKnife.bind(this);
        mSpinnerDemoPresenter = new SpinnerDemoPresenter(this);
        mSpinnerDemoPresenter.presentSpinnerData();
    }

    private final AdapterView.OnItemSelectedListener mItemSelectedListener =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(final AdapterView<?> parent, final View view,
                                           final int position, final long id) {
                    mTextViewSpinnerSelection.setText(mSpinnerItemList.get(position));
                }

                @Override
                public void onNothingSelected(final AdapterView<?> parent) {

                }
            };

    @Override
    public void setSpinnerData(final List<String> stringList) {
        final ArrayAdapter<String> dataAdapter = new
                ArrayAdapter<String>(SpinnerDemoActivity.this, android.R.layout
                .simple_spinner_item, stringList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCars.setAdapter(dataAdapter);
        mSpinnerCars.setOnItemSelectedListener(mItemSelectedListener);
    }

    @Override
    public void setSpinnerItemList(final List<String> stringList) {
        mSpinnerItemList = stringList;
    }
}
