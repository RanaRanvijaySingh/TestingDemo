package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by on 14/02/17.
 * Purpose of this class is to
 */

public class MainPresenterTest {

    @Mock
    private MainView mockMainView;

    private MainPresenter mainPresenter;
    public static final String FULL_NAME = "First Middle Last";
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mockMainView);
    }

    @Test
    public void testPresentFullName() throws Exception {
        mainPresenter.presentFullName();
        Mockito.verify(mockMainView).setFullName(FULL_NAME);
    }
}
