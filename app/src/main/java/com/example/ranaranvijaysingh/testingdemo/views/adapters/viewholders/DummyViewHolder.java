package com.example.ranaranvijaysingh.testingdemo.views.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.DummyItemClickListener;

/**
 * Created by on 17/04/17.
 * Purpose of this class is to
 */

public class DummyViewHolder extends RecyclerView.ViewHolder {
    final TextView textViewName;
    final TextView textViewEmail;
    final TextView textViewPhone;
    private DummyItemClickListener mOnDummyItemClickListener;

    public DummyViewHolder(final View itemView) {
        super(itemView);
        textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        textViewEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
        textViewPhone = (TextView) itemView.findViewById(R.id.textViewPhone);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnDummyItemClickListener.onItemClicked(v);
            }
        });
    }

    public TextView getTextViewName() {
        return textViewName;
    }

    public TextView getTextViewEmail() {
        return textViewEmail;
    }

    public TextView getTextViewPhone() {
        return textViewPhone;
    }

    public void setOnDummyItemClickListener(final DummyItemClickListener dummyItemClickListener) {
        this.mOnDummyItemClickListener = dummyItemClickListener;
    }
}
