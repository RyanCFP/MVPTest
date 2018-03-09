package com.example.ryan.mvptest.sample.base.login.view.student;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.mvptest.R;
import com.example.ryan.mvptest.sample.base.login.MvpApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class StudentActivity extends Activity {
    private static final String TAG = StudentActivity.class.getSimpleName();
    private StudentAdapter mAdapter;
    private StudentPresenter presenter;
    private ArrayList<StudentMode> mDatas;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        presenter = new StudentPresenter();
        presenter.attachView(onStudentLisener);

        mDatas = new ArrayList<>();
        mAdapter = new StudentAdapter(mDatas,onStudentSelectedLisener);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MvpApplication.mContext));
//        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        ((Button)findViewById(R.id.add)).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.i(TAG, "onClick: ");
            StudentMode studentMode = new StudentMode();
            studentMode.nim = ((EditText)findViewById(R.id.nim)).getText().toString();
            studentMode.name = ((EditText)findViewById(R.id.name)).getText().toString();
            studentMode.address = ((EditText)findViewById(R.id.address)).getText().toString();

            presenter.didStudentAdd(studentMode);
        }
    };

    private OnStudentLisener onStudentLisener = new OnStudentLisener() {
        @Override
        public void onStudentAdd(StudentMode studentMode) {
            mDatas.add(studentMode);
            mAdapter.notifyDataSetChanged();
            Log.i(TAG, "onStudentAdd: ");
        }

        @Override
        public void showLoading() {
            // TODO: 17-9-27
        }

        @Override
        public void hideLoading() {}

        @Override
        public void onError(String message) {
            Toast.makeText(MvpApplication.mContext,message,Toast.LENGTH_LONG).show();
        }
    };

    private OnStudentSelectedLisener onStudentSelectedLisener = new OnStudentSelectedLisener() {
        @Override
        public void onSelected(int position) {
            Log.i(TAG, "onSelected: ");
            StudentMode studentMode = mDatas.get(position);
            Toast.makeText(MvpApplication.mContext,studentMode.name,Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        if(mDatas != null){
            mDatas.clear();
            mDatas = null;
        }
        if(mAdapter != null) mAdapter = null;
        if(presenter != null){
            presenter.detachView();
            presenter = null;
        }
    }
}
