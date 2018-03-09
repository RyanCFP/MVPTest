package com.example.ryan.mvptest.presenter;

/**
 * Created by ryan on 17-9-26.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public interface IPresener {
    // TODO: 17-9-26 由IPresener 操控IUserMode 存储或保存数据
    // TODO: 17-9-26 由IPresener 获取IUserView 的数据传递给IUserMode保存
    void saveUser();

    // TODO: 17-9-26 由IPresener 获取IUserMode 的数据传给IUserView 更新界面数据
    void loadUser();
}
