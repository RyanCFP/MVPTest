package com.example.ryan.mvptest.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ryan.mvptest.R;
import com.example.ryan.mvptest.presenter.IPresener;
import com.example.ryan.mvptest.presenter.Presener;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class UserActivity extends Activity implements IUserView,View.OnClickListener {
    private static final String TAG = UserActivity.class.getSimpleName();
    private EditText id;
    private EditText name;
    private EditText pwd;
    private Button load;
    private Button save;
    IPresener presener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        presener = new Presener(this);
    }

    private void setupView() {
        id = findViewById(R.id.id);
        name = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        load = findViewById(R.id.load);
        save = findViewById(R.id.save);
        load.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public int getID() {
        return Integer.parseInt(id.getText().toString());
    }

    @Override
    public String getUsername() {
        return name.getText().toString();
    }

    @Override
    public String getPassword() {
        return pwd.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        name.setText(username);
    }

    @Override
    public void setPassword(String password) {
        pwd.setText(password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.load:
                Log.i(TAG, "onClick: load");
                presener.loadUser();
                break;
            case R.id.save:
                Log.i(TAG, "onClick: save");
                presener.saveUser();
                break;
        }
    }
}
