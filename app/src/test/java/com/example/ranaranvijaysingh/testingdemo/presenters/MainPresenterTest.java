package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import static org.mockito.Mockito.verify;

/**
 * Created by on 14/02/17.
 * Purpose of this class is to
 */
public class MainPresenterTest {

    @Mock
    private MainView mMockMainView;
    @Mock
    private Call<List<UserResponse>> mUserResponseCall;
    @InjectMocks
    private MainPresenter mMainPresenter;
    @Captor
    private ArgumentCaptor<Callback<List<UserResponse>>> mArgumentCaptorUserResponse;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void presentDataFromApiTest() throws Exception {
        mMainPresenter.setUserResponseCall(mUserResponseCall);
        mMainPresenter.presentDataFromApi();
        verify(mMockMainView).showProgressDialog(true);
        verify(mUserResponseCall).enqueue(mArgumentCaptorUserResponse.capture());
//        verify(mMockMainView).onResponseReceived(Constants.DummyData.SUCCESS);
//        verify(mMockMainView).showProgressDialog(false);
    }
}
