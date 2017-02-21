package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.Student;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.utilities.ValidationUtil;
import com.example.ranaranvijaysingh.testingdemo.viewmodels.StudentViewModel;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiClient;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiInterface;

public class MainPresenter {
    private final MainView mMainView;

    public MainPresenter(final MainView mainView) {
        this.mMainView = mainView;
        final ApiInterface apiInterface = ApiClient.getInstance().create(ApiInterface.class);
    }

    public void presentFullName() {
        final Student student = getStudentData();
        final StudentViewModel studentViewModel = new StudentViewModel(student);
        mMainView.setFullName(studentViewModel.getFullName());
    }

    /**
     * Dummy function to create some data.
     *
     * @return @{@link Student}
     */
    public Student getStudentData() {
        final Student student = new Student();
        student.setFirstName(Constants.DummyData.FIRST_NAME);
        student.setMidName(Constants.DummyData.MIDDLE_NAME);
        student.setLastName(Constants.DummyData.LAST_NAME);
        return student;
    }

    public void onClickEmailCheckButton() {
        mMainView.showValidEmailMessage(isValidEmail(mMainView.getEmailAddress()));
    }

    private boolean isValidEmail(final String emailAddress) {
        return emailAddress != null
                && !emailAddress.isEmpty()
                && ValidationUtil.isValidEmailAddress(emailAddress);
    }
}
