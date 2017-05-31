package com.ex.ranaranvijaysingh.testingdemo.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ex.ranaranvijaysingh.testingdemo.R;
import com.ex.ranaranvijaysingh.testingdemo.adapters.StudentAdapter;
import com.ex.ranaranvijaysingh.testingdemo.models.UserResponse;
import com.ex.ranaranvijaysingh.testingdemo.presenters.StudentPresenter;
import com.ex.ranaranvijaysingh.testingdemo.utilities.Constants;
import com.ex.ranaranvijaysingh.testingdemo.views.interfaces.StudentView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ex.ranaranvijaysingh.testingdemo.R.id.listViewStudent;

/**
 * Created by on 14/04/17.
 * Purpose of this class is to
 */

public class StudentActivity extends AppCompatActivity implements StudentView, AdapterView
        .OnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(listViewStudent)
    ListView mListViewStudent;
    private StudentPresenter mStudentPresenter;
    private StudentAdapter mStudentAdapter;

    public StudentAdapter getStudentAdapter() {
        return mStudentAdapter;
    }

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
        mListViewStudent.setOnItemClickListener(this);
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
                Toast.makeText(this, Constants.DummyData.NEW_ITEM_ADDED, Toast.LENGTH_SHORT).show();
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

    @Override
    public void showClickedItem(final String userName) {
        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(final AdapterView<?> parent, final View view, final int position,
                            final long id) {
        mStudentPresenter.presentClickedItem(position);
    }
}
