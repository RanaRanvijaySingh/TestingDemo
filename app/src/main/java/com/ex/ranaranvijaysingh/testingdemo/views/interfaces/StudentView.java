package com.ex.ranaranvijaysingh.testingdemo.views.interfaces;

import com.ex.ranaranvijaysingh.testingdemo.models.UserResponse;

import java.util.List;

/**
 * Created by on 14/04/17.
 * Purpose of this class is to
 */

public interface StudentView {
    void setStudentList(List<UserResponse> studentList);

    void showClickedItem(String userName);
}
