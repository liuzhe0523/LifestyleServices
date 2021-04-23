package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class AdviceActivity extends Activity {
    private Button cheng;
    private ImageView advice_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advice_wode);

        advice_return=findViewById(R.id.advice_return);
        cheng=findViewById(R.id.tijiao);

        advice_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
