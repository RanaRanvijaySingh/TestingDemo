package com.example.ranaranvijaysingh.testingdemo.presenters;

import com.example.ranaranvijaysingh.testingdemo.models.Student;
import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.utilities.ValidationUtil;
import com.example.ranaranvijaysingh.testingdemo.viewmodels.StudentViewModel;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.ApiCall;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.MainView;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.UserCallback;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiClient;
import com.example.ranaranvijaysingh.testingdemo.webservice.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private final MainView mMainView;
    private final Call<List<UserResponse>> mCallListUserResponse;

    public MainPresenter(final MainView mainView) {
        this.mMainView = mainView;
        final ApiInterface apiInterface = ApiClient.getInstance().create(ApiInterface.class);
        mCallListUserResponse = apiInterface.getUsers();
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
/*
    public void presentDataFromApi() {
        ApiClient.getInstance().getUsers(new Subscriber<List<UserResponse>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(final Throwable e) {
                mMainView.onResponseReceived(Constants.DummyData.ERROR);
            }

            @Override
            public void onNext(final List<UserResponse> userResponses) {
                mMainView.onResponseReceived(Constants.DummyData.SUCCESS);
            }
        });
    }*/

    public void presentDataFromApi() {
        mMainView.showProgressDialog(true);
        mCallListUserResponse.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(final Call<List<UserResponse>> call,
                                   final Response<List<UserResponse>> response) {
                mMainView.onResponseReceived(Constants.DummyData.SUCCESS);
                mMainView.showProgressDialog(false);
            }

            @Override
            public void onFailure(final Call<List<UserResponse>> call, final Throwable t) {
                mMainView.onErrorReceived(Constants.DummyData.ERROR);
                mMainView.showProgressDialog(false);
            }
        });
    }

    /*public void presentDataFromApi() {
        mMainView.showProgressDialog(true);
        EspressoIdlingResource.increment(); // App is busy until further notice
        mApiCall.getUsers(new UserCallback() {
            @Override
            public void onResponse(final List<UserResponse> response) {
                mMainView.onResponseReceived(Constants.DummyData.SUCCESS);
                mMainView.showProgressDialog(false);
            }

            @Override
            public void onFailure(final String message) {
                mMainView.onErrorReceived(Constants.DummyData.ERROR);
                mMainView.showProgressDialog(false);
            }
        });
    }*/

    public void onClickEmailCheckButton() {
        mMainView.showValidEmailMessage(isValidEmail(mMainView.getEmailAddress()));
    }

    private boolean isValidEmail(final String emailAddress) {
        return !emailAddress.isEmpty()
                && ValidationUtil.isValidEmailAddress(emailAddress);
    }

    private final ApiCall mApiCall = new ApiCall() {
        @Override
        public void getUsers(final UserCallback callback) {
            final ApiInterface mApiService = ApiClient.getInstance().create(ApiInterface.class);
            final Call<List<UserResponse>> userResponseCall = mApiService.getUsers();
            userResponseCall.enqueue(new Callback<List<UserResponse>>() {
                @Override
                public void onResponse(final Call<List<UserResponse>> call,
                                       final Response<List<UserResponse>> response) {
                    callback.onResponse(response.body());
                }

                @Override
                public void onFailure(final Call<List<UserResponse>> call, final Throwable t) {
                    callback.onFailure(t.getMessage());
                }
            });
        }
    };
}
