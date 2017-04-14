package com.example.ranaranvijaysingh.testingdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 14/04/17.
 * Purpose of this class is to
 */

public class StudentAdapter extends BaseAdapter {

    private List<UserResponse> mStudentList = new ArrayList<>();
    private final Context mContext;

    public StudentAdapter(final Context context, final List<UserResponse> responseList) {
        this.mContext = context;
        this.mStudentList = responseList;
    }

    @Override
    public int getCount() {
        return mStudentList != null ? mStudentList.size() : 0;
    }

    @Override
    public Object getItem(final int position) {
        return null;
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_student, null);
        final TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        final TextView textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        final TextView textViewPhone = (TextView) convertView.findViewById(R.id.textViewPhone);
        textViewName.setText(mStudentList.get(position).getName());
        textViewEmail.setText(mStudentList.get(position).getEmail());
        textViewPhone.setText(mStudentList.get(position).getPhone());
        return convertView;
    }
}
