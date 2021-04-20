package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;

public class FoodActivity extends Activity {
    private List<Map<String,Object>> dataSource=null;
    private ListView listView;
    private FoodAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodkind_shouye);
        listView = findViewById(R.id.lv_records);
        initData();
        adapter = new FoodAdapter(FoodActivity.this, dataSource, R.layout.listview_foodkind_item);
        listView.setAdapter(adapter);
    }


    private  void initData(){
        Log.e("111","111");
        int[] imgs={R.drawable.paigu,R.drawable.qiezi,R.drawable.lanhua,R.drawable.baishaocai,R.drawable.malaxiangguo,R.drawable.doujiao,R.drawable.laziji};
        String[] names={"红烧排骨","红烧茄子","素小炒","白芍菜","麻辣香锅","豆角","辣子鸡"};
        String[] numbers={"月售 200","月售  50","月售  70","月售 35","月售 107","月售 20","月售 67"};
        String[] prices={"￥ 10","￥ 7","￥ 6","￥ 5","￥10","￥5","￥9"};
         dataSource=new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",imgs[i]);
            map.put("name",names[i]);
            map.put("number",numbers[i]);
            map.put("price",prices[i]);
            dataSource.add(map);
        }
    }

}
