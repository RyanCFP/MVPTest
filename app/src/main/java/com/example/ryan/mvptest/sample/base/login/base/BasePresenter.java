package com.example.ryan.mvptest.sample.base.login.base;


import android.util.Log;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {
    private static final String TAG = BasePresenter.class.getSimpleName();

    private T mvpView;

    @Override
    public void attachView(T mvpView) {
        Log.i(TAG, "attachView: ");
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        Log.i(TAG, "detachView: ");
        this.mvpView = null;
    }

    public boolean isViewAttach(){return this.mvpView != null;}

    public T getMvpView(){return this.mvpView;}

    public void checkViewAttach(){
        Log.i(TAG, "checkViewAttach: ");
        if(!isViewAttach()) throw new MvpViewNotAttachedException();
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException(){
            super("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
            Log.i(TAG, "MvpViewNotAttachedException: MvpView出现非绑定异常!!!!");
        }
    }
}
