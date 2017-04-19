package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.views.adapters.viewholders.DummyViewHolder;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToHolder;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by on 17/04/17.
 * Purpose of this class is to
 */
@RunWith(AndroidJUnit4.class)
public class RecyclerViewDemoActivityTest {

    @Rule
    public ActivityTestRule<RecyclerViewDemoActivity> mActivityTestRule =
            new ActivityTestRule<RecyclerViewDemoActivity>(RecyclerViewDemoActivity.class);

    @Test
    public void testOnClickForVisibleItem() throws Exception {
        //Click on any item in recycler view
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));

        //Check of toast message to pop up
        onView(withText("Clicked"))
                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testScrollAndClickOnBelowItems() throws Exception {
        //Scroll to item position
        onView(withId(R.id.recyclerView))
                .perform(scrollToHolder(new DummyViewHolderMatcher()).atPosition(9));

        //Click on any item in recycler view
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(9, click()));

        //Check of toast message to pop up
        onView(withText("Clicked"))
                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    private static class DummyViewHolderMatcher extends TypeSafeMatcher<RecyclerView.ViewHolder> {
        private Matcher<View> itemMatcher = any(View.class);

        public DummyViewHolderMatcher() {
        }

        public DummyViewHolderMatcher(Matcher<View> itemMatcher) {
            this.itemMatcher = itemMatcher;
        }

        @Override
        public boolean matchesSafely(RecyclerView.ViewHolder viewHolder) {
            return DummyViewHolder.class.isAssignableFrom(viewHolder.getClass())
                    && itemMatcher.matches(viewHolder.itemView);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("is assignable from CustomViewHolder");
        }
    }
}