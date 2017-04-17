package com.example.ranaranvijaysingh.testingdemo.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.views.adapters.viewholders.DummyViewHolder;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.DummyItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 17/04/17.
 * Purpose of this class is to
 */

public class DummyAdapter extends RecyclerView.Adapter<DummyViewHolder> {

    private List<UserResponse> mList = new ArrayList<>();
    private DummyItemClickListener mDummyItemClickListener;

    @Override
    public DummyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final DummyViewHolder dummyViewHolder = new DummyViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.list_item_student, null));
        dummyViewHolder.setOnDummyItemClickListener(mDummyItemClickListener);
        return dummyViewHolder;
    }

    @Override
    public void onBindViewHolder(final DummyViewHolder holder, final int position) {
        holder.getTextViewEmail().setText(mList.get(position).getEmail());
        holder.getTextViewPhone().setText(mList.get(position).getPhone());
        holder.getTextViewName().setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(final List<UserResponse> responseList) {
        this.mList = responseList;
    }

    public void setOnDummyItemClickListener(final DummyItemClickListener onItemClickListener) {
        this.mDummyItemClickListener = onItemClickListener;
    }
}
