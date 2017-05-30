package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import tools.fastlane.screengrab.Screengrab;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

/**
 * Created by on 14/04/17.
 * Purpose of this class is to
 */
@RunWith(AndroidJUnit4.class)
public class StudentActivityTest {

    @Rule
    public ActivityTestRule<StudentActivity> mActivityTestRule =
            new ActivityTestRule<>(StudentActivity.class);
    private Context mContect;

    @Before
    public void setUp() throws Exception {
        Intents.init();
        mContect = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void testClickOnPlusIconOnActionBar() throws Exception {
        //Get current list from adapter
        final List<UserResponse> userResponseList = mActivityTestRule.getActivity()
                .getStudentAdapter().getList();
        final int previousListSize = userResponseList.size();
        //Click on toolbar
        onView(withId(R.id.toolbar))
                .perform(click());

        //Click on add icon
        onView(withId(R.id.actionAdd))
                .perform(click());

        //Check if the toast message was shown or not.
        /*onView(ViewMatchers.withText(Constants.DummyData.NEW_ITEM_ADDED))
                .inRoot(withDecorView(not(
                        is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));*/

        //Assert on the adapter list size - The list size should increase with one.
        assertEquals((previousListSize + 1),
                mActivityTestRule.getActivity().getStudentAdapter().getList().size());
        Screengrab.screenshot("testClickOnPlusIconOnActionBar");

    }
/*
    @Test
    public void testClickOnDescriptionOptionOnActionBar() throws Exception {
        //Click on toolbar
        onView(withId(R.id.toolbar))
                .perform(click());

        // Open the overflow menu OR open the options menu,
        // depending on if the device has a hardware or software overflow menu button.
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click on add icon
        onView(withText(Constants.MenuItems.DESCRIPTION))
                .perform(click());

        //Check if the toast message was shown or not.
        onView(ViewMatchers.withText(Constants.MenuItems.DESCRIPTION))
                .inRoot(withDecorView(not(
                        is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }*/

    @Test
    public void testClickOnDetailOptionOnActionBar() throws Exception {
        //Click on toolbar
        onView(withId(R.id.toolbar))
                .perform(click());

        // Open the overflow menu OR open the options menu,
        // depending on if the device has a hardware or software overflow menu button.
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click on add icon
        onView(withText(Constants.MenuItems.DETAIL))
                .perform(click());

        //Check if the toast message was shown or not.
        /*onView(ViewMatchers.withText(Constants.MenuItems.DETAIL))
                .inRoot(withDecorView(not(
                        is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));*/
        Screengrab.screenshot("testClickOnDetailOptionOnActionBar");

    }

    @Test
    public void testClickOnHelpOptionOnActionBar() throws Exception {
        //Click on toolbar
        onView(withId(R.id.toolbar))
                .perform(click());

        // Open the overflow menu OR open the options menu,
        // depending on if the device has a hardware or software overflow menu button.
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        //Click on add icon
        onView(withText(Constants.MenuItems.HELP))
                .perform(click());

        //Check if the toast message was shown or not.
        /*onView(ViewMatchers.withText(mContect.getResources().getString(R.string.action_help)))
                .inRoot(withDecorView(not(
                        is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));*/
        Screengrab.screenshot("testClickOnHelpOptionOnActionBar");

    }

   /* @Test
    public void listItemClickTest() throws Exception {
        //Perform a click on the list item who as name as "Ervin Howell" and email as "Shanna@melissa.tv"
        onView(allOf(withText("Ervin Howell"), hasSibling(withText("Shanna@melissa.tv"))))
                .perform(click());

        //Check if the toast message was shown or not.
        onView(ViewMatchers.withText("Ervin Howell"))
                .inRoot(withDecorView(not(
                        is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }*/

    @Test
    public void testViewNotPresentInList() throws Exception {
        onView(allOf(withId(R.id.textViewPhone), hasSibling(withText("Karley_Dach@jasper.info"))))
                .check(matches(not(isDisplayed())));
    }

    @After
    public void tearDown() throws Exception {
        Intents.release();
    }
}