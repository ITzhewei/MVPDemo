package com.example.john.mvpdemo.presenter;

import com.example.john.mvpdemo.model.User;
import com.example.john.mvpdemo.view.IView;

/**
 * Created by ZheWei on 2016/9/8.
 */
public class LoginPresenter implements IPresenter {

    IView mView;
    User mUser;

    public LoginPresenter(IView view) {
        mView = view;
        mUser = new User();
        mUser.user = "john";
        mUser.pass = "456";
    }

    @Override
    public void clear() {
        mView.onClearText();
    }

    @Override
    public void doLogin(String name, String pass) {
        boolean result = false;
        int code = 0;
        if (name.equals(mUser.user) && pass.equals(mUser.pass)) {
            result = true;
            code = 1;
        }
        mView.onLoginResult(result, code);
    }
}
