package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.StudentView;

import java.util.ArrayList;
import java.util.List;

import static com.example.ranaranvijaysingh.testingdemo.dummydata.DummyDataGenerator.getResponseList;

/**
 * Created by on 14/04/17.
 * Purpose of this class is to
 */

public class StudentPresenter {
    private final StudentView mStudentView;
    private List<UserResponse> mStudentList = new ArrayList<>();
    private int mClickCount = 0;

    public StudentPresenter(final StudentView studentView) {
        this.mStudentView = studentView;
    }

    public void presentStudentList() {
        mStudentList = getStudentList();
        mStudentView.setStudentList(mStudentList);
    }

    private List<UserResponse> getStudentList() {
        final List<UserResponse> userResponses = new ArrayList<>();
        for (final UserResponse userResponse : getResponseList()) {
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    public void presentNewItemInList() {
        mStudentList.add(getNewStudent());
        mStudentView.setStudentList(mStudentList);
    }

    private UserResponse getNewStudent() {
        UserResponse userResponse = new UserResponse();
        userResponse.setName("New User " + mClickCount);
        userResponse.setEmail("New email " + mClickCount);
        userResponse.setPhone("" + mClickCount);
        mClickCount++;
        return userResponse;
    }

    public void presentClickedItem(final int position) {
        mStudentView.showClickedItem(mStudentList.get(position).getName());
    }
}
