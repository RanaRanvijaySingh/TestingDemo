package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.Student;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;
import com.example.ranaranvijaysingh.testingdemo.viewmodels.StudentViewModel;

public class MainPresenter {
    private final MainView mainView;
    private Student student;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void presentFullName() {
        Student student = getStudentData();
        StudentViewModel studentViewModel = new StudentViewModel(student);
        mainView.setFullName(studentViewModel.getFullName());
    }

    /**
     * Dummy function to create some data.
     * @return @{@link Student}
     */
    public Student getStudentData() {
        Student student = new Student();
        student.setFirstName("First");
        student.setMidName("Middle");
        student.setLastName("Last");
        return student;
    }
}
