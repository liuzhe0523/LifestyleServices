package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class ApplyRecruitActivity extends Activity {

    private Button cheng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_recruit);
        cheng=findViewById(R.id.tijiao);
        cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
