package com.example.ryan.mvptest.presenter;

import android.util.Log;

import com.example.ryan.mvptest.mode.IUserMode;
import com.example.ryan.mvptest.mode.UserMode;
import com.example.ryan.mvptest.user.UserBean;
import com.example.ryan.mvptest.view.IUserView;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class Presener implements IPresener {
    private static final String TAG = Presener.class.getSimpleName();
    IUserMode usermode;
    IUserView userView;

    public Presener(IUserView userview){
        this.userView = userview;
        usermode =new UserMode();
    }

    @Override
    public void saveUser() {
        if(userView.getUsername() == null || userView.getPassword() == null){
            Log.i(TAG, "saveUser: 用户名或密码不能为空!!!!");
        }else{
            Log.i(TAG, "saveUser: userView.getUsername() ="+userView.getUsername());
            usermode.saveUser(userView.getID(),userView.getUsername(),userView.getPassword());
        }
    }

    @Override
    public void loadUser() {
        UserBean users=usermode.loadUser(userView.getID());
        if(users != null){
            Log.i(TAG, "loadUser: users.getUsername() ="+users.getUsername());
            userView.setUsername(users.getUsername());
            userView.setPassword(users.getPassword());
        }else Log.i(TAG, "loadUser: 该id 的用户不存在");
    }
}
