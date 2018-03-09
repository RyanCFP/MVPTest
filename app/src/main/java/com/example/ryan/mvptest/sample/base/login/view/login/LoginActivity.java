package com.example.ryan.mvptest.sample.base.login.view.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.mvptest.R;
import com.example.ryan.mvptest.sample.base.login.view.student.StudentActivity;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class LoginActivity extends Activity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private LoginPresenter loginPresenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(onLoginLisener);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        ((Button)findViewById(R.id.login)).setOnClickListener(onClickLisener);
    }

    private View.OnClickListener onClickLisener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            LoginMode loginMode = new LoginMode();
            loginMode.email = ((EditText)findViewById(R.id.email)).getText().toString();
            loginMode.password = ((EditText)findViewById(R.id.password)).getText().toString();
            loginPresenter.didLogin(loginMode);
        }
    };

    private OnLoginLisener onLoginLisener = new OnLoginLisener() {
        @Override
        public void onLoginSuccess() {
            Log.i(TAG, "onLoginSuccess: ");
            startActivity(new Intent(LoginActivity.this, StudentActivity.class));
        }

        @Override
        public void showLoading() {
            // TODO: 17-9-26 show Dialog
            if(dialog != null) dialog.show();
        }

        @Override
        public void hideLoading() {
            // TODO: 17-9-26 hide dialog
            if(dialog != null) dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dialog != null) dialog = null;
        if(loginPresenter != null){
            loginPresenter.detachView();
            loginPresenter = null;
        }
    }
}
