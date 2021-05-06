package cn.edu.hebtu.software.lifestyleservices_android.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.hebtu.software.lifestyleservices_android.ExpressActivity;
import cn.edu.hebtu.software.lifestyleservices_android.MainActivity;
import cn.edu.hebtu.software.lifestyleservices_android.R;
import cn.edu.hebtu.software.lifestyleservices_android.TakeoutActivity;

public class LoginActivity extends Activity {
    private ImageView login;
    private EditText etPassword = null;
    private ImageView ivShowPwd = null;
    private TextView change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etPassword = findViewById(R.id.et_login_password);
        etPassword.setInputType(129);
        login = findViewById(R.id.iv_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private class LoginActivityListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_login_show_pwd:
                    // 当当前 password 文本为 "明文" 形式
                    if (etPassword.getInputType() == 128) {
                        // 1. 将password 的输入框文本变为 "密码" 形式
                        etPassword.setInputType(129);
                        // 2. 将图片变为close
                        ivShowPwd.setImageResource(R.drawable.eye_close);
                    } else if (etPassword.getInputType() == 129) {   // 当前为 "密码" 格式
                        // 1. 变为文本格式
                        etPassword.setInputType(128);
                        // 2. 修改图片
                        ivShowPwd.setImageResource(R.drawable.eye_open);
                    }
            }
        }

    }
}
