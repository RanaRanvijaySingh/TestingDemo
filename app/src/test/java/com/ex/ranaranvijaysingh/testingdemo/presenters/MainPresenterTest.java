package com.ex.ranaranvijaysingh.testingdemo.presenters;

import com.ex.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by on 14/02/17.
 * Purpose of this class is to
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    @Mock
    MainView mMainView;
    @InjectMocks
    MainPresenter mMainPresenter;

    @Before
    public void setUp() throws Exception {
        mMainPresenter = new MainPresenter(mMainView);
    }

    @Test
    public void isValidEmailTest() throws Exception {
        Assert.assertTrue(mMainPresenter.isValidEmail("hello@gmail.com"));
    }

    /**
     * public void verifyLoginCredentials(final String email, final String password)
     */
    @Test
    public void verifyLoginCredentialsTestForInvalidEmailId() throws Exception {
        mMainPresenter.verifyLoginCredentials("a@a", "password");
        verify(mMainView).showInvalidEmailMessage();
    }

    @Test
    public void verifyLoginCredentialsTestForInvalidPassword() throws Exception {
        mMainPresenter.verifyLoginCredentials("a@a.com", "");
        verify(mMainView).showInvalidPasswordMessage();
    }
}
