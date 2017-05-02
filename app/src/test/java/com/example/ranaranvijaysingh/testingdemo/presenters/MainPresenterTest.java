package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.Student;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by on 14/02/17.
 * Purpose of this class is to
 */

public class MainPresenterTest {
    MainPresenter mMainPresenter;
    @Mock
    MainView mMainView;

    Student mStudent;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainPresenter = new MainPresenter(mMainView);
    }

    @Test
    public void getStudentTest() {
        mStudent = mMainPresenter.getStudentData();
        assertEquals(Constants.DummyData.FIRST_NAME, mStudent.getFirstName());
    }

    @Test
    public void presentFullNameTest() {
        mMainPresenter.presentFullName();
        verify(mMainView).setFullName("First Second Last");
    }

    @Test
    public void onClickEmailCheckButtonTest() throws Exception {
        when(mMainView.getEmailAddress()).thenReturn("a@a.com");
        mMainPresenter.onClickEmailCheckButton();
        verify(mMainView).showValidEmailMessage(true);
    }
}
