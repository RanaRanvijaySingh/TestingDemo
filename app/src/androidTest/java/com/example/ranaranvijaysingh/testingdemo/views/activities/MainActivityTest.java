package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by on 11/04/17.
 * Purpose of this class is to
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);
    private Context mContect;

    @Before
    public void setUp() {
        mContect = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void loginFlowTest() throws Exception {
        //Enter values in edit field
        Espresso.onView(ViewMatchers.withId(R.id.editTextEmailAddress))
                .perform(ViewActions.typeText("rana@gmail.com"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword))
                .perform(ViewActions.typeText("poiuytrewq"));

        //Close soft keywboard
        Espresso.closeSoftKeyboard();

        //Click on login button
        Espresso.onView(ViewMatchers.withId(R.id.buttonLogin))
                .perform(ViewActions.click());

        //Check if the toast message is poped up
        Espresso.onView(ViewMatchers.withText(Constants.DummyData.SUCCESS))
                .inRoot(withDecorView(not(
                        is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

        //Check if the response is displayed on the text view
        Espresso.onView(ViewMatchers.withId(R.id.textViewResponse))
                .check(ViewAssertions.matches(withText(Constants.DummyData.SUCCESS)));
    }

    @Test
    public void loginFlowTestForInvalidEmail() throws Exception {
        //Enter values in edit field
        Espresso.onView(ViewMatchers.withId(R.id.editTextEmailAddress))
                .perform(ViewActions.typeText("rana@"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword))
                .perform(ViewActions.typeText("poiuytrewq"));

        //Close soft keywboard
        Espresso.closeSoftKeyboard();

        //Click on login button
        Espresso.onView(ViewMatchers.withId(R.id.buttonLogin))
                .perform(ViewActions.click());

        //Check if the toast message is poped up
        Espresso.onView(ViewMatchers.withText(Constants.DummyData.INVALID_EMAIL))
                .inRoot(withDecorView(not(
                        is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

        //Check if the response is displayed on the text view
        Espresso.onView(ViewMatchers.withId(R.id.textViewResponse))
                .check(ViewAssertions.matches(withText(Constants.StringValues.BLANK)));
    }

    @Test
    public void loginFlowTestForInvalidPassword() throws Exception {
        //Enter values in edit field
        Espresso.onView(ViewMatchers.withId(R.id.editTextEmailAddress))
                .perform(ViewActions.typeText("rana@gmail.com"));
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword))
                .perform(ViewActions.typeText(""));

        //Close soft keywboard
        Espresso.closeSoftKeyboard();

        //Click on login button
        Espresso.onView(ViewMatchers.withId(R.id.buttonLogin))
                .perform(ViewActions.click());

        //Check if the toast message is poped up
        Espresso.onView(ViewMatchers.withText(Constants.DummyData.INVALID_PASSWORD))
                .inRoot(withDecorView(not(
                        is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

        //Check if the response is displayed on the text view
        Espresso.onView(ViewMatchers.withId(R.id.textViewResponse))
                .check(ViewAssertions.matches(withText(Constants.StringValues.BLANK)));
    }
}