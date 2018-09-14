package com.jiuding.developer.zhihuishequ.activity;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.jiuding.developer.zhihuishequ.R;
import com.jiuding.developer.zhihuishequ.bean.Users;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

    @InjectView(R.id.iv_re_back)
    ImageView iv_re_back;
    @InjectView(R.id.cb_Re_show_pwd)
    CheckBox cb_Re_show_pwd;
    @InjectView(R.id.et_photo)
    EditText et_photo;
    @InjectView(R.id.et_pwd)
    EditText et_pwd;
    @InjectView(R.id.et_re_pwd)
    EditText et_re_pwd;
    @InjectView(R.id.bt_get_check_code)
    Button bt_get_check_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);
        ButterKnife.inject(this);
        isCheck();
    }

    private void isCheck() {

        cb_Re_show_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }

    @OnClick({R.id.iv_re_back,R.id.bt_get_check_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_re_back:
                finish();
                break;
            case R.id.bt_get_check_code:

                final String phoneNum = et_photo.getText().toString();
                final String phonrPwd = et_pwd.getText().toString();
                final String phoneRePwd = et_re_pwd.getText().toString();

                if (TextUtils.isEmpty(phoneNum)){
                    Toast.makeText(RegisterActivity.this, "用户名不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phonrPwd)){
                    Toast.makeText(RegisterActivity.this, "密码不可以为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!phonrPwd.equals(phoneRePwd)){
                    Toast.makeText(RegisterActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                final ProgressDialog progress = new ProgressDialog(RegisterActivity.this);
                progress.setMessage("注册ing>->->");
                progress.setCanceledOnTouchOutside(false);
                progress.show();

                final Users users = new Users();
                users.setUsername(phoneNum);
                users.setPassword(phonrPwd);
                users.signUp(new SaveListener<Users>() {
                    @Override
                    public void done(Users users, BmobException e) {
                        progress.dismiss();
                        if (e == null){
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
        }
    }

}
