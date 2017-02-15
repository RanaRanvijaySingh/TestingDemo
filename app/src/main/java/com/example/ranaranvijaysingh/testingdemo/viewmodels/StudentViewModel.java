package com.example.ranaranvijaysingh.testingdemo.viewmodels;

import com.example.ranaranvijaysingh.testingdemo.models.Student;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;

/**
 * Created by on 14/02/17.
 * Purpose of this class is to
 */
public class StudentViewModel {
    private final Student mStudent;

    public StudentViewModel(Student student) {
        this.mStudent = student;
    }

    public String getFullName() {
        StringBuilder stringBuilderName = new StringBuilder();
        stringBuilderName
                .append(mStudent.getFirstName())
                .append(Constants.StringValues.SPACE)
                .append(mStudent.getMidName())
                .append(Constants.StringValues.SPACE)
                .append(mStudent.getLastName());
        return stringBuilderName.toString();
    }
}
