package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class RecruitActivity extends Activity {
    private List<Map<String,Object>> dataSource=null;
    private ListView listView;
    private  RecruitAdapter adapter;
    private ImageView apply_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_wode);
        listView = findViewById(R.id.lv_recruits);
        apply_return=findViewById(R.id.apply_return);
        initData();
        adapter = new RecruitAdapter(RecruitActivity.this, dataSource, R.layout.listview_recruit_item);
        listView.setAdapter(adapter);
        apply_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private  void initData(){
        Log.e("111","111");
        int[] imgs={R.drawable.touxiang1,R.drawable.touxiang2,R.drawable.touxiang3,R.drawable.touxiang4,R.drawable.touxiang5,R.drawable.touxiang};
        String[] employs={"教师助理","外卖骑手","图书管理员","食堂兼职","车辆管理员","业务处理员"};
        String[] prices={"30元一小时","20元一小时","30元一小时","15元一小时","15元一小时","15元一小时"};
        String[] needfs={"熟练使用office","责任心强","责任心强","中午11:00-1:00"," ","细心"};
        String[] needss={"业余时间较多","中午11:00-1:00","有耐心","晚上 17:00-19:00"," "," "};
        String[] teas={"邓资","楚天羽","孙女士","王丽","李华","张静"};
        String[] addresss={"软件学院","餐厅服务部","图书管理处","餐厅服务部","哈啰出行","信息业务中心"};
        dataSource=new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",imgs[i]);
            map.put("employ",employs[i]);
            map.put("price",prices[i]);
            map.put("needf",needfs[i]);
            map.put("needs",needss[i]);
            map.put("tea",teas[i]);
            map.put("address",addresss[i]);
            dataSource.add(map);
        }
    }
}
