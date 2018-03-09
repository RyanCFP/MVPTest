package com.example.ryan.mvptest.sample.base.login.base;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public interface MvpView {

    void showLoading();
    void hideLoading();

    void onError(String message);
}
