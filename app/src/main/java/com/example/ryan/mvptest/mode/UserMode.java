package com.example.ryan.mvptest.mode;

import android.util.Log;
import android.util.SparseArray;

import com.example.ryan.mvptest.user.UserBean;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class UserMode implements IUserMode {
    private static final String TAG = UserMode.class.getSimpleName();
    // TODO: 17-9-26 千兆条以下，数据性能比较好 ，以两个Object存储
    private SparseArray<UserBean> users=new SparseArray<UserBean>();
    
    @Override
    public void saveUser(int id, String username, String password) {
        UserBean userBean = new UserBean(username, password);
        users.append(id,userBean);
    }

    @Override
    public UserBean loadUser(int id) {
        if(users.indexOfKey(id)>=0) {
            Log.i(TAG, "loadUser: "+users.get(id).getUsername());
            return users.get(id);
        }else return null;
    }
}
