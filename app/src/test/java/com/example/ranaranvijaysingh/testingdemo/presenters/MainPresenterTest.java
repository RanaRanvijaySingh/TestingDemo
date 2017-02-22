package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.presenters.dummydata.DummyDataGenerator;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.ApiBridges;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;
import com.example.ranaranvijaysingh.testingdemo.webservice.WebService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by on 14/02/17.
 * Purpose of this class is to
 */

public class MainPresenterTest {

    @InjectMocks
    private MainPresenter mMainPresenter;
    @Mock
    private MainView mMockMainView;
    @Mock
    private WebService mMockWebService;
    @Mock
    private ApiBridges.OnGetUserListApiCall mOnGetUserListApiCall;
    @Captor
    private ArgumentCaptor<ApiBridges.OnGetUserListApiCall> mCaptor;
//    private WebService mMockWebService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
//        mMockWebService = new WebService();
    }

    @Test
    public void presentDataFromApiTest() throws Exception {
        mMainPresenter.presentDataFromApi();
        verify(mMockMainView).showProgressDialog(true);
        verify(mMockWebService).makeUserListApiCall(mCaptor.capture());
        mCaptor.getValue().onSuccess(DummyDataGenerator.getResponseList());
        verify(mMockMainView).onResponseReceived(Constants.DummyData.SUCCESS);
        verify(mMockMainView).showProgressDialog(false);
    }
}
