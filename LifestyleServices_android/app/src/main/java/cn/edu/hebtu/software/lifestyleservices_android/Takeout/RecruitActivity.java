package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class RecruitActivity extends Activity {
private Button bao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_wode);
        bao=findViewById(R.id.baoming);
        bao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecruitActivity.this, ApplyRecruitActivity.class);
                startActivity(intent);
            }
        });
    }
}
