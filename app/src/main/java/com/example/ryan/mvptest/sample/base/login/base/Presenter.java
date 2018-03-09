package com.example.ryan.mvptest.sample.base.login.base;

import com.example.ryan.mvptest.sample.base.login.base.MvpView;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);
    void detachView();
}
