package com.example.ryan.mvptest.sample.base.login.view.login;


import android.text.TextUtils;
import android.util.Log;

import com.example.ryan.mvptest.sample.base.login.base.BasePresenter;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class LoginPresenter extends BasePresenter<OnLoginLisener> {
    private static final String TAG = LoginPresenter.class.getSimpleName();

    @Override
    public void attachView(OnLoginLisener mvpView) {super.attachView(mvpView);}

    @Override
    public void detachView() {super.detachView();}

    public void didLogin(LoginMode mode){
        Log.i(TAG, "didLogin: ");
        checkViewAttach();
        getMvpView().showLoading();

        if(!isEmpty(mode)){
            getMvpView().onError("email or password is empty!!!");
        }else{
            if(!isValidate(mode)){
                getMvpView().onError("用户名或密码不对!!!");
            }else {
                getMvpView().onLoginSuccess();
            }
        }
        getMvpView().hideLoading();
    }

    public boolean isValidate(LoginMode mode){
        Log.i(TAG, "isValidate: ");
        if(!mode.email.equalsIgnoreCase("user@example.com")) return false;
        if(!mode.password.equalsIgnoreCase("12345678")) return false;
        return true;
    }

    public boolean isEmpty(LoginMode mode){
        Log.i(TAG, "isEmpty: ");
        if(TextUtils.isEmpty(mode.email)) return false;
        if(TextUtils.isEmpty(mode.password)) return false;
        return true;
    }
}
