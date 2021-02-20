package cn.edu.hebtu.software.lifestyleservices_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_takeout=findViewById(R.id.btn_takeout);
        Button button_express=findViewById(R.id.btn_express);
        button_takeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TakeoutActivity.class);
                startActivity(intent);
            }
        });
        button_express.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ExpressActivity.class);
                startActivity(intent);
            }
        });
    }
}
