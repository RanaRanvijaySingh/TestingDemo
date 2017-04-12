package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ranaranvijaysingh.testingdemo.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by on 12/04/17.
 * Purpose of this class is to
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerDemoActivityTest {

    @Rule
    public final ActivityTestRule<SpinnerDemoActivity> mActivityTestRule =
            new ActivityTestRule<SpinnerDemoActivity>(SpinnerDemoActivity.class);

    @Test
    public void testSpinnerViewBehaviour() throws Exception {
        //Click on the spinner
        onView(withId(R.id.spinnerCars))
                .perform(click());

        //Select any item
        Espresso.onData(Matchers.allOf(Matchers.is(Matchers.instanceOf(String.class)),
                Matchers.is("Spinner item - 21")))
                .perform(click());

        //Verify the data is set in spinner
        onView(withId(R.id.spinnerCars))
                .check(matches(withSpinnerText(containsString("Spinner item - 21"))));

        //Verify textview data
        onView(withId(R.id.textViewSpinnerSelection))
                .check(matches(withText("Spinner item - 21")));
    }
}