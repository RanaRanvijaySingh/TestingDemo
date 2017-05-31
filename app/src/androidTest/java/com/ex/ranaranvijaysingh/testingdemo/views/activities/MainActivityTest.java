package com.ex.ranaranvijaysingh.testingdemo.views.activities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ex.ranaranvijaysingh.testingdemo.R;
import com.ex.ranaranvijaysingh.testingdemo.utilities.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
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
    private Context mContect;

    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @BeforeClass
    public static void beforeAll() {
        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());
    }

    @Before
    public void setUp() {
        Intents.init();
        mContect = InstrumentationRegistry.getTargetContext();
        Espresso.registerIdlingResources(mActivityRule.getActivity().getIdlingResource());
    }

    @Test
    public void loginFlowTest() throws Exception {
        //Enter values in edit field
        onView(ViewMatchers.withId(R.id.editTextEmailAddress))
                .perform(ViewActions.typeText("rana@gmail.com"));
        onView(ViewMatchers.withId(R.id.editTextPassword))
                .perform(ViewActions.typeText("poiuytrewq"));

        //Close soft keywboard
        Espresso.closeSoftKeyboard();

        //Click on login button
        onView(ViewMatchers.withId(R.id.buttonLogin))
                .perform(click());

        //Check if the toast message is poped up
        /*onView(ViewMatchers.withText(Constants.DummyData.SUCCESS))
                .inRoot(withDecorView(not(
                        is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));*/

        //Check if the response is displayed on the text view
        /*onView(ViewMatchers.withId(R.id.textViewResponse))
                .check(ViewAssertions.matches(withText(Constants.DummyData.SUCCESS)));*/
    }

    @Test
    public void loginFlowTestForInvalidEmail() throws Exception {
        //Enter values in edit field
        onView(ViewMatchers.withId(R.id.editTextEmailAddress))
                .perform(ViewActions.typeText("rana@"));
        onView(ViewMatchers.withId(R.id.editTextPassword))
                .perform(ViewActions.typeText("poiuytrewq"));

        //Close soft keywboard
        Espresso.closeSoftKeyboard();

        //Click on login button
        onView(ViewMatchers.withId(R.id.buttonLogin))
                .perform(click());

        //Check if the toast message is poped up
        onView(ViewMatchers.withText(Constants.DummyData.INVALID_EMAIL))
                .inRoot(withDecorView(not(
                        is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

        //Check if the response is displayed on the text view
        /*onView(ViewMatchers.withId(R.id.textViewResponse))
                .check(ViewAssertions.matches(withText(Constants.StringValues.BLANK)));*/
        Screengrab.screenshot("loginFlowTestForInvalidEmail");
    }

    @Test
    public void loginFlowTestForInvalidPassword() throws Exception {
        //Enter values in edit field
        onView(ViewMatchers.withId(R.id.editTextEmailAddress))
                .perform(ViewActions.typeText("rana@gmail.com"));
        onView(ViewMatchers.withId(R.id.editTextPassword))
                .perform(ViewActions.typeText(""));

        //Close soft keywboard
        Espresso.closeSoftKeyboard();

        //Click on login button
        onView(ViewMatchers.withId(R.id.buttonLogin))
                .perform(click());

        //Check if the toast message is poped up
       /* onView(ViewMatchers.withText(Constants.DummyData.INVALID_PASSWORD))
                .inRoot(withDecorView(not(
                        is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));*/

        //Check if the response is displayed on the text view
        onView(ViewMatchers.withId(R.id.textViewResponse))
                .check(ViewAssertions.matches(withText(Constants.StringValues.BLANK)));
        Screengrab.screenshot("loginFlowTestForInvalidPassword");
    }

    @Test
    public void newActivityLaunchTest() throws Exception {
        onView(withId(R.id.buttonSpinnerExample))
                .perform(click());
        intended(hasComponent("com.example.ranaranvijaysingh.testingdemo.views.activities" +
                ".SpinnerDemoActivity"));
        Screengrab.screenshot("newActivityLaunchTest");
    }

    @Test
    public void textCounterFunction() throws Exception {
        //Click on start counter button
        onView(withId(R.id.buttonStartCounter))
                .perform(click());

        //Check if the toast message is poped up
        onView(ViewMatchers.withText(mActivityRule.getActivity().getResources()
                .getString(R.string.toast_counter_end)))
                .inRoot(withDecorView(not(is
                        (mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
        Screengrab.screenshot("textCounterFunction");
    }

    @After
    public void tearDown() throws Exception {
        Intents.release();
        Espresso.unregisterIdlingResources(mActivityRule.getActivity().getIdlingResource());
    }
}