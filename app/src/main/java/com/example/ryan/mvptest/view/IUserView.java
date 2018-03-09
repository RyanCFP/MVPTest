package com.example.ryan.mvptest.view;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public interface IUserView {
    int getID();
    String getUsername();
    String getPassword();

    void setUsername(String username);
    void setPassword(String password);
}
