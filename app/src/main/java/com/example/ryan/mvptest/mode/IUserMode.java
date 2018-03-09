package com.example.ryan.mvptest.mode;

import com.example.ryan.mvptest.user.UserBean;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public interface IUserMode {

    void saveUser(int id,String username,String password);

    // TODO: 17-9-26 Load User from Mode  
    UserBean loadUser(int id);
}
