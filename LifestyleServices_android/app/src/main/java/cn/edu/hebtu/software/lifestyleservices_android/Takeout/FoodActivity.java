package cn.edu.hebtu.software.lifestyleservices_android.Takeout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.lifestyleservices_android.R;


public class FoodActivity extends Activity {
    private List<Map<String,Object>> dataSource=null;
    private ListView listView;
    private FoodAdapter adapter;

    private  static TextView cheshu;
    private static TextView chemon;
    private Button food_jiesuan;
    private  ImageView iv_return;

   /* private ImageView car;
    private PopupWindow popupWindow=null;
    private View popupview=null;*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodkind_shouye);

        listView = findViewById(R.id.lv_records);
        cheshu=findViewById(R.id.cheshu);
        chemon=findViewById(R.id.chemon);
        food_jiesuan=findViewById(R.id.food_jiesuan);
        iv_return=findViewById(R.id.iv_return);
        //car=findViewById(R.id.btn_popup);

        initData();
        adapter = new FoodAdapter(FoodActivity.this, dataSource, R.layout.listview_foodkind_item);
        listView.setAdapter(adapter);

        iv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        food_jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodActivity.this, ConfirmOrderActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("datas", (Serializable) dataSource);
                intent.putExtras(bundle);
                intent.putExtra("zongjia", chemon.getText().toString());
                startActivity(intent);
            }
        });

      /*  car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popupWindow==null|| !popupWindow.isShowing())
                    showPopupWindow();
            }
        });*/
    }

   /* private void showPopupWindow() {
        //创建popupwindow对象
        popupWindow=new PopupWindow();
        popupWindow.setWidth(MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //通过布局填充器创建view
        popupview=getLayoutInflater().inflate(R.layout.popup_window,null);
        //设置popupwindow显示的内容视图
        popupWindow.setContentView(popupview);
        //设置popupwindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(false);
        //设置popupwindow是否响应点击事件
        popupWindow.setTouchable(true);
        //获取按钮并添加监听器
       *//* TextView clean_order=popupview.findViewById(R.id.clean_order);
        clean_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });*//*
        //  popupWindow.showAsDropDown(button,0,0);//偏移量
        // popupWindow.setHeight(MATCH_PARENT);
        // popupWindow.showAtLocation(findViewById(R.id.li, Gravity.NO_GRAVITY,0,0));
        popupWindow.showAsDropDown(car);

    }
*/

    private  void initData(){
        Log.e("111","111");
        int[] imgs={R.drawable.paigu,R.drawable.qiezi,R.drawable.lanhua,R.drawable.baishaocai,R.drawable.malaxiangguo,R.drawable.doujiao,R.drawable.laziji};
        String[] names={"红烧排骨","红烧茄子","素小炒","白芍菜","麻辣香锅","豆角","辣子鸡"};
        String[] numbers={"月售 200","月售  50","月售  70","月售 35","月售 107","月售 20","月售 67"};
        String[] prices={"10","7","6","5","10","5","9"};
        String[] geshus={"0","0","0","0","0","0","0"};
         dataSource=new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",imgs[i]);
            map.put("name",names[i]);
            map.put("number",numbers[i]);
            map.put("price",prices[i]);
            map.put("geshu",geshus[i]);
            dataSource.add(map);
        }
    }

    public static void countData( List<Map<String,Object>> dataSource){
        int sum=0;
        int psum=0;
        int sinnum;
        int sinprc;
        Log.e("数组长度",dataSource.size()+"");
        for(int i=0;i<dataSource.size();i++){
            Log.e("geshu数组",dataSource.get(i).get("geshu").toString());
            sinnum= Integer.parseInt(dataSource.get(i).get("geshu").toString());
            sinprc=Integer.parseInt(dataSource.get(i).get("price").toString());
            sum=sum+sinnum;
           psum=psum+sinnum*sinprc;
        }
        cheshu.setText(String.valueOf(sum));
        chemon.setText(String.valueOf(psum));
    }

}
