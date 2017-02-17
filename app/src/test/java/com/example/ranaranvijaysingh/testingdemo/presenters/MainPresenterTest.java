package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.ApiCall;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.UserCallback;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiClient;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiInterface;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import rx.Observable;
import rx.Subscriber;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by on 14/02/17.
 * Purpose of this class is to
 */

public class MainPresenterTest {

    private MainPresenter mMainPresenter;
    public static final String FULL_NAME = "First Middle Last";

    @Mock
    private MainView mMockMainView;
    @Mock
    private ApiInterface mMockApiInterface;
    @Mock
    private Call<List<UserResponse>> mMockListCall;
    @Mock
    private ApiCall mApiCall;
    @Mock
    private Call<List<UserResponse>> mUserResponseCall;
    @Captor
    private ArgumentCaptor<UserCallback> mArgumentCaptorUserCallback;
    @Captor
    private ArgumentCaptor<Subscriber<List<UserResponse>>> mArgumentCaptorSubscriber;
    @Captor
    private ArgumentCaptor<Callback<List<UserResponse>>> mArgumentCaptorUserResponse;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainPresenter = new MainPresenter(mMockMainView);
//        mApiCall = new ApiCall();
    }

    @Test
    public void presentFullNameTest() throws Exception {
        mMainPresenter.presentFullName();
        verify(mMockMainView).setFullName(FULL_NAME);
    }
/*
    @Test
    public void testLoginWithCorrectUserNameAndPassword() throws Exception {

        // create or mock response object
        when(ApiClient.getInstance().getUsers(mArgumentCaptorSubscriber.capture()).thenReturn(Observable
                .just(response));
        mMainPresenter.presentDataFromApi();
        verify(view).loginSuccess();
    }*/


    @Test
    public void presentDataFromApiTest() throws Exception {
        mMainPresenter.presentDataFromApi();
        verify(mMockMainView).showProgressDialog(true);
        verify(mUserResponseCall).enqueue(mArgumentCaptorUserResponse.capture());
        verify(mMockMainView).onResponseReceived(Constants.DummyData.SUCCESS);
        verify(mMockMainView).showProgressDialog(false);
    }

/*    @Test
    public void presentDataFromApiTest() throws Exception {
        final List<UserResponse> responseList = DummyDataGenerator.getResponseList();
        mMainPresenter.presentDataFromApi();
        verify(mMockMainView).showProgressDialog(true);

        verify(mApiCall).getUsers(mArgumentCaptorUserCallback.capture());
        mArgumentCaptorUserCallback.getValue().onResponse(responseList);

        Assert.assertEquals(10, responseList.size());

        verify(mMockMainView).onResponseReceived(Constants.DummyData.SUCCESS);
        verify(mMockMainView).showProgressDialog(false);
    }*/

   /* @Test
    public void presentDataFromApiTest() throws Exception {
        mMainPresenter.presentDataFromApi();
        verify(mApiCall).getUsers(mArgumentCaptorUserCallback.capture());

        final List<UserResponse> userResponses = DummyDataGenerator.getResponseList();
        mArgumentCaptorUserCallback.getValue().onResponse(userResponses);

        mMockMainView.onResponseReceived(Constants.DummyData.SUCCESS);
        mMockMainView.showProgressDialog(false);
    }*/

    @Test
    public void onClickEmailCheckButtonTest() throws Exception {
        when(mMockMainView.getEmailAddress()).thenReturn("");
        mMainPresenter.onClickEmailCheckButton();
        verify(mMockMainView).showValidEmailMessage(false);
    }

    @Test
    public void onClickEmailCheckButtonTest2() throws Exception {
        when(mMockMainView.getEmailAddress()).thenReturn("hello@h.com");
        mMainPresenter.onClickEmailCheckButton();
        verify(mMockMainView).showValidEmailMessage(true);
    }
}
