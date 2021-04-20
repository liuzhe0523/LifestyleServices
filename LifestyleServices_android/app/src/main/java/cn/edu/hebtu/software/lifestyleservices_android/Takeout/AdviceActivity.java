package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class AdviceActivity extends Activity {
    private Button cheng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advice_wode);
        cheng=findViewById(R.id.tijiao);
        cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
