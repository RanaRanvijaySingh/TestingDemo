package com.example.ranaranvijaysingh.testingdemo.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ranaranvijaysingh.testingdemo.R;
import com.example.ranaranvijaysingh.testingdemo.adapters.StudentAdapter;
import com.example.ranaranvijaysingh.testingdemo.dummydata.DummyDataGenerator;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.ranaranvijaysingh.testingdemo.R.id.listViewStudent;

/**
 * Created by on 14/04/17.
 * Purpose of this class is to
 */

class StudentActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(listViewStudent)
    ListView mListViewStudent;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        ButterKnife.bind(this);
        initializeToolBar();
        initializeListView();
    }

    private void initializeToolBar() {
        setSupportActionBar(mToolbar);
    }

    private void initializeListView() {
        final StudentAdapter studentAdapter = new StudentAdapter(this,
                DummyDataGenerator.getResponseList());
        mListViewStudent.setAdapter(studentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionAdd:
                addNewItemInList();
                return true;
            case R.id.actionDetail:
                Toast.makeText(this, Constants.MenuItems.DETAIL, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionDescription:
                Toast.makeText(this, Constants.MenuItems.DESCRIPTION, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionHelp:
                Toast.makeText(this, Constants.MenuItems.HELP, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addNewItemInList() {

    }
}
