package com.example.ryan.mvptest.sample.base.login.view.student;

import android.text.TextUtils;
import android.util.Log;

import com.example.ryan.mvptest.sample.base.login.base.BasePresenter;

/**
 * Created by ryan on 17-9-27.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class StudentPresenter extends BasePresenter<OnStudentLisener> {
    private static final String TAG = StudentPresenter.class.getSimpleName();

    @Override
    public void attachView(OnStudentLisener mvpView) {super.attachView(mvpView);}

    @Override
    public void detachView() {super.detachView();}

    public void didStudentAdd(StudentMode studentMode){
        checkViewAttach();
        getMvpView().showLoading();

            if (!isEmpty(studentMode)) {
                Log.i(TAG, "didStudentAdd: nim or name or address is empty!!!");
                getMvpView().onError("didStudentAdd: nim or name or address is empty!!!");
            } else {
                Log.i(TAG, "didStudentAdd: ");
                getMvpView().onStudentAdd(studentMode);
            }

        getMvpView().hideLoading();
    }

    public boolean isEmpty(StudentMode studentMode){
        if(TextUtils.isEmpty(studentMode.nim)) return false;
        if(TextUtils.isEmpty(studentMode.name)) return false;
        if(TextUtils.isEmpty(studentMode.address)) return false;
        return true;
    }
}
