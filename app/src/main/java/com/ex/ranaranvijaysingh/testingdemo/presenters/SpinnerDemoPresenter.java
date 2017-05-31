package com.ex.ranaranvijaysingh.testingdemo.presenters;

import com.ex.ranaranvijaysingh.testingdemo.views.interfaces.SpinnerDemoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 12/04/17.
 * Purpose of this class is to
 */

public class SpinnerDemoPresenter {
    private final SpinnerDemoView mSpinnerDemoView;

    public SpinnerDemoPresenter(final SpinnerDemoView spinnerDemoView) {
        this.mSpinnerDemoView = spinnerDemoView;
    }

    public void presentSpinnerData() {
        List<String> categories = new ArrayList<>();
        categories.add("Spinner item - 1");
        categories.add("Spinner item - 2");
        categories.add("Spinner item - 3");
        categories.add("Spinner item - 4");
        categories.add("Spinner item - 5");
        categories.add("Spinner item - 6");
        categories.add("Spinner item - 7");
        categories.add("Spinner item - 8");
        categories.add("Spinner item - 9");
        categories.add("Spinner item - 10");
        categories.add("Spinner item - 11");
        categories.add("Spinner item - 12");
        categories.add("Spinner item - 13");
        categories.add("Spinner item - 14");
        categories.add("Spinner item - 15");
        categories.add("Spinner item - 16");
        categories.add("Spinner item - 17");
        categories.add("Spinner item - 18");
        categories.add("Spinner item - 19");
        categories.add("Spinner item - 20");
        categories.add("Spinner item - 21");
        categories.add("Spinner item - 22");
        categories.add("Spinner item - 23");
        categories.add("Spinner item - 24");
        categories.add("Spinner item - 25");
        mSpinnerDemoView.setSpinnerData(categories);
        mSpinnerDemoView.setSpinnerItemList(categories);
    }
}
