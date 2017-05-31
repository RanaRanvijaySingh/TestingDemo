package com.ex.ranaranvijaysingh.testingdemo.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ex.ranaranvijaysingh.testingdemo.R;
import com.ex.ranaranvijaysingh.testingdemo.dummydata.DummyDataGenerator;
import com.ex.ranaranvijaysingh.testingdemo.views.adapters.DummyAdapter;
import com.ex.ranaranvijaysingh.testingdemo.views.interfaces.DummyItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.LinearLayoutManager.*;

/**
 * Created by on 17/04/17.
 * Purpose of this class is to
 */

public class RecyclerViewDemoActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        ButterKnife.bind(this);
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        final DummyAdapter dummyAdapter = new DummyAdapter();
        dummyAdapter.setList(DummyDataGenerator.getResponseList());
        dummyAdapter.setOnDummyItemClickListener(mDummyItemClickListener);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(dummyAdapter);
    }

    private final DummyItemClickListener mDummyItemClickListener = new DummyItemClickListener() {
        @Override
        public void onItemClicked(final View view) {
            Toast.makeText(RecyclerViewDemoActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
        }
    };
}
