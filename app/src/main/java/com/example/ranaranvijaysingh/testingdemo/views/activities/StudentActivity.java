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
import com.example.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.example.ranaranvijaysingh.testingdemo.presenters.StudentPresenter;
import com.example.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.example.ranaranvijaysingh.testingdemo.views.interfaces.StudentView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.ranaranvijaysingh.testingdemo.R.id.listViewStudent;

/**
 * Created by on 14/04/17.
 * Purpose of this class is to
 */

class StudentActivity extends AppCompatActivity implements StudentView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(listViewStudent)
    ListView mListViewStudent;
    private StudentPresenter mStudentPresenter;
    private StudentAdapter mStudentAdapter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        ButterKnife.bind(this);
        mStudentPresenter = new StudentPresenter(this);
        initializeToolBar();
        initializeListView();
        mStudentPresenter.presentStudentList();
    }

    private void initializeToolBar() {
        setSupportActionBar(mToolbar);
    }

    private void initializeListView() {
        mStudentAdapter = new StudentAdapter(this);
        mListViewStudent.setAdapter(mStudentAdapter);
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
                mStudentPresenter.presentNewItemInList();
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

    @Override
    public void setStudentList(final List<UserResponse> studentList) {
        mStudentAdapter.setList(studentList);
    }
}
