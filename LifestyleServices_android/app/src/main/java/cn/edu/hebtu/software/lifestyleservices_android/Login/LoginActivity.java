package cn.edu.hebtu.software.lifestyleservices_android.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.edu.hebtu.software.lifestyleservices_android.ExpressActivity;
import cn.edu.hebtu.software.lifestyleservices_android.MainActivity;
import cn.edu.hebtu.software.lifestyleservices_android.R;
import cn.edu.hebtu.software.lifestyleservices_android.TakeoutActivity;

public class LoginActivity extends Activity {
    private ImageView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.iv_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
