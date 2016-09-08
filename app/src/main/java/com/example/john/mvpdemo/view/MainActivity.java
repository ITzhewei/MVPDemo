package com.example.john.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.john.mvpdemo.R;
import com.example.john.mvpdemo.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.et_userName)
    EditText mEtUserName;
    @BindView(R.id.et_passWord)
    EditText mEtPassWord;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_clean)
    Button mBtnClean;

    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new LoginPresenter(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_clean})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.doLogin(mEtUserName.getText().toString().trim(), mEtPassWord.getText().toString().trim());
                break;
            case R.id.btn_clean:
                mPresenter.clear();
                break;
        }
    }

    @Override
    public void onClearText() {
        mEtUserName.setText("");
        mEtPassWord.setText("");
        Toast.makeText(MainActivity.this, "clear", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLoginResult(Boolean result, int code) {
        if (result) {
            Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

}
