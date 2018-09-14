package com.jiuding.developer.zhihuishequ.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.bean.Users;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

import static com.jiuding.developer.zhihuishequ.R.id.username;

public class LoginActivity extends AppCompatActivity{

    @InjectView(R.id.cb_show_pwd)
    CheckBox cb_show_pwd;

    @InjectView(R.id.iv_back)
    ImageView iv_back;
    @InjectView(R.id.tv_register)
    TextView tv_register;
    @InjectView(username)
    EditText Ed_username;
    @InjectView(R.id.password)
    EditText Ed_password;
    @InjectView(R.id.quick_login_btn)
    Button quick_login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        ButterKnife.inject(this);

        ischeck();
    }

    private void ischeck() {

        cb_show_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Ed_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    Ed_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }


    @OnClick({R.id.iv_back,R.id.tv_register,R.id.quick_login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_register:
                Ed_username.setText("");
                Ed_password.setText("");
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.quick_login_btn:

                String username = Ed_username.getText().toString();
                String password = Ed_password.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,
                            "用户名与密码不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                final ProgressDialog progress = new ProgressDialog(LoginActivity.this);
                progress.setMessage("登录ing>->->");
                progress.setCanceledOnTouchOutside(false);
                progress.show();

                BmobUser.loginByAccount(username, password, new LogInListener<Users>() {
                    @Override
                    public void done(Users users, BmobException e) {

                        progress.dismiss();

                        if (e == null){
                            Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(LoginActivity.this,
                                    "登录失败：code="+e.getErrorCode()+
                                            "，错误描述："+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                });

                break;
        }
    }
}
