package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class ConfirmOrderActivity extends Activity {
    private List<Map<String,Object>> dataSource;
    public  List<Map<String,Object>> updateData=new ArrayList<>();
    private ListView listView;
    private FoodOrderAdapter adapter;
    private ImageView con_return;
    private ImageView circle_fir;
    private ImageView circle_sec;
    private TextView  zong;
    private TextView con_dizhi;
    private  TextView con_phone;
    private Button con_chu;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_order);
        zong=findViewById(R.id.zongjia);
        con_return=findViewById(R.id.con_return);
        circle_fir=findViewById(R.id.circle_fir);
        circle_sec=findViewById(R.id.circle_sec);
        con_dizhi=findViewById(R.id.con_dizhi);
        con_phone=findViewById(R.id.con_phone);
        con_chu=findViewById(R.id.con_chu);

        dataSource = new ArrayList<>();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        dataSource = (List<Map<String, Object>>) bundle.getSerializable("datas");
        String zongjia = intent.getStringExtra("zongjia");
        int  a=Integer.parseInt(zongjia)+2;

        for(int i=0;i<dataSource.size();i++){
            Log.e("订单的data.size",dataSource.size()+"");
           if(Integer.parseInt(dataSource.get(i).get("geshu").toString())!=0){
               Map<String,Object> map=new HashMap<>();
              map=dataSource.get(i);
              updateData.add(map);
           }
        }

        listView=findViewById(R.id.lv_foods);
        adapter = new FoodOrderAdapter(ConfirmOrderActivity.this, updateData, R.layout.listview_orderfood_item);
        listView.setAdapter(adapter);
        zong.setText(String.valueOf(a));

       // con_dizhi.setText(AddressActivity.AddressdataSource.get(0).get("dizhi").toString());
      //  con_phone.setText(AddressActivity.AddressdataSource.get(0).get("phone").toString());

        con_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        circle_fir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circle_fir.setImageResource(R.drawable.cicle2);
                circle_sec.setImageResource(R.drawable.circle1);
            }
        });

        circle_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circle_sec.setImageResource(R.drawable.cicle2);
                circle_fir.setImageResource(R.drawable.circle1);
            }
        });
        con_chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();
            }
        });
    }

}
